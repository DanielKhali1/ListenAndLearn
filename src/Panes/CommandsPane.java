package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import Things.Module;
import javafx.scene.control.TextField;
public class CommandsPane extends Pane
{
	Pane scrollBoi = new Pane();
	Pane currentCommand = new Pane();
	TextField tfModuleName = new TextField();
	
	public CommandsPane()
	{
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
		
		scrollBoi.setLayoutX(25);
		scrollBoi.setLayoutY(40+70);
		scrollBoi.setPrefSize(350, 240);
		getChildren().add(scrollBoi);
		scrollBoi.setStyle("-fx-background-color: '#242424';");
		
		Text title2 = new Text("Current Command");
		title2.setLayoutX(125);
		title2.setLayoutY(350+50);
		getChildren().add(title2);
		title2.setFill(Color.WHITE);
		title2.setStyle("-fx-font-size: 20");
		
		currentCommand.setLayoutX(25);
		currentCommand.setLayoutY(360+50);
		currentCommand.setPrefSize(350, 150);

		getChildren().add(currentCommand);	
		currentCommand.setStyle("-fx-background-color: '#242424';");		
	}
	
	public void SelectedModule(Module mod)
	{
		tfModuleName.setText(mod.getMyButton().getText());
		
		tfModuleName.setOnKeyPressed( e->
		{
			mod.getMyButton().setText(tfModuleName.getText());
		});
		tfModuleName.setOnKeyReleased( e->
		{
			mod.getMyButton().setText(tfModuleName.getText());
		});
	}
	
	public void ClearPane()
	{
		tfModuleName.setText("");
	}

}