package pvz;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
//static LoadScreenController myControllerHandle;


public class A extends Application {
	final static javafx.scene.image.Image zombie1 = new javafx.scene.image.Image(A.class.getResource("1.jpeg").toString());
	final static javafx.scene.image.Image zombie2 = new javafx.scene.image.Image(A.class.getResource("2.jpeg").toString());
	
	private Group zombie;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		final ImageView z1 = new ImageView(zombie1);
		final ImageView z2 = new ImageView(zombie2);
		zombie = new  Group(z1);
		zombie.setTranslateX(0);
		zombie.setTranslateY(0);
		Timeline t = new Timeline();
		t.setCycleCount(Timeline.INDEFINITE);
		t.getKeyFrames().add(new KeyFrame(
				Duration.millis(200),(ActionEvent event) -> {
			zombie.getChildren().setAll(z2);
		}));
		t.getKeyFrames().add(new KeyFrame(
				Duration.millis(400),(ActionEvent event) -> {
			zombie.getChildren().setAll(z1);
		})); 
		t.play();
		Parent root = FXMLLoader.load(getClass().getResource("LoadScreen.fxml"));
		
//		Media media = new Media("theme.mp3");  
//		MediaPlayer mediaPlayer = new MediaPlayer(media);  
//		mediaPlayer.setAutoPlay(true);  
		
		Scene scene = new Scene(root,1400,600);
		stage.setScene(scene);
//		stage.setScene(new Scene(zombie,600,400));
		stage.show();
		
	}

}