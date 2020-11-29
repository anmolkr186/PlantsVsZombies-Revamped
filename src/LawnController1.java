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

abstract class plant
{
	private boolean activeStatus;
	private int health;
	private final int maxhealth;
	private ImageView deathAnimation;
	private ImageView animation;

	public void setAnimation(ImageView i)
	{
		this.animation = i;
	}

	plant()
	{
		this.activeStatus = false;
		this.health = 0;
		this.maxhealth = 100;
	}
	
}

class sunflower
{
    public double cord_x;
    public double cord_y;
    ImageView sunflower_image;
    static long prevtime;
    sunflower(double x,double y,StackPane stackpane, Text suncounter)
    {	
    	int sunc = Integer.parseInt(suncounter.getText());
        
    	
    	long currenttime = System.currentTimeMillis();

    	if(currenttime-prevtime>5000 && sunc>=50) {
    	prevtime = currenttime;
    	suncounter.setText(Integer.toString(Integer.parseInt(suncounter.getText())-50));
        
        this.cord_x = x;
        this.cord_y = y;
        sunflower_image = new ImageView(new Image ("sunflower.gif"));
        sunflower_image.setScaleX(0.4); //change if big/small size
        sunflower_image.setScaleY(0.4);
        TranslateTransition tranisitionp = new TranslateTransition(Duration.seconds(0.001),sunflower_image);
        tranisitionp.setToX(cord_x-700);
        tranisitionp.setToY(cord_y-350+20);
        tranisitionp.play();
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        
        KeyFrame producesun = new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent arg0) {		
				sun s = new sun(cord_x,cord_y,stackpane,suncounter);
			}});
        
        timeline.getKeyFrames().add(producesun);
        timeline.play();
        
        stackpane.getChildren().add(sunflower_image);
        
    	}
    }

}
class sun{
    public double cord_x;
    public double cord_y;
    ImageView sun_img;
    sun(double x,double y,StackPane stackpane, Text suncounter){
    	this.cord_x = x;
		this.cord_y = y;
		sun_img = new ImageView(new Image(getClass().getResourceAsStream("Sun.png")));
		sun_img.setScaleX(0.5);
	    sun_img.setScaleY(0.5);
	    TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.001),sun_img);

	    transitionp.setToX(cord_x-700+10);
	    transitionp.setToY(cord_y-350+30);
	    transitionp.play();
	    
	    stackpane.getChildren().add(sun_img);
	    sun_img.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            suncounter.setText(Integer.toString(Integer.parseInt(suncounter.getText())+50));
            stackpane.getChildren().remove(sun_img);
            sun_img.setVisible(false);
            event.consume();
        });
    }
}

class fallsun{
    public double cord_x;
    public double cord_y;
    ImageView sun_img;
    fallsun(double x,double y,StackPane stackpane, Text suncounter){
    	this.cord_x = x;
		this.cord_y = y;
		sun_img = new ImageView(new Image(getClass().getResourceAsStream("Sun.png")));
		sun_img.setScaleX(0.5);
	    sun_img.setScaleY(0.5);
	    TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.01),sun_img);

	    transitionp.setToX(500);
	    transitionp.setToY(-1000);
	    transitionp.play();
	    
	    TranslateTransition transitionq = new TranslateTransition(Duration.seconds(1),sun_img);
	    transitionp.setFromX(sun_img.getX());
	    transitionp.setFromY(sun_img.getY());
	    Random random = new Random();
	    int dx = random.nextInt(2);
	    if(dx==0)
	    	dx=200;
	    else
	    	dx = -200;
	    int dy = random.nextInt(2);
	    if(dy==0)
	    	dy=200;
	    else
	    	dy = -200;
	    
//	    transitionp.setToX(x-200);
//	    transitionp.setToY(y-2000);
//	    transitionp.play();
	    transitionq.setToX(x+dx);
	    transitionq.setToY(y+dy);
	    transitionq.play();
	    stackpane.getChildren().add(sun_img);
	    sun_img.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            suncounter.setText(Integer.toString(Integer.parseInt(suncounter.getText())+50));
            stackpane.getChildren().remove(sun_img);
            sun_img.setVisible(false);
            event.consume();
        });
    }
}

