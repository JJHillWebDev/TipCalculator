import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
	This is a JavaFX application that calculates a 20% tip for the 
	number amount entered by the user.

    @author Jeremy Hill
    @version 1.8.0_271
 */
public class TipCalculator extends Application
{
	/**
	* The main method calls the Application class launch
	* @param args the command line arguments
	*/
	public static void main(String[] args) 
	{
		launch(args);
	}

	/**
	* The start method takes a Stage object as an argument.
	* It also calls the Stage object's show() method after 
	* the user eneters dollor amount and clicks the "Calculte
	* Tip" button. It will display the amount for a 20% tip.
	* @param stage Stage object to display scene
	*/
	@Override
	public void start(Stage stage) 
	{
		//create labels, textfields and a button for the user to ineract with
		Label label1 = new Label("Restaurant Charge:");
		//holds user input
		TextField text = new TextField();		
		//create calculate tip button
		Button calcButton = new Button("Calculate Tip");
		Label label2 = new Label("Amount to Tip: ");
		//will hold the calculated tip
		Label label3 = new Label();				
		//create a VBox with 10 px spacing with labels, textfields and button
		VBox vbox = new VBox(10, label1, text, calcButton, label2, label3);
		//center align objects in the VBox
		vbox.setAlignment(Pos.CENTER);
		//adds 10px of padding to the VBox
		vbox.setPadding(new Insets(10));

		//When clicked a 20% tip will be calulated using the number
		//amount entered by the user and is displayed in the VBox.
		calcButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//turn the user's entered amount a makes it a double
				double tip = Double.parseDouble(text.getText());
				//add a 20% tip the the user's entered amount
				double amount = tip * 0.2;
				//create and set a string with the calulated tip that
				//is formatted to look like a dollar amount to label3
				label3.setText("$" + String.format("%.2f", amount));
			}
		});
	  	//create the scene
		Scene scene = new Scene(vbox);
		//set the scene
		stage.setScene(scene);
		//display the scene
		stage.show();
	}
}