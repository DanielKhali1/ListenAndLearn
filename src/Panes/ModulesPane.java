package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.LinkedList;

import Things.Command;
import Things.Module;

public class ModulesPane extends Pane
{
	VBox scrollBoi = new VBox();
	ScrollPane scrollpane;

	private LinkedList<Module> modules = new LinkedList<Module>();
	
	Pane commands; 

	
	public ModulesPane(ScrollPane scroll, ScrollPane CommandScroll)
	{
		commands = new CommandsPane(CommandScroll);
		commands.setLayoutX(commands.getLayoutX()-20);
		commands.setLayoutY(commands.getLayoutY()-40);
		getChildren().add(commands);

		scrollpane = scroll;
		
		setLayoutX(20);
		setLayoutY(40);
		setStyle("-fx-background-color: '#363636'");
		setPrefSize(250, 600);
		
		Text title = new Text("Modules");
		title.setLayoutX(85);
		title.setLayoutY(30);
		getChildren().add(title);
		title.setFill(Color.WHITE);
		title.setStyle("-fx-font-size: 20");
		
		scrollpane.setLayoutX(20);
		scrollpane.setLayoutY(40);
		scrollpane.setPrefSize(210, 520);
		scrollpane.setStyle("-fx-background-color: 'black';");
		getChildren().add(scrollpane);
		
		scrollpane.setContent(scrollBoi);
		scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		
		scrollBoi.setStyle("-fx-background-color: '#242424';");
		scrollBoi.setLayoutX(20);
		scrollBoi.setLayoutY(40);
		scrollBoi.setPrefSize(207, 517);
	}
	
	public void AddModule()
	{
		String tempName = " New Module ";
		int count = 1;
		for(int i = 0; i < getModules().size(); i++)
		{
			if(tempName.equals(getModules().get(i).getMyButton().getText()))
			{
				count++;
				tempName = " New Module " + count;
			}
		}
		
		Module tempMod = new Module(tempName);
		tempMod.getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; -fx-padding: 30;"); 
		
		tempMod.getMyButton().setPrefSize(300, 100);
		getModules().add(tempMod);

		tempMod.getMyButton().setOnAction( e->{
			
			tempMod.setSelected(!tempMod.isSelected());
			
				if(tempMod.isSelected())
				{
					((CommandsPane) commands).SelectedModule(tempMod);
					((CommandsPane) commands).updateCommands();

					
					tempMod.getMyButton().setStyle("-fx-background-color: 'white'; -fx-text-fill: '#363636'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; -fx-padding: 30;");
					for(int i = 0; i < getModules().size(); i++)
					{
						if(getModules().get(i).equals(tempMod))
							continue;
						else
						{
							getModules().get(i).setSelected(false);
							getModules().get(i).getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; -fx-padding: 30;"); 
						}
					}
				}
				else
				{
					((CommandsPane) commands).ClearPane();
					tempMod.getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; -fx-padding: 30;"); 
				}
		});
				
		scrollBoi.getChildren().add(tempMod.getMyButton());

	}
	
	public void DeleteModule()
	{
		for(int i = 0; i < getModules().size(); i++)
		{
			if(getModules().get(i).isSelected())
			{
				scrollBoi.getChildren().remove(getModules().get(i).getMyButton());
				getModules().remove(i);
				
			}
		}
	}
	
	public void clearCommandPane()
	{
		((CommandsPane) commands).ClearPane();
	}
	
	
	public void addCommand(Module Mod)
	{

		String tempName = " New Command ";
		int count = 1;
		for(int i = 0; i < Mod.getMyCommands().size(); i++)
		{
			if(tempName.equals(Mod.getMyCommands().get(i).getMyButton().getText()))
			{
				count++;
				tempName = " New Command " + count;
			}
		}
		Command tempCommand = new Command(tempName); 
		Mod.getMyCommands().add(tempCommand);

		tempCommand.getMyButton().setPrefSize(348, 40);
		tempCommand.getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black;");
		
		tempCommand.getMyButton().setOnAction(e->{
			
			tempCommand.setSelected(!tempCommand.isSelected());
			
			if(tempCommand.isSelected())
			{
//				((CommandsPane) commands).SelectedModule(tempMod);
//				((CommandsPane) commands).updateCommands();
				for(int i = 0; i < Mod.getMyCommands().size(); i++)
				{
						
						Mod.getMyCommands().get(i).setSelected(false);
						Mod.getMyCommands().get(i).getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; "); 
				}
				
				for(int i = 0; i < Mod.getMyCommands().size(); i++)
				{
					System.out.println(Mod.getMyCommands().get(i).isSelected());
				}
				System.out.println();

				tempCommand.setSelected(true);
				tempCommand.getMyButton().setStyle("-fx-background-color: 'white'; -fx-text-fill: '#363636'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; ");

			}
			else
			{
				//((CommandsPane) commands).ClearPane();
				tempCommand.getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; "); 
			}
		});
		
		
		((CommandsPane) commands).updateCommands();
	}

	public LinkedList<Module> getModules() {return modules;}
	public void setModules(LinkedList<Module> modules) {this.modules = modules;}
	
	
	
}

