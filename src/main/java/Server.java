import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

import Hangman.GameUtil;
import Hangman.GameUtil.*;

import Hangman.Category;
import Hangman.HangManLogic;
import javafx.application.Platform;
import javafx.scene.control.ListView;
/*
 * Clicker: A: I really get it    B: No idea what you are talking about
 * C: kind of following
 */

public class Server{

    int count = 1;
    ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
    TheServer server;
    private Consumer<Serializable> callback;






    Server(Consumer<Serializable> call){

        callback = call;
        server = new TheServer();
        server.start();
        GameUtil.run();
    }


    public class TheServer extends Thread{

        public void run() {

            try(ServerSocket mysocket = new ServerSocket(5555);){
                System.out.println("Server is waiting for a client!");


                while(true) {

                    ClientThread c = new ClientThread(mysocket.accept(), count);
                    callback.accept("client has connected to server: " + "client #" + count);
                    clients.add(c);
                    c.start();

                    count++;

                }
            }//end of try
            catch(Exception e) {
                callback.accept("Server socket did not launch");
            }
        }//end of while
    }


    class ClientThread extends Thread{


        Socket connection;
        int count;
        ObjectInputStream in;
        ObjectOutputStream out;
        Category c1;
        HangManLogic hangManLogic;
        String cat;

        ClientThread(Socket s, int count){
            this.connection = s;
            this.count = count;
        }

        public void updateClients(String message) {
            for(int i = 0; i < clients.size(); i++) {
                ClientThread t = clients.get(i);
                try {
                    t.out.writeObject(message);
                }
                catch(Exception e) {}
            }
        }

        public void run(){

            try {
                in = new ObjectInputStream(connection.getInputStream());
                out = new ObjectOutputStream(connection.getOutputStream());
                connection.setTcpNoDelay(true);
            }
            catch(Exception e) {
                System.out.println("Streams not open");
            }

//            updateClients("new client on server: client #"+count);

            while(true) {
                try {
                    String data = in.readObject().toString();
                    callback.accept("client: " + count + " sent: " + data);
//                    updateClients("client #"+count+" sent: "+data);
                    //handle the data sent, and send response back to client
                    handleRequest(data);






                }
                catch(Exception e) {
                    callback.accept("OOOOPPs...Something wrong with the socket from client: " + count + "....closing down!");
                    updateClients("Client #"+count+" has left the server!");
                    clients.remove(this);
                    break;
                }
            }
        }//end of run
        public void handleRequest(String data){

            int index= data.indexOf(" ");
            String response= new String();


            cat= data.substring(index+1);
            if(data.contains("CATEGORY:")){
                c1=new Category(cat, GameUtil.map.get(cat));
                hangManLogic= new HangManLogic(c1);
                response= "LEN: "+ String.valueOf(hangManLogic.setWord().length());
                send(response);
                callback.accept("Server: "+response);
            }
            else if(data.contains("CHECK:")){
                response = new String("LOC: "+cat.charAt(0));
                ArrayList<Integer> list= hangManLogic.checkGuess(cat.charAt(0));
                for (int i=0; i< list.size(); i++) {

                    response= response+";"+String.valueOf(list.get(i));
                }
                if(list.size()==0){
                    response= response+";NIL";
                }
                send(response);
                callback.accept("Server: "+response);


            }




        }

        public void send(String data) {

            try {
                out.writeObject(data);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }//end of client thread

}






