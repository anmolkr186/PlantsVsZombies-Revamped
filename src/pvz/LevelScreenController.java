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

public class LevelScreenController implements Initializable {
	@FXML
	private StackPane stackpane;
	@FXML
	private JFXButton backbutton;
	
	@FXML
	private void goback(ActionEvent event) {
		try {
			Parent secondview;
			secondview = (StackPane) FXMLLoader.load(getClass().getResource("LoadScreen.fxml"));
			Scene newscene = new Scene(secondview,1400,600);
			Stage curstage = (Stage) stackpane.getScene().getWindow();
			curstage.setScene(newscene);
			System.out.println("Loaded");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("not loaded");
		}
	}
	@FXML
	private JFXButton level1;
	@FXML
	private JFXButton level2;
	@FXML
	private JFXButton level3;
	@FXML
	private JFXButton level4;
	@FXML
	private JFXButton level5;
	
	@FXML
	private void golevel1(ActionEvent event) {
		try {
			Parent secondview;
			secondview = (StackPane) FXMLLoader.load(getClass().getResource("Lawn.fxml"));
			Scene newscene = new Scene(secondview,1400,600);
			Stage curstage = (Stage) stackpane.getScene().getWindow();
			curstage.setScene(newscene);
			System.out.println("Loaded");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("not loaded");
		}
	}
	@FXML
	private void golevel2(ActionEvent event) {
		try {
			Parent secondview;
			secondview = (StackPane) FXMLLoader.load(getClass().getResource("Lawn1.fxml"));
			Scene newscene = new Scene(secondview,1400,600);
			Stage curstage = (Stage) stackpane.getScene().getWindow();
			curstage.setScene(newscene);
			System.out.println("Loaded");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("not loaded");
		}
	}
	@FXML
	private void golevel3(ActionEvent event) {
		try {
			Parent secondview;
			secondview = (StackPane) FXMLLoader.load(getClass().getResource("Lawn2.fxml"));
			Scene newscene = new Scene(secondview,1400,600);
			Stage curstage = (Stage) stackpane.getScene().getWindow();
			curstage.setScene(newscene);
			System.out.println("Loaded");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("not loaded");
		}
	}
	@FXML
	private void golevel4(ActionEvent event) {
		try {
			Parent secondview;
			secondview = (StackPane) FXMLLoader.load(getClass().getResource("Lawn3.fxml"));
			Scene newscene = new Scene(secondview,1400,600);
			Stage curstage = (Stage) stackpane.getScene().getWindow();
			curstage.setScene(newscene);
			System.out.println("Loaded");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("not loaded");
		}
	}
	@FXML
	private void golevel5(ActionEvent event) {
		try {
			Parent secondview;
			secondview = (StackPane) FXMLLoader.load(getClass().getResource("Lawn4.fxml"));
			Scene newscene = new Scene(secondview,1400,600);
			Stage curstage = (Stage) stackpane.getScene().getWindow();
			curstage.setScene(newscene);
			System.out.println("Loaded");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("not loaded");
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
