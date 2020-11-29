package pvz;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.*;

public class LawnController2 implements Initializable{
	@FXML
	private StackPane stackpane;
	@FXML
	private JFXButton menubutton;
	@FXML
	private ImageView mainmover;
	@FXML
	private ImageView sunicon;
	@FXML
	private ProgressBar timer;
	@FXML
	private Text suncounter;
	@FXML
	private Pane pane;
	@FXML
	
	double minXcord = 350;
	double minYcord = 73;
	double boxHeight = 495/5;
	double boxWidth = 740/9;
	
	@FXML
	private void checkdrag(MouseEvent event) {
		System.out.println(event.getScreenX());
	    System.out.println(event.getScreenY());
	    
	    
	    ImageView p1 = new ImageView("peashooter_idle.gif");

	    p1.setTranslateX(event.getSceneX()-700);
	    p1.setTranslateY(event.getSceneY()-300);
	    p1.setScaleX(0.2);
	    p1.setScaleY(0.2);
	    
	    p1.setVisible(true);
	    
	}
	int counter = 0;
	
	@FXML
	public void plantsunflower(MouseEvent event) {
//		ImageView p1 = new ImageView("sunflower.gif");
		long prevtime = System.currentTimeMillis();
		sunflower sunf = new sunflower(event.getSceneX(),event.getSceneY(),stackpane,suncounter);
//		System.out.println("ss");
	}
	@FXML
	public void plantwalnut(MouseEvent event) {
//		ImageView p1 = new ImageView("sunflower.gif");
		long prevtime = System.currentTimeMillis();
		walnut wal = new walnut(event.getSceneX(),event.getSceneY(),stackpane,suncounter,arrl);
//		System.out.println("ss");
	}
	@FXML
	public void plantcherrybomb(MouseEvent event) {
//		ImageView p1 = new ImageView("sunflower.gif");
		System.out.println("ssdd");
		long prevtime = System.currentTimeMillis();
		cherrybomb cb = new cherrybomb(event.getSceneX(),event.getSceneY(),stackpane,suncounter,arrl);
//		System.out.println("ss");
	}
	@FXML
	public void handle(MouseEvent event) {
		double pointerX = event.getScreenX();
		double pointerY = event.getScreenY();
		
		
		double finalCordX = 0;
		double finalCordY=0;
		
		if((pointerX>minXcord && pointerX<minXcord+508) && pointerY>minYcord && pointerY<minYcord + 742 )
		{	
			finalCordX = minXcord + Math.abs(pointerX/boxWidth)*boxWidth;
			finalCordY = minYcord + Math.abs(pointerY/boxHeight)*boxHeight;		
		}
		peashooter shooter = new peashooter(event.getSceneX(),event.getSceneY(),stackpane,arrl,suncounter);
				
	}
	@FXML
	private void translatemover() {
		System.out.println("first");
		Timeline fulltm = new Timeline();
		fulltm.setCycleCount(Timeline.INDEFINITE);
		
		Double ix = 6.0;
		cord_x = mainmover.getX(); 
		TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.002),mainmover);
		Double cord_y = mainmover.getY();
		KeyFrame mover = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				transitionp.setFromX(cord_x);
				transitionp.setToX(cord_x + ix);
				transitionp.play();
				cord_x += ix;

				if(cord_x == 1500)
					fulltm.stop();
				try {
				for(zombie jj : arrl) {
					if(mainmover.getBoundsInParent().intersects(jj.zm_image.getBoundsInParent())){
							stackpane.getChildren().remove(jj.zm_image);
							jj.zm_image.setVisible(false);
							arrl.remove(jj);
							System.out.println("ss");
//							fulltm.stop();
					}
					
				}}
				catch(Exception e) {
					
				}
				
			}
		});
		fulltm.getKeyFrames().add(mover);
		fulltm.play();

	}
	@FXML
	private ImageView mainmover2;
	@FXML
	private void translatemover2() {
		System.out.println("2nd");
		Timeline fulltm = new Timeline();
		fulltm.setCycleCount(Timeline.INDEFINITE);
		
		Double ix = 6.0;
		cord_x = mainmover2.getX(); 
		TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.002),mainmover2);
		Double cord_y = mainmover2.getY();
		KeyFrame mover2 = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				transitionp.setFromX(cord_x);
				transitionp.setToX(cord_x + ix);
				transitionp.play();
				cord_x += ix;

				if(cord_x == 1500)
					fulltm.stop();
				try {
				for(zombie jj : arrl) {
					if(mainmover2.getBoundsInParent().intersects(jj.zm_image.getBoundsInParent())){
							stackpane.getChildren().remove(jj.zm_image);
							jj.zm_image.setVisible(false);
							arrl.remove(jj);
							System.out.println("ss");
//							fulltm.stop();
					}
					
				}}
				catch(Exception e) {
					
				}
				
			}
		});
		fulltm.getKeyFrames().add(mover2);
		fulltm.play();

	}

	@FXML
	private ImageView mainmover3;
	@FXML
	private void translatemover3() {
		Timeline fulltm = new Timeline();
		fulltm.setCycleCount(Timeline.INDEFINITE);
		
		Double ix = 6.0;
		cord_x = mainmover3.getX(); 
		TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.002),mainmover3);
		Double cord_y = mainmover3.getY();
		KeyFrame mover3 = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				transitionp.setFromX(cord_x);
				transitionp.setToX(cord_x + ix);
				transitionp.play();
				cord_x += ix;

				if(cord_x == 1500)
					fulltm.stop();
				try {
				for(zombie jj : arrl) {
					if(mainmover3.getBoundsInParent().intersects(jj.zm_image.getBoundsInParent())){
							stackpane.getChildren().remove(jj.zm_image);
							jj.zm_image.setVisible(false);
							arrl.remove(jj);
//							System.out.println("ss");
//							fulltm.stop();
					}
					
				}}
				catch(Exception e) {
					
				}
				
			}
		});
		fulltm.getKeyFrames().add(mover3);
		fulltm.play();

	}
	@FXML
	private ImageView mainmover5;
	@FXML
	private void translatemover5() {
		Timeline fulltm = new Timeline();
		fulltm.setCycleCount(Timeline.INDEFINITE);
		
		Double ix = 6.0;
		cord_x = mainmover5.getX(); 
		TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.002),mainmover5);
		Double cord_y = mainmover5.getY();
		KeyFrame mover5 = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				transitionp.setFromX(cord_x);
				transitionp.setToX(cord_x + ix);
				transitionp.play();
				cord_x += ix;

				if(cord_x == 1500)
					fulltm.stop();
				try {
				for(zombie jj : arrl) {
					if(mainmover5.getBoundsInParent().intersects(jj.zm_image.getBoundsInParent())){
							stackpane.getChildren().remove(jj.zm_image);
							jj.zm_image.setVisible(false);
							arrl.remove(jj);
//							System.out.println("ss");
//							fulltm.stop();
					}
					
				}}
				catch(Exception e) {
					
				}
				
			}
		});
		fulltm.getKeyFrames().add(mover5);
		fulltm.play();

	}
	@FXML
	private ImageView mainmover4;
	@FXML
	private void translatemover4() {
		System.out.println("4th");
		Timeline fulltm = new Timeline();
		fulltm.setCycleCount(Timeline.INDEFINITE);
		
		Double ix = 6.0;
		cord_x = mainmover4.getX(); 
		TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.002),mainmover4);
		Double cord_y = mainmover4.getY();
		KeyFrame mover4 = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				transitionp.setFromX(cord_x);
				transitionp.setToX(cord_x + ix);
				transitionp.play();
				cord_x += ix;

				if(cord_x == 1500)
					fulltm.stop();
				try {
				for(zombie jj : arrl) {
					if(mainmover4.getBoundsInParent().intersects(jj.zm_image.getBoundsInParent())){
							stackpane.getChildren().remove(jj.zm_image);
							jj.zm_image.setVisible(false);
							arrl.remove(jj);
//							System.out.println("ss");
//							fulltm.stop();
					}
					
				}}
				catch(Exception e) {
					
				}
				
			}
		});
		fulltm.getKeyFrames().add(mover4);
		fulltm.play();

	}

	@FXML
	private AnchorPane anchorpane;
	
	@FXML
	public void showmenu(ActionEvent event) {
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
	private Double cord_x;
	@FXML
	private void collectsun() {
		sunicon.setOpacity(0);
//		suncounter.setText("100");
		stackpane.getChildren().remove(sunicon);
		suncounter.setText(Integer.toString(Integer.parseInt(suncounter.getText())+50));
	}
	private LinkedList<zombie> arrl = new LinkedList<zombie>();
	private ArrayList<zombie> arr = new ArrayList();
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		stackpane.setOpacity(1);
		
//		pane.setCenterShape(true);
		
		
//		TranslateTransition transition = new TranslateTransition(Duration.seconds(70),cone);
//		transition.setToX(-440);
////		transition.setByY(0);
//		transition.setAutoReverse(true);
//		transition.play();
		
		
		TranslateTransition transition2 = new TranslateTransition(Duration.seconds(10),sunicon);
//		transition2.setToX(-440);
		transition2.setByY(1500);
		transition2.setAutoReverse(true);
		transition2.play();
		Timeline timeline = new Timeline(
			        new KeyFrame(Duration.ZERO, new KeyValue(timer.progressProperty(), 0)),
			        new KeyFrame(Duration.minutes(1), e-> {
			        }, new KeyValue(timer.progressProperty(), 1))    
			    );
			    timeline.setCycleCount(Animation.INDEFINITE);
			    timeline.play();
		
		timer.setProgress(0.5);
		
		
		zombie[] arr = new zombie[100]; 
		Timeline plantzombietimeline = new Timeline();
		KeyFrame plzm = new KeyFrame(Duration.seconds(4), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				Random random = new Random();
				int op = random.nextInt(7);
				int locx = 800,locy = 0;
				switch(op) {
					case 0 : locy -= 210  ;
						break;
					case 1 : locy -= 110;
						break;
					case 2 : locy -= 30;
						break;
					case 3 : locy += 90;
						break;
					case 4 : locy += 190;
						break;
					default: 
						break;
				}
				int zop = random.nextInt(2);
				
				if(locy!=0) {
					zombie z = new zombie(locx,locy,stackpane,arrl,zop);
					
				}
			}
		});
		
		
		plantzombietimeline.setCycleCount(10);
		plantzombietimeline.getKeyFrames().add(plzm);
		plantzombietimeline.play();
		
		Timeline tl = new Timeline();
		tl.setCycleCount(Timeline.INDEFINITE);
		KeyFrame sunfall = new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				fallsun s = new fallsun(0,0,stackpane,suncounter);
			}});
		tl.getKeyFrames().add(sunfall);
		tl.play();
		
		
		Timeline lawnmm = new Timeline();
		lawnmm.setCycleCount(Timeline.INDEFINITE);
		KeyFrame lawnm = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				try {
					for(zombie jj : arrl) {
//						if(mainmover.getBoundsInLocal().intersects(jj.zm_image.getBoundsInParent())){
//							translatemover();
//						}
						if(mainmover2.getBoundsInLocal().intersects(jj.zm_image.getBoundsInParent())){
							translatemover2();
						}
						else if(mainmover3.getBoundsInLocal().intersects(jj.zm_image.getBoundsInParent())){
							translatemover3();
						}
						else if(mainmover4.getBoundsInLocal().intersects(jj.zm_image.getBoundsInParent())){
							translatemover4();
						}
						else if(mainmover5.getBoundsInLocal().intersects(jj.zm_image.getBoundsInParent())){
							translatemover5();
						}
						
					}}
					catch(Exception e) {
						
					}
			}});
		lawnmm.getKeyFrames().add(lawnm);
//		lawnmm.play();
		
		
		Timeline tl1 = new Timeline();
		tl1.setCycleCount(Timeline.INDEFINITE);
		KeyFrame win = new KeyFrame(Duration.seconds(13), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				if(arrl.size()==0) {
					System.out.println("winn");
					try {
 						Parent secondview;
 						secondview = (StackPane) FXMLLoader.load(getClass().getResource("Winningscreen.fxml"));
 						Scene newscene = new Scene(secondview,1400,600);
 						Stage curstage = (Stage) stackpane.getScene().getWindow();
 						curstage.setScene(newscene);
 						System.out.println("Loaded");
 						tl1.stop();
 					}
 					catch (Exception e){
 						System.out.println(e.getMessage());
 						System.out.println("not loaded");
 					}
				}
			}});
		tl1.getKeyFrames().add(win);
		tl1.play();
		
		
//		TranslateTransition transitionq = new TranslateTransition(Duration.seconds(0.0002),pea_image);
//		TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.002),mainmover);
//		transitionq.setToX(cord_x);
//		transitionq.setToY(cord_y);
//		transitionq.play();
		
		
	}
	
}
