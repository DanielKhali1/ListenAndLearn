package Things;
import java.util.LinkedList;

import javafx.scene.control.Button;


public class Command 
{
	private Button myButton;
	
	private LinkedList<String> KeyWords = new LinkedList<String>();
	private LinkedList<String> responses = new LinkedList<String>();
	private boolean isSelected = false;
	
	public Command(String name)
	{
		setMyButton(new Button(name));
	}


	public LinkedList<String> getKeyWords() {return KeyWords;}
	public LinkedList<String> getResponses() {return responses;}


	public void setKeyWords(LinkedList<String> keyWords) {KeyWords = keyWords;}
	public void setResponses(LinkedList<String> responses) {this.responses = responses;}


	public Button getMyButton() {
		return myButton;
	}


	public void setMyButton(Button myButton) {
		this.myButton = myButton;
	}


	public boolean isSelected() {
		return isSelected;
	}


	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	

}
