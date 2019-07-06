package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;

import java.util.LinkedList;

import Things.Command;
import Things.KeyWords;
import Things.Module;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class CurrentCommandPane extends Pane
{
	ScrollPane scrollPaneKeywords;
	ScrollPane scrollPaneResponses;
	VBox scrollMeatKeyWords = new VBox();
	VBox scrollMeatResponses = new VBox();
	private Command mycommand;
	TextField tfCommandName;
		
	public CurrentCommandPane(Command command , ScrollPane keyWords, ScrollPane Responses)
	{
		scrollPaneKeywords = keyWords;
		scrollPaneResponses = Responses;
		
		setMycommand(command);
		setPrefSize(350, 660);
		setLayoutX(435);
		setLayoutY(-70);
		setStyle("-fx-background-color: '#363636';");
	
		scrollPaneKeywords.setStyle("-fx-background-color: '#242424';");
		scrollPaneResponses.setStyle("-fx-background-color: '#242424';");
		tfCommandName = new TextField(mycommand.getMyButton().getText());
		tfCommandName.setLayoutX(10);
		tfCommandName.setLayoutY(10);
		tfCommandName.setPrefSize(330, 30);
		tfCommandName.setStyle("-fx-background-color: '#242424'; -fx-text-fill: 'white'; -fx-font-size: 20;");

		tfCommandName.setOnKeyPressed( e->
		{
			mycommand.getMyButton().setText(tfCommandName.getText());
		});
		tfCommandName.setOnKeyReleased( e->
		{
			mycommand.getMyButton().setText(tfCommandName.getText());
		});
		
		getChildren().add(tfCommandName);
		
		
		
		Button addKeyWord = new Button("+");
		addKeyWord.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8';");

		addKeyWord.setLayoutX(125+130);
		addKeyWord.setLayoutY(20+50);
		getChildren().add(addKeyWord);
		
		addKeyWord.setOnMouseEntered(e ->
		{
			addKeyWord.setStyle("-fx-background-color: '#c8c8c8'; -fx-text-fill: '#242424'; ");
		});
		addKeyWord.setOnMouseExited(e ->
		{
			addKeyWord.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; ");
		});
		
		
		addKeyWord.setOnAction( e->
		{
			if(mycommand.isSelected())
			{
				mycommand.getKeyWords().add(new KeyWords());
			
				update();
			}
		});
		
		Button removeKeyWord = new Button(" - ");
		removeKeyWord.setLayoutX(125+160);
		removeKeyWord.setLayoutY(20+50);
		getChildren().add(removeKeyWord);
		removeKeyWord.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8';");

		
		removeKeyWord.setOnMouseEntered(e ->
		{
			removeKeyWord.setStyle("-fx-background-color: '#c8c8c8'; -fx-text-fill: '#242424'; ");
		});
		removeKeyWord.setOnMouseExited(e ->
		{
			removeKeyWord.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; ");
		});
		
		removeKeyWord.setOnAction( a ->
		{
			for(int i = 0; i < mycommand.getKeyWords().size(); i++)
			{
				if(mycommand.getKeyWords().get(i).selected)
				{
					mycommand.getKeyWords().remove(i);
					i--;
				}
			}
			update();
		});
					
		
		
		Text txtKeyWords = new Text("Key Words");
		txtKeyWords.setLayoutX(125);
		txtKeyWords.setLayoutY(40+50);
		txtKeyWords.setFill(Color.WHITE);
		txtKeyWords.setStyle("-fx-font-size: 20; ");
		getChildren().add(txtKeyWords);
		
		Button addResponse = new Button("+");
		addResponse.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8';");

		addResponse.setLayoutX(125+130);
		addResponse.setLayoutY(20+350);
		getChildren().add(addResponse);
		
		addResponse.setOnMouseEntered(e ->
		{
			addResponse.setStyle("-fx-background-color: '#c8c8c8'; -fx-text-fill: '#242424'; ");
		});
		addResponse.setOnMouseExited(e ->
		{
			addResponse.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; ");
		});
		
		
		addResponse.setOnAction( e->
		{
			if(mycommand.isSelected())
			{
				mycommand.getResponses().add(new KeyWords());
			
				update();
			}
		});
		
		Button removeResponse = new Button(" - ");
		removeResponse.setLayoutX(125+160);
		removeResponse.setLayoutY(20+350);
		getChildren().add(removeResponse);
		removeResponse.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8';");

		
		removeResponse.setOnMouseEntered(e ->
		{
			removeResponse.setStyle("-fx-background-color: '#c8c8c8'; -fx-text-fill: '#242424'; ");
		});
		removeResponse.setOnMouseExited(e ->
		{
			removeResponse.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; ");
		});
		
		removeResponse.setOnAction( a ->
		{
			for(int i = 0; i < mycommand.getResponses().size(); i++)
			{
				if(mycommand.getResponses().get(i).selected)
				{
					mycommand.getResponses().remove(i);
					i--;
				}
			}
			update();
		});
		
		
		scrollPaneKeywords.setLayoutX(30);
		scrollPaneKeywords.setLayoutY(50+50);
		scrollPaneKeywords.setContent(scrollMeatKeyWords);
		scrollPaneKeywords.setPrefSize(290, 250);
		scrollPaneKeywords.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		getChildren().add(scrollPaneKeywords);
		
		scrollPaneResponses.setLayoutX(30);
		scrollPaneResponses.setLayoutY(50+350);
		scrollPaneResponses.setContent(scrollMeatResponses);
		scrollPaneResponses.setPrefSize(290, 250);
		scrollPaneResponses.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		getChildren().add(scrollPaneResponses);
		
		Text txtResponses = new Text("Responses");
		txtResponses.setLayoutX(125);
		txtResponses.setLayoutY(40+300+50);
		txtResponses.setFill(Color.WHITE);
		txtResponses.setStyle("-fx-font-size: 20; ");
		getChildren().add(txtResponses);
		
	
	}
	
	public Command getMycommand() {
		return mycommand;
	}

	public void setMycommand(Command mycommand) {
		this.mycommand = mycommand;
	}
	
	public void clear()
	{
		scrollMeatKeyWords.getChildren().clear();
		scrollMeatResponses.getChildren().clear();
		tfCommandName.setText("");

	}
	
	public void update()
	{
		scrollMeatKeyWords.getChildren().clear();
		scrollMeatResponses.getChildren().clear();
		for(int i = 0; i < mycommand.getResponses().size(); i++)
		{
			scrollMeatResponses.getChildren().add(mycommand.getResponses().get(i).getTempPane());
		}
		
		for(int i = 0; i < mycommand.getKeyWords().size(); i++)
		{
			scrollMeatKeyWords.getChildren().add(mycommand.getKeyWords().get(i).getTempPane());
		}
		tfCommandName.setText(mycommand.getMyButton().getText());

	}
	
}