class zombie
{
	public boolean activeStatus;
	public double cord_x;
	public double cord_y;
	public int health;
	public final int maxhealth;
	public ImageView zm_image;
	Double ix = -1.0;
	zombie(double x,double y,StackPane pane,LinkedList<zombie> arrl, int zop)
	{
		this.activeStatus = false;
		this.health = 100;
		this.maxhealth = 100;
		if(zop==0) {
			zm_image = new ImageView(new Image(getClass().getResourceAsStream("Conehead_Zombie.gif")));
			health = 200;
		}
		else if(zop==1) {
			zm_image = new ImageView(new Image(getClass().getResourceAsStream("bucket_head_zombie.gif")));
			health = 300;
			zm_image.setScaleX(2);
			zm_image.setScaleY(2);
		}
		else {
			zm_image = new ImageView(new Image(getClass().getResourceAsStream("normal_zombie.gif")));
			zm_image.setScaleX(0.45);
			zm_image.setScaleY(0.45);
		}
		zm_image.setX(x); 
		zm_image.setY(y);
		pane.getChildren().add(zm_image);
		zm_image.setX(x);
		zm_image.setX(y);
		cord_x = x;
		cord_y = y;
		ix = -1.0;
		Timeline fulltm = new Timeline();
		fulltm.setCycleCount(Timeline.INDEFINITE);

		TranslateTransition transitionq = new TranslateTransition(Duration.millis(0.1),zm_image);
		TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.1),zm_image);
		transitionq.setFromX(1800);
		transitionq.setFromY(1800);
		transitionq.setToX(cord_x);
		transitionq.setToY(cord_y);
		transitionq.play();
		
		KeyFrame walkzombie = new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				transitionp.setFromX(cord_x);
				transitionp.setToX(cord_x + ix);
				transitionp.play();
				cord_x += ix;
				if(cord_x<=-350) {
 					System.out.println("Win");
 					try {
 						Parent secondview;
 						secondview = (StackPane) FXMLLoader.load(getClass().getResource("Losingscreen.fxml"));
 						Scene newscene = new Scene(secondview,1400,600);
 						Stage curstage = (Stage) pane.getScene().getWindow();
 						curstage.setScene(newscene);
 						System.out.println("Loaded");
 						fulltm.stop();
 					}
 					catch (Exception e){
 						System.out.println(e.getMessage());
 						System.out.println("not loaded");
 						fulltm.stop();
 					}
				}
			}
		});
		fulltm.getKeyFrames().add(walkzombie);
		fulltm.play();
		arrl.add(this);
	}

}


class lawnmower
{
	private boolean activeStatus;
	private int speed;
	
	lawnmower()
	{
		this.activeStatus = false;
		this.speed = 0;
	}
	
}
class walnut{
	public double cord_x;
	public double cord_y;
	public ImageView walnut_image;
	public GridPane gpane;
	static long prevtime;
	private int health;
	walnut(double x, double y,StackPane stackpane, Text suncounter, LinkedList<zombie> arrl){
		health = 100;
		long currenttime = System.currentTimeMillis();
		int sunc = Integer.parseInt(suncounter.getText());
        
    	if(currenttime-prevtime>10000 && sunc>=50) {
    		suncounter.setText(Integer.toString(Integer.parseInt(suncounter.getText())-50));
            
    		prevtime = currenttime;
    		this.cord_x = x;
    		this.cord_y = y;
    		walnut_image = new ImageView(new Image(getClass().getResourceAsStream("walnut.gif")));
    		walnut_image.setScaleX(1);
    	    walnut_image.setScaleY(1);
    	    TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.01),walnut_image);

    	    transitionp.setToX(cord_x-700+10);
    	    transitionp.setToY(cord_y-350+30);
    	    transitionp.play();
    	    stackpane.getChildren().add(walnut_image);
    	    
    	    
    	    Timeline fulltm = new Timeline(); 
    	    KeyFrame stopwalnut = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {		
    			public void handle(ActionEvent arg0) {
    				try {
    				for(zombie jj : arrl) {
    					if(walnut_image.getBoundsInParent().intersects(jj.zm_image.getBoundsInParent())){
    						health-=10.0;
    						jj.ix = 0.0;
    						if(health<=0) {
    							stackpane.getChildren().remove(walnut_image);
    							fulltm.stop();
    							jj.ix=-1.0;
    						}
//    						stackpane.getChildren().remove(pea_image);
    						
    					}	
    				}}
    				catch(Exception e) {
    					
    				}
    				
    			}
    		});
    	    fulltm.setCycleCount(Timeline.INDEFINITE);
    		fulltm.getKeyFrames().add(stopwalnut);
    		fulltm.play();
    	    
    	}
	}
}

class cherrybomb{
	public double cord_x;
	public double cord_y;
	public ImageView cb_image;
	public GridPane gpane;
	static long prevtime;
	private int health;
	cherrybomb(double x, double y,StackPane stackpane, Text suncounter, LinkedList<zombie> arrl){
		health = 100;
		long currenttime = System.currentTimeMillis();
		int sunc = Integer.parseInt(suncounter.getText());
        
    	if(currenttime-prevtime>20000 && sunc>=150) {
    		suncounter.setText(Integer.toString(Integer.parseInt(suncounter.getText())-150));
            
    		prevtime = currenttime;
    		this.cord_x = x;
    		this.cord_y = y;
    		cb_image = new ImageView(new Image(getClass().getResourceAsStream("cherry_bomb.gif")));
    		cb_image.setScaleX(1);
    	    cb_image.setScaleY(1);
    	    TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.01),cb_image);

