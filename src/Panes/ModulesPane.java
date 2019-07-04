package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

import Things.Module;

public class ModulesPane extends Pane
{
	VBox scrollBoi = new VBox();
	ScrollPane scrollpane;

	LinkedList<Module> modules = new LinkedList<Module>();
	
	Pane commands = new CommandsPane();

	
	public ModulesPane(ScrollPane scroll)
	{
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
		for(int i = 0; i < modules.size(); i++)
		{
			if(tempName.equals(modules.get(i).getMyButton().getText()))
			{
				count++;
				tempName = " New Module " + count;
			}
		}
		
		Module tempMod = new Module(tempName);
		tempMod.getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; -fx-padding: 30;"); 
		
		tempMod.getMyButton().setPrefSize(300, 100);
		modules.add(tempMod);

		tempMod.getMyButton().setOnAction( e->{
			
			tempMod.setSelected(!tempMod.isSelected());
			
				if(tempMod.isSelected())
				{
					((CommandsPane) commands).SelectedModule(tempMod);
					
					tempMod.getMyButton().setStyle("-fx-background-color: 'white'; -fx-text-fill: '#363636'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; -fx-padding: 30;");
					for(int i = 0; i < modules.size(); i++)
					{
						if(modules.get(i).equals(tempMod))
							continue;
						else
						{
							modules.get(i).setSelected(false);
							modules.get(i).getMyButton().setStyle("-fx-background-color: '#363636'; -fx-text-fill: 'white'; -fx-border-width: 2; -fx-font-size: 19.5; -fx-border-color: black; -fx-padding: 30;"); 
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
		for(int i = 0; i < modules.size(); i++)
		{
			if(modules.get(i).isSelected())
			{
				scrollBoi.getChildren().remove(modules.get(i).getMyButton());
				modules.remove(i);
				
			}
		}
	}
	
	public void clearCommandPane()
	{
		((CommandsPane) commands).ClearPane();
	}
	
	
	
}

