package pvz;

import java.util.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import pvz.PaneOrganizer.TimeHandler;

public class PaneOrganizer{	
		private VBox _root;
		private Label _label;
	
		public PaneOrganizer(){
	
		_root = new VBox();
		_label = new Label();
		_root.getChildren().add(_label);
		this.setupTimeline();
	
		}
	
		public VBox getRoot() {
	
		return _root;
		}
	
		public void setupTimeline(){
		KeyFrame kf = new KeyFrame(Duration.seconds(1),
		new TimeHandler());
		Timeline timeline = new Timeline(kf);
	
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	
		}
	
		public class TimeHandler
	
		implements EventHandler<ActionEvent>{
	
		public void handle(ActionEvent event){
	
		Date now = new Date();
		_label.setText(now.toString());
		
		}
	}
}
