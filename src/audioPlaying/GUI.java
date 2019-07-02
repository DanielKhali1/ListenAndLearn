package audioPlaying;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.application.Platform;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.Timeline;
import javafx.scene.media.AudioClip;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class GUI extends Application
{
	TextField tfseconds = new TextField("3");

	private final ExecutorService exec = Executors.newCachedThreadPool();
	public static void main(String[] args){launch(args);}
	
	
	public int requestCounter;
		

	@Override
	public void start(Stage primaryStage)
	{

		
		Pane pane = new Pane();
		
		
		
		tfseconds.setLayoutX(50);
		tfseconds.setLayoutY(60);
		tfseconds.setPrefColumnCount(10);
		tfseconds.setPrefWidth(30);
		
		File secondsFile = new File("seconds.txt");
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(secondsFile));
			String secondsString = br.readLine();
			if(secondsString == null)
			{
				tfseconds.setText("3");
			}
			else
			{
				tfseconds.setText(secondsString);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("couldn't read file");
		}
		
		
		pane.getChildren().add(tfseconds);
	
		//text about recording button
		Text txtRecord = new Text("Record Audio");
		txtRecord.setLayoutX(50);
		txtRecord.setLayoutY(50);
		pane.getChildren().add(txtRecord);
		
		Image imgRecBtn = new Image("recordingButton.png");
		ImageView RecBtn = new ImageView(imgRecBtn);
		
		RecBtn.setLayoutX(50);
		RecBtn.setLayoutY(100);
		RecBtn.setFitWidth(75);
		RecBtn.setFitHeight(75);
		RecBtn.setSmooth(true);
		pane.getChildren().add(RecBtn);
		
		RecBtn.setOnMouseEntered( e->{
			RecBtn.setFitWidth(85);
			RecBtn.setFitHeight(85);
		});
		RecBtn.setOnMouseExited( e->{
			RecBtn.setFitWidth(75);
			RecBtn.setFitHeight(75);
		});
		
		
		Button setButton = new Button("Set");
		setButton.setLayoutX(90);
		setButton.setLayoutY(60);
		pane.getChildren().add(setButton);
		
		
		setButton.setOnAction( e ->
		{
			String seconds = tfseconds.getText();
			
			try
			{
	        BufferedWriter writer = new BufferedWriter(new FileWriter("seconds.txt"));
	        writer.write(seconds);
	         
	        writer.close();
			}
			catch(Exception a)
			{
				System.out.println("you fucked up");
			}
		});
		
		
		Button playButton = new Button("play");
		playButton.setLayoutX(200);
		playButton.setLayoutY(60);
		pane.getChildren().add(playButton);
		
		
		playButton.setOnAction(e ->
		{
		
			//AudioClip soundMyNoise = new AudioClip(new File("output.wav").toURI().toString());
			//soundMyNoise.play();
			
			new Thread(new Runnable() {

			    @Override
			    public void run() {
						try {
							String command = "python C:\\Users\\Danny\\Documents\\GitHub\\ListenAndLearn\\playoutput.py";
							
							try {
								Runtime.getRuntime().exec(command);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("I didn't work");
								e.printStackTrace();
							}
							
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


						Platform.runLater(new Runnable() {

			            @Override
			            public void run()
			            {
			            	System.out.println("Started Recording");
			            }
			        });
			    }
			}).start();
			
		});
		
		RecBtn.setOnMouseClicked(e->
		{
			executeAudioListener();
		});
		
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("Audio Catcher");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void executeAudioListener()
	{
		new Thread(new Runnable() {

		    @Override
		    public void run() {
					try {
						String command = "python C:\\Users\\Danny\\Documents\\GitHub\\ListenAndLearn\\audioRecorder.py";
						
						try {
							Runtime.getRuntime().exec(command);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("I didn't work");
							e.printStackTrace();
						}
						
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


					Platform.runLater(new Runnable() {

		            @Override
		            public void run()
		            {
		            	System.out.println("Started Recording");
		            }
		        });
		    }
		}).start();
            


	}
	
}
