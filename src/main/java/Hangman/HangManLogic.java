package Hangman;

import java.util.ArrayList;

public class HangManLogic {
    //need categories
    //store categories and words


    public Category c1;
    public String currWord= "";

    public HangManLogic(){
        c1= new Category("Default");
        currWord= "";
    }
    public HangManLogic(Category c1){
        this.c1= c1;
        currWord= "";
    }
    public void setCategory(Category c1){
        this.c1= c1;
    }
    //need function to get word or something
    public String setWord(){

           currWord =  c1.list.pop();
            return currWord;
    }


    //need fucntion to check the position of a guess in the word
    ArrayList<Integer> checkGuess(char x){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i< currWord.length(); i++){
            if(currWord.charAt(i)==x){
                list.add(i);
            }
        }
        return list;
    }
}
