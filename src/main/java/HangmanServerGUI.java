import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HangmanServerGUI extends Application {
	ListView<String> listItems;
	Server serverConnection;

	TextField portNo;
	Button submit;
	static int port;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		listItems = new ListView<String>();
		primaryStage.setTitle("Server");
		primaryStage.setScene(createLogInScene());
		primaryStage.show();
		submit.setOnAction(e->{
			port = Integer.valueOf(portNo.getText());
			serverConnection = new Server(data -> {
				Platform.runLater(()->{
					listItems.getItems().add(data.toString());
				});
			});
			primaryStage.setScene(createServerGui());
			primaryStage.show();
		});


		
				
		
	}

	public Scene createLogInScene(){
		Text t1= new Text("Enter Port Number");
		portNo= new TextField();
		submit= new Button("Submit");
		HBox row= new HBox(portNo, submit);
		VBox col = new VBox(t1, row);
		BorderPane pane = new BorderPane();
		pane.setCenter(col);
		col.setAlignment(Pos.CENTER);
		row.setAlignment(Pos.CENTER);
		return new Scene(pane, 500, 400);
	}

	public Scene createServerGui() {
		Text t1= new Text("Activity Log");
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(70));
		pane.setStyle("-fx-background-color: coral");
		VBox vBox= new VBox(t1, listItems);
		pane.setCenter(vBox);

		return new Scene(pane, 500, 400);


	}

}
