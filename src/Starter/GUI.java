package Starter;

import Panes.MasterPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.ScrollPane;


public class GUI extends Application
{
	public static void main(String[] args){launch(args);}
	public int requestCounter;

	ScrollPane scrollpane = new ScrollPane();
	ScrollPane commandScroll = new ScrollPane();
	ScrollPane keyWords = new ScrollPane();
	ScrollPane Responses = new ScrollPane();

	
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setOnShown(e ->{
			commandScroll.lookup(".viewport").setStyle("-fx-background-color: 'transparent';");
			scrollpane.lookup(".viewport").setStyle("-fx-background-color: 'transparent';");
			keyWords.lookup(".viewport").setStyle("-fx-background-color: 'transparent';");
			Responses.lookup(".viewport").setStyle("-fx-background-color: 'transparent';");
		});
		
		Pane masterPane = new MasterPane(scrollpane, commandScroll, keyWords, Responses);
		Scene scene = new Scene(masterPane, 720+400, 720);
		primaryStage.setTitle("WIIB Module Engine");
		primaryStage.getIcons().add(new Image(GUI.class.getResourceAsStream("/imgs/wiibIcon.png")));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}

