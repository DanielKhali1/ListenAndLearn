package Things;
import java.util.LinkedList;

import javafx.scene.control.Button;


public class Command 
{
	private Button myButton;
	
	private LinkedList<KeyWords> KeyWords = new LinkedList<KeyWords>();
	private LinkedList<KeyWords> responses = new LinkedList<KeyWords>();
	private boolean isSelected = false;
	
	public Command(String name)
	{
		setMyButton(new Button(name));
	}


	public LinkedList<KeyWords> getKeyWords() {return KeyWords;}
	public LinkedList<KeyWords> getResponses() {return responses;}


	public void setKeyWords(LinkedList<KeyWords> keyWords) {KeyWords = keyWords;}
	public void setResponses(LinkedList<KeyWords> responses) {this.responses = responses;}


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
