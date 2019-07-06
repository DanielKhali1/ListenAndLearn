package Panes;

import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.shape.Circle;



public class MasterPane extends Pane
{
	Pane modules;

	Button NewModule = new Button("New Module");
	Button NewCommand = new Button("New Command");
	Button DeleteModule = new Button("   Delete   ");
	Button DeleteCommands = new Button("    Delete    ");
	Button Update = new Button("  Update  ");
	Circle needToUpdate;
	
	public MasterPane(ScrollPane scroll, ScrollPane commandScroll, ScrollPane keyWords, ScrollPane Responses)
	{

		modules = new ModulesPane(scroll, commandScroll, keyWords, Responses);
		getChildren().add(modules);
		setupButtons();
		buttonClickActions();
		setStyle("-fx-background-color: '#4d4d4d'");
		

	
	}
	
	public void buttonClickActions()
	{
		NewModule.setOnAction(e ->
		{
			needToUpdate.setVisible(true);

			((ModulesPane) modules).AddModule();
		});
		NewCommand.setOnAction(e ->
		{
			needToUpdate.setVisible(true);

			for(int i = 0; i < ((ModulesPane) modules).getModules().size(); i++)
			{
				if(((ModulesPane) modules).getModules().get(i).isSelected())
				{
					((ModulesPane)modules).addCommand(((ModulesPane) modules).getModules().get(i));
				}
			}
		});
		DeleteModule.setOnAction(e ->
		{
			needToUpdate.setVisible(true);

			((ModulesPane) modules).DeleteModule();
			((ModulesPane) modules).clearCommandPane();
		});
		DeleteCommands.setOnAction(e ->
		{
			needToUpdate.setVisible(true);

			for(int i = 0; i < ((ModulesPane)modules).getModules().size(); i++)
			{
				if(((ModulesPane) modules).getModules().get(i).isSelected())
				{
					for(int j = 0; j < ((ModulesPane)modules).getModules().get(i).getMyCommands().size(); j++)
					{
						if(((ModulesPane)modules).getModules().get(i).getMyCommands().get(j).isSelected())
						{
							((ModulesPane) modules).DeleteCommand(((ModulesPane)modules).getModules().get(i), ((ModulesPane)modules).getModules().get(i).getMyCommands().get(j));
						}
					}
				}
			}
		});
		Update.setOnAction(e ->
		{
			needToUpdate.setVisible(false);
			try {
				((ModulesPane) modules).saveDataToFile();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void setupButtons()
	{

		
		getChildren().add(NewModule);
		NewModule.setLayoutX(20);
		NewModule.setLayoutY(650);
		NewModule.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");
		
		NewModule.setOnMouseEntered(e ->
		{
			NewModule.setStyle("-fx-background-color: '#c8c8c8'; -fx-text-fill: '#242424'; -fx-font-size: 15; -fx-padding: 15;");
		});
		NewModule.setOnMouseExited(e ->
		{
			NewModule.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");
		});
		
		
		getChildren().add(NewCommand);
		NewCommand.setLayoutX(300);
		NewCommand.setLayoutY(40);
		NewCommand.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");

		NewCommand.setOnMouseEntered(e ->
		{
			NewCommand.setStyle("-fx-background-color: '#c8c8c8'; -fx-text-fill: '#242424'; -fx-font-size: 15; -fx-padding: 15;");
		});
		NewCommand.setOnMouseExited(e ->
		{
			NewCommand.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");
		});
		
		getChildren().add(DeleteModule);
		DeleteModule.setLayoutX(170);
		DeleteModule.setLayoutY(650);
		DeleteModule.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");

		DeleteModule.setOnMouseEntered(e ->
		{
			DeleteModule.setStyle("-fx-background-color: '#c8c8c8'; -fx-text-fill: '#242424'; -fx-font-size: 15; -fx-padding: 15;");
		});
		DeleteModule.setOnMouseExited(e ->
		{
			DeleteModule.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");
		});
		
		
		getChildren().add(DeleteCommands);
		DeleteCommands.setLayoutX(465);
		DeleteCommands.setLayoutY(40);
		DeleteCommands.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");

		DeleteCommands.setOnMouseEntered(e ->
		{
			DeleteCommands.setStyle("-fx-background-color: '#c8c8c8'; -fx-text-fill: '#242424'; -fx-font-size: 15; -fx-padding: 15;");
		});
		DeleteCommands.setOnMouseExited(e ->
		{
			DeleteCommands.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");
		});
		
		
		getChildren().add(Update);
		Update.setLayoutX(600);
		Update.setLayoutY(40);
		Update.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");
		
		Update.setOnMouseEntered(e ->
		{
			Update.setStyle("-fx-background-color: '#c8c8c8'; -fx-text-fill: '#242424'; -fx-font-size: 15; -fx-padding: 15;");
		});
		Update.setOnMouseExited(e ->
		{
			Update.setStyle("-fx-background-color: '#242424'; -fx-text-fill: '#c8c8c8'; -fx-font-size: 15; -fx-padding: 15;");
		});
		
		needToUpdate = new Circle(5);
		needToUpdate.setFill(Color.GREEN);
		needToUpdate.setLayoutX(685);
		needToUpdate.setLayoutY(48);
		getChildren().add(needToUpdate);
		needToUpdate.setVisible(false);

		
	
		
	}
	
	
	
}
