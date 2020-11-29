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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Winningscreencontroller  implements Initializable{
	@FXML
	private StackPane stackpane;
	@FXML
	private JFXButton mainmenubutton;
	@FXML
	private void gotomainmenu(ActionEvent event) {
		System.out.println("abcd");
		try {
				Parent secondview;
				secondview = (StackPane) FXMLLoader.load(getClass().getResource("Levelscreen.fxml"));
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
		// TODO Auto-generated method stub
		
	}
}
