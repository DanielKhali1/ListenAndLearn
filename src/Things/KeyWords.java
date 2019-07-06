package Things;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class KeyWords {
	private Pane tempPane = new Pane();
	public TextField tempTextField = new TextField("Temporary Title");
	public Circle radioButton = new Circle(10);
	public boolean selected = false;
	public String key;
	
	public KeyWords()
	{
		getTempPane().setPrefSize(290, 40);
		tempTextField.setLayoutX(50);
		tempTextField.setLayoutY(7);
		tempTextField.setPrefWidth(200);
		tempTextField.setStyle("-fx-background-color: '#363636'; -fx-text-fill: white;");
		getTempPane().getChildren().add(tempTextField);
		getTempPane().setStyle("-fx-background-color: '#242424'; -fx-border-width: 1; -fx-border-color: black;");
		
		radioButton.setStroke(Color.WHITE);
		radioButton.setFill(Color.TRANSPARENT);
		radioButton.setLayoutX(20);
		radioButton.setLayoutY(20);
		getTempPane().getChildren().add(radioButton);
		
		radioButton.setOnMouseClicked( a ->{
			
			if(radioButton.getFill().equals(Color.GREEN))
			{
				radioButton.setFill(Color.TRANSPARENT);
				selected = false;
			}
			else
			{
				radioButton.setFill(Color.GREEN);
				selected = true;
			}	
		});
		
		tempTextField.setOnKeyPressed( a ->{
			key = tempTextField.getText();
		});
		tempTextField.setOnKeyReleased( a ->{
			key = tempTextField.getText();
		});
	}
	
	public void setKeyWord(String keyword)
	{
		tempTextField.setText(keyword);
	}

	public Pane getTempPane() {
		return tempPane;
	}

	public void setTempPane(Pane tempPane) {
		this.tempPane = tempPane;
	}
}
