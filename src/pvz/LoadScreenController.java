package pvz;
import java.io.IOException;
//import javafx.;.Button;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.sun.media.jfxmedia.AudioClip;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.*;
import javafx.scene.Group;  
import java.io.File;
//import javafx.scene.media.AudioClip;


public class LoadScreenController implements Initializable{

	@FXML
	private JFXButton LoadScreenStartButton;
	@FXML
	private StackPane stackpane;
	@FXML
	private Button next;
	@FXML
	private JFXButton chooselevelbutton;
	@FXML
	private void handlestartgameclick(ActionEvent event) {
		makeFadeOut();
	}
	@FXML
	private JFXButton ingamemenu;
	@FXML
	private JFXButton exitbutton;
	@FXML
	private void exitgame() {
		System.exit(0);
	}
	
	
	@FXML
	private void handlechooselevel(ActionEvent event) {
		try {
			Parent secondview;
			secondview = (StackPane) FXMLLoader.load(getClass().getResource("LevelScreen.fxml"));
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
	private void ingamenuclick(ActionEvent event) {
		try {
			Parent secondview;
			secondview = (StackPane) FXMLLoader.load(getClass().getResource("Ingamemenu.fxml"));
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
	
	private void makeFadeOut() {
		FadeTransition fade = new FadeTransition(Duration.seconds(1));
		fade.setNode(stackpane);
		fade.setFromValue(1);
		fade.setToValue(0);
		fade.setOnFinished((ActionEvent event) -> {
			loadnextscene();
		});
		fade.play();
		
	}
	private void loadnextscene(){
		try {
			Parent secondview;
	        secondview = (StackPane) FXMLLoader.load(getClass().getResource("newgame.fxml"));
			Scene newscene = new Scene(secondview,1400,600);
			Stage curstage = (Stage) stackpane.getScene().getWindow();
			curstage.setScene(newscene);
			System.out.println("Loaded");
		}
		catch (Exception e){
			System.out.println("not loaded");
		}
		
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
      
        
	}
	
}
