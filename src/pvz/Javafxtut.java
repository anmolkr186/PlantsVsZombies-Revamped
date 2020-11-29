package pvz;
import javafx.*;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.application.*;

// package includes Pane class and its subclasses

import javafx.scene.layout.*;

//package includes Label, Button classes

import javafx.scene.control.*;

//package includes ActionEvent, EventHandler classes

import javafx.event.*;

import javafx.util.Duration;

import javafx.animation.Animation;

import javafx.animation.KeyFrame;

import javafx.animation.Timeline;

import java.util.Date;
public class Javafxtut extends Application {


	@Override
	public void start(Stage primaryStage) {
		    Button btn = new Button("Genuine Coder");
		    Group group = new Group(btn);
		    Scene scene = new Scene(group, 600, 600);
		 
		    //Duration = 2.5 seconds
		    Duration duration = Duration.millis(2500);
		    //Create new scale transition
		    ScaleTransition scaleTransition = new ScaleTransition(duration, btn);
		    //Set how much X should enlarge
		    scaleTransition.setByX(1.5);
		    //Set how much Y should
		    scaleTransition.setByY(1.5);
		    scaleTransition.play();
		 
		    primaryStage.setScene(scene);
		    primaryStage.show();
		  }
		//		PaneOrganizer organizer = new PaneOrganizer();
//		Scene scene = new Scene(organizer.getRoot(), 200, 200);
//		stage.setScene(scene);
//		stage.setTitle("Clock");
//		stage.show();
//		}

	public static void main(String[] args) {
		Javafxtut.launch(args);
	}
}
	