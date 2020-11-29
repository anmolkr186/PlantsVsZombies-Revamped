package pvz;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
class user{
	static String name;
	user(String n){
		name = n;
	}
}
public class newgamecontroller implements Initializable{
	@FXML
	private StackPane stackpane;
	@FXML
	private JFXButton enterbutton;
	@FXML
	private TextField gettext;
	@FXML
	private void handleenterbutton(ActionEvent event) {
		try {
			FadeTransition fade = new FadeTransition(Duration.seconds(1));
			fade.setNode(stackpane);
			fade.setFromValue(1);
			fade.setToValue(0);
			fade.setOnFinished((ActionEvent eventt) -> {
			Parent secondview;
			user.name = gettext.getText();
			try { 
				secondview = (StackPane) FXMLLoader.load(getClass().getResource("Lawn.fxml"));
				Scene newscene = new Scene(secondview,1400,600);
				Stage curstage = (Stage) stackpane.getScene().getWindow();
				curstage.setScene(newscene);
				System.out.println("Loaded");
			}
			catch(Exception e) {
				
			}
		});
		fade.play();
			
		}
		catch (Exception e){
			System.out.println("not loaded");
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