    	    transitionp.setToX(cord_x-700+10);
    	    transitionp.setToY(cord_y-350+30);
    	    transitionp.play();
    	    stackpane.getChildren().add(cb_image);
    	    
    	    
    	    Timeline fulltm = new Timeline(); 
    	    KeyFrame stopwalnut = new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {		
    			public void handle(ActionEvent arg0) {
    				try {
    				for(zombie jj : arrl) {
    					if(cb_image.getBoundsInParent().intersects(jj.zm_image.getBoundsInParent())){
    						stackpane.getChildren().remove(jj.zm_image);
							jj.zm_image.setVisible(false);
							arrl.remove(jj);
    					}	
    				}
    				stackpane.getChildren().remove(cb_image);
    	    	    
    				}
    				catch(Exception e) {
    					
    				}
    				
    			}
    		});
    	    fulltm.setCycleCount(1);
    		fulltm.getKeyFrames().add(stopwalnut);
    		fulltm.play();
    		
    	}
	}
}

class peashooter
{
	public double cord_x;
	public double cord_y;
	public ImageView peashooter_image;
	public GridPane gpane;
	static long prevtime;
    private int health;
	peashooter(double x, double y,StackPane stackpane, LinkedList<zombie> arrl, Text suncounter)
	{	
		health = 100;
		int sunc = Integer.parseInt(suncounter.getText());
        
    	
		long currenttime = System.currentTimeMillis();
    	if(currenttime-prevtime>5000 && sunc>=100) {
    		prevtime = currenttime;
    		suncounter.setText(Integer.toString(Integer.parseInt(suncounter.getText())-100));

		this.cord_x = x;
		this.cord_y = y;
		peashooter_image = new ImageView(new Image("peashooter_idle.gif"));
		peashooter_image.setScaleX(0.15);
	    peashooter_image.setScaleY(0.15);
	    TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.01),peashooter_image);

	    transitionp.setToX(cord_x-700+10);
	    transitionp.setToY(cord_y-350+30);
	    transitionp.play(); 
	    
	    stackpane.getChildren().add(peashooter_image);
//		AudioClip shootSound = new AudioClip("pea_shoot.ogg");

	    Timeline shootertm = new Timeline();
	    KeyFrame shootpea = new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent arg0) {				
				pea ppp = new pea(cord_x-700+30,cord_y-350+13,stackpane,arrl);
//				shootSound.play();
			}});
//		shootSound.stop();
		shootertm.getKeyFrames().add(shootpea);
		shootertm.setCycleCount(Timeline.INDEFINITE);
		shootertm.play();
		
		Timeline checkplant = new Timeline();
	    KeyFrame cpl = new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent arg0) {				
				try {
					for(zombie jj : arrl) {
						if(peashooter_image.getBoundsInParent().intersects(jj.zm_image.getBoundsInParent())){
							health-=55;
							if(health<=0) {
								stackpane.getChildren().remove(peashooter_image);
								peashooter_image.setVisible(false);
//								arrl.remove(jj);
							}
//							stackpane.getChildren().remove(pea_image);
//							fulltm.stop();
						}	
					}
				}
				catch(Exception e) {
					
				}
			}});
//		shootSound.stop();
		checkplant.getKeyFrames().add(cpl);
		checkplant.setCycleCount(Timeline.INDEFINITE);
		checkplant.play();
		
    	}
	}	
}

class pea{
	
	public double cord_x;
	public double cord_y;
	public ImageView pea_image;	
	
	pea(double x, double y, StackPane stackpane, LinkedList<zombie> arrl){
		pea_image = new ImageView("Pea.jpeg");
		this.cord_x = x;
		this.cord_y = y;
		double ix = 0.5;


		Timeline fulltm = new Timeline();
		fulltm.setCycleCount(Timeline.INDEFINITE);
		
		TranslateTransition transitionq = new TranslateTransition(Duration.seconds(0.0002),pea_image);
		TranslateTransition transitionp = new TranslateTransition(Duration.seconds(0.002),pea_image);
		transitionq.setToX(cord_x);
		transitionq.setToY(cord_y);
		transitionq.play();
		KeyFrame shootpea = new KeyFrame(Duration.seconds(0.001), new EventHandler<ActionEvent>() {		
			public void handle(ActionEvent arg0) {
				transitionp.setFromX(cord_x);
				transitionp.setToX(cord_x + ix);
				transitionp.play();
				cord_x += ix;
//				System.out.println("s");
				

				
				if(cord_x == 3000)
					fulltm.stop();
				try {
				for(zombie jj : arrl) {
					if(pea_image.getBoundsInParent().intersects(jj.zm_image.getBoundsInParent())){
						
						
						
						jj.health-=33;
						if(jj.health<=0) {
							stackpane.getChildren().remove(jj.zm_image);
							jj.zm_image.setVisible(false);
							arrl.remove(jj);
						}
						stackpane.getChildren().remove(pea_image);
						fulltm.stop();
					}	
				}}
				catch(Exception e) {
					
				}
				
			}
		});
		fulltm.getKeyFrames().add(shootpea);
		fulltm.play();
		stackpane.getChildren().add(pea_image);

	}
}

public class LawnController implements Initializable{
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
				int zop = random.nextInt(3);
				
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
