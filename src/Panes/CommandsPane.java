package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;
import Things.Command;
import Things.Module;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;



public class CommandsPane extends Pane
{
	public static VBox scrollBoi = new VBox();
	TextField tfModuleName = new TextField();
	
	ScrollPane scrollpane;
	public CurrentCommandPane currentCommandPane;
	
	
	Module currentmod;
	
	public CommandsPane(ScrollPane scroll, ScrollPane keyWords, ScrollPane Responses)
	{
		
		currentCommandPane = new CurrentCommandPane(new Command(""), keyWords, Responses); 
		scrollpane = scroll;
		scrollpane.setStyle("-fx-background-color: '#242424';");
		setLayoutX(300);
		setLayoutY(110);
		setStyle("-fx-background-color: '#363636'");
		setPrefSize(400, 590);
		
	
		tfModuleName.setLayoutX(25);
		tfModuleName.setLayoutY(25);
		tfModuleName.setPrefSize(350, 30);
		tfModuleName.setStyle("-fx-background-color: '#242424'; -fx-text-fill: 'white'; -fx-font-size: 20;");
		getChildren().add(tfModuleName);
		
		Text title1 = new Text("Commands");
		title1.setLayoutX(150);
		title1.setLayoutY(30+70);
		getChildren().add(title1);
		title1.setFill(Color.WHITE);
		title1.setStyle("-fx-font-size: 20");
		
		scrollpane.setLayoutX(25);
		scrollpane.setLayoutY(40+70);
		scrollpane.setPrefSize(350, 450);
		getChildren().add(scrollpane);
		scrollpane.setContent(scrollBoi);
		scrollBoi.setStyle("-fx-background-color: '#242424';");
		scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	
		getChildren().add(currentCommandPane);
		
	}
	
	public void SelectedCommand(Command com)
	{
		currentCommandPane.setMycommand(com);
	}
	
	public void updateCommandContents()
	{
		currentCommandPane.update();
	}
	
	
	
	
	public void SelectedModule(Module mod)
	{
		currentmod = mod;
		
		tfModuleName.setText(mod.getMyButton().getText());
		
		tfModuleName.setOnKeyPressed( e->
		{
			mod.getMyButton().setText(tfModuleName.getText());
		});
		tfModuleName.setOnKeyReleased( e->
		{
			mod.getMyButton().setText(tfModuleName.getText());
		});
		
		for(int i = 0; i < mod.getMyCommands().size(); i++)
		{
			mod.getMyCommands().get(i).setSelected(false);
			updateCommands();
		}
		
		for(Command tempCommand : mod.getMyCommands())
		{
			if(tempCommand.isSelected())
			{
				SelectedCommand(tempCommand);
				updateCommandContents();
				for(int i = 0; i < mod.getMyCommands().size(); i++)
				{
						
					mod.getMyCommands().get(i).setSelected(false);
					mod.getMyCommands().get(i).getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; "); 
				}
				
				for(int i = 0; i < mod.getMyCommands().size(); i++)
				{
				}
	
				tempCommand.setSelected(true);
				tempCommand.getMyButton().setStyle("-fx-background-color: 'white'; -fx-text-fill: '#363636'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; ");
	
			}
			else
			{
				currentCommandPane.clear();
				tempCommand.getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; "); 
			}
		}
		
		currentCommandPane.clear();
	}
	
	public void ClearPane()
	{
		tfModuleName.setText("");
		scrollBoi.getChildren().clear();
		
	}
	
	public void updateCommands()
	{
		scrollBoi.getChildren().clear();

		for(int i = 0; i < currentmod.getMyCommands().size(); i++)
		{
			scrollBoi.getChildren().add(currentmod.getMyCommands().get(i).getMyButton());
		}
	}

}