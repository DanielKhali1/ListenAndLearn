package Things;

import java.util.LinkedList;

import javafx.scene.control.Button;

public class Module 
{
	
	private Button myButton;
	private LinkedList<String> bigKeywords  = new LinkedList<String>();
	private LinkedList<Command> myCommands = new LinkedList<Command>();
	private boolean isSelected = false;
	
	
	public Module(String name)
	{
		setMyButton(new Button(name));
		
	}

	// getter
	public Button getMyButton() {return myButton;}
	public LinkedList<String> getBigKeywords() {return bigKeywords;}
	public LinkedList<Command> getMyCommands() {return myCommands;}
	public boolean isSelected() {return isSelected;}

	//setter
	public void setBigKeywords(LinkedList<String> bigKeywords) {this.bigKeywords = bigKeywords;}
	public void setMyButton(Button myButton) {this.myButton = myButton;}
	public void setMyCommands(LinkedList<Command> myCommands) {this.myCommands = myCommands;}
	public void setSelected(boolean isSelected) {this.isSelected = isSelected;}



}
