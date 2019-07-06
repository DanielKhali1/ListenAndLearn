package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import Things.Command;
import Things.KeyWords;
import Things.Module;

public class ModulesPane extends Pane
{
	VBox scrollBoi = new VBox();
	ScrollPane scrollpane;

	private LinkedList<Module> modules = new LinkedList<Module>();
	
	Pane commands; 

	
	public ModulesPane(ScrollPane scroll, ScrollPane CommandScroll, ScrollPane keyWords, ScrollPane Responses)
	{
		setupModulesFromFile();
		
		commands = new CommandsPane(CommandScroll, keyWords, Responses);
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
	
	
	public void AddModule(Module tempMod)
	{
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
				((CommandsPane) commands).SelectedCommand(tempCommand);
				((CommandsPane) commands).updateCommandContents();
				for(int i = 0; i < Mod.getMyCommands().size(); i++)
				{
						
						Mod.getMyCommands().get(i).setSelected(false);
						Mod.getMyCommands().get(i).getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; "); 
				}
				
				for(int i = 0; i < Mod.getMyCommands().size(); i++)
				{
				}

				tempCommand.setSelected(true);
				tempCommand.getMyButton().setStyle("-fx-background-color: 'white'; -fx-text-fill: '#363636'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; ");

			}
			else
			{
				((CommandsPane) commands).currentCommandPane.clear();
				tempCommand.getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; "); 
			}
		});
		
		
		((CommandsPane) commands).updateCommands();
	}
	
	public void addCommand(Module Mod, Command tempCommand)
	{

		Mod.getMyCommands().add(tempCommand);

		tempCommand.getMyButton().setPrefSize(348, 40);
		tempCommand.getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black;");
		
		tempCommand.getMyButton().setOnAction(e->{
			
			tempCommand.setSelected(!tempCommand.isSelected());
			
			if(tempCommand.isSelected())
			{
				((CommandsPane) commands).SelectedCommand(tempCommand);
				((CommandsPane) commands).updateCommandContents();
				for(int i = 0; i < Mod.getMyCommands().size(); i++)
				{
						
						Mod.getMyCommands().get(i).setSelected(false);
						Mod.getMyCommands().get(i).getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; "); 
				}
				
				for(int i = 0; i < Mod.getMyCommands().size(); i++)
				{
				}

				tempCommand.setSelected(true);
				tempCommand.getMyButton().setStyle("-fx-background-color: 'white'; -fx-text-fill: '#363636'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; ");

			}
			else
			{
				((CommandsPane) commands).currentCommandPane.clear();
				tempCommand.getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; "); 
			}
		});
		
		
 
	}
	
	public void DeleteCommand(Module mod, Command command)
	{

		for(int i = 0; i < getModules().size(); i++)
		{
			if(getModules().get(i).isSelected())
			{
				for(int j = 0; j < getModules().get(i).getMyCommands().size(); j++)
				{
					if(getModules().get(i).getMyCommands().get(j).isSelected())
					{
						CommandsPane.scrollBoi.getChildren().remove(getModules().get(i).getMyCommands().get(j).getMyButton());
						getModules().get(i).getMyCommands().remove(j);
						((CommandsPane) commands).currentCommandPane.clear();
					}
				}
			}
		}

	}

	public void setupModulesFromFile()
	{
		ArrayList<String> data = new ArrayList<String>();
		File knowledge = new File("knowledge.txt");

		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(knowledge));
			String line = reader.readLine();

			while(line != null)
			{
				data.add(line);

				line = reader.readLine();
			}
			reader.close();
		}
		catch(IOException e)
		{

			e.printStackTrace();
		}
		
		for(int i = 0; i < data.size(); i++)
		{
			System.out.println(data.get(i));
		}
		
		int i = 0;
		
			while(data.get(i).contains("Mod"))
			{

				Module tempMod = new Module(data.get(i).substring(data.get(i).indexOf(':')+1));
				i++;
				
				
				while(data.get(i).contains("Command"))
				{
					Command tempCommand = new Command(data.get(i).substring(data.get(i).indexOf(':')+1));
					i++;
					String[] splitKeywords = data.get(i).split(",");
					for(int j = 0; j < splitKeywords.length; j++)
					{
						KeyWords tempKeyWord = new KeyWords();
						tempKeyWord.tempTextField.setText(splitKeywords[j]);
						tempCommand.getKeyWords().add(tempKeyWord);
					}
					i++;
					String[] splitResponses = data.get(i).split(",");
					for(int j = 0; j < splitResponses.length; j++)
					{
						KeyWords tempResponse = new KeyWords();
						tempResponse.tempTextField.setText(splitResponses[j]);
						tempCommand.getResponses().add(tempResponse);
					}
					//tempMod.getMyCommands().add(tempCommand);
					addCommand(tempMod, tempCommand);
					
					if(data.size() <= i+1)
					{
						break;
					}
					else
					{
						i++;
					}
				}
				
				AddModule(tempMod);
				//addModuleToThign
				
			
			}
			
				
		}
		
	
	public LinkedList<Module> getModules() {return modules;}
	public void setModules(LinkedList<Module> modules) {this.modules = modules;}
	

	
}

