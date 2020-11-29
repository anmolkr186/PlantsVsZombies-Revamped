package pvz;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ingamemenucontroller implements Initializable{
	@FXML
	private JFXButton backtogame;
	@FXML
	private StackPane menustackpane;
	@FXML
	private JFXButton quitbutton;
	@FXML
	private void handlequitgame(ActionEvent event) {
		System.exit(0);
	}
	@FXML
	private void handlebacktogame(ActionEvent event) {
		try {
			Parent secondview;
			secondview = (StackPane) FXMLLoader.load(getClass().getResource("LoadScreen.fxml"));
			Scene newscene = new Scene(secondview,1400,600);
			Stage curstage = (Stage) menustackpane.getScene().getWindow();
			curstage.setScene(newscene);
			System.out.println("Loaded");
		}
		catch (Exception e){
			System.out.println("not loaded");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
