package com.jeuv1;

import java.awt.Graphics;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import application.Chrono;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import socket.Serveur;

public class Program extends Application{
private double widthwindow=1500;
private double heightwindow=900;
private Pane container=new Pane();
private Pane container1=new Pane();
public Line line=new Line(0,100,widthwindow,100);
public Line line1=new Line(0,500,widthwindow,500);
public Line line2=new Line(0,750,widthwindow,750);
public FXMLDocumentController fx;
public FXMLDocumentController fx1;

//Line line3=new Line(0,900,widthwindow,900);
Zone zone1=new Zone(0,0, line.getEndX()+10, line.getEndY());
//Zone zone1=new Zone(0,0, 500, 500);
Zone zone2=new Zone(line1.getStartX(),line1.getStartY() ,line2.getEndX(), line2.getEndY());
//Zone zone3=new Zone(0, 0, line.getEndX(), line.getEndY());
private Player player=new Player(zone2);
private Tank tank=new Tank(zone2);
private List<Monstre> monstres=new ArrayList<Monstre>();
private List<Balle> balles=new ArrayList<Balle>();
private List<Balle> balles1=new ArrayList<Balle>();
//private List<Balle> balles1=new ArrayList<Balle>();
Arme arme=new Arme(player);
private Heart heart=new Heart(1310,-70);
private Heart heart1=new Heart(1270,-70);
private Heart heart2=new Heart(1230,-70);
private List<Heart> hearts=new ArrayList<Heart>();
public level2 l2=new level2();
Arme arme1=new Arme(200,-70);
int s=0,a=50;
Label label = new Label("Score : "+s); 
Label labelarm = new Label("Arme : "+a); 
Label lablevel = new Label("Level 1 "); 
Image image;
Image image1;
Image image2;
Image image3;
Image image4;
int d=0;
private double timer=3000;
Label ltim= new Label("Timer : " + timer);



//int nmb_heart=3;
//private Heart heart1=new Heart(1.1,1.1);
//initialize socket and input stream 


AnimationTimer animation=new AnimationTimer() {
	
	@Override
	public void handle(long now) {

	
	
		refreshContent();
	
	
	
		
	}
};
//event handel
EventHandler<KeyEvent> event =new EventHandler<KeyEvent>() {

	@Override
	public void handle(KeyEvent event) {
		
		
		if(event.getCode()==KeyCode.X) {
			arme.rotateLeft();
			
		}
if(event.getCode()==KeyCode.W) {
	arme.rotateRight();
			
		}
if(event.getCode()==KeyCode.SPACE) {
	if(a>0) {
		Balle balle=new Balle(arme);
		container.getChildren().add(balle.getCorps());
		balles.add(balle);
		 a--;
		
	}labelarm.setText("Arme : "+a);

}
if(event.getCode()==KeyCode.UP) {
	arme.rotateRight();
	arme.getCorps().setTranslateY(arme.getCorps().getTranslateY()-5);
	arme.attachToPlayer(player);
}

if(event.getCode()==KeyCode.DOWN) {
	arme.rotateLeft();
	arme.getCorps().setTranslateY(arme.getCorps().getTranslateY()+5);
	arme.attachToPlayer(player);
}
if(event.getCode()==KeyCode.LEFT) {
	player.getCorps().setTranslateX(player.getCorps().getTranslateX()-5);
	arme.attachToPlayer(player);
	
}
if(event.getCode()==KeyCode.RIGHT) {
	player.getCorps().setTranslateX(player.getCorps().getTranslateX()+5);
	arme.attachToPlayer(player);

}
		
	
}
	
};
/*private void showTimeLeftScoreAndLifes(Graphics g) 
{
//clock = chrono du temps restant
  // what does the clock say
  int timeLeft = Clock.getTimeLeft();
  
  // if less than 6 seconds left
  // flicker time with red and black
  if(timeLeft < 6) {
	if((timeLeft % 2) == 0)
	  g.setColor(0xff0000);
	else
	  g.setColor(0x000000);

      // draw the time left string
      g.drawString("Time Left: " + timeLeft + " seconds", 0, 0, 0);
  }

//lifes = nb de vies restantes au joueur
  g.setColor(0xabc00e);
  g.drawString("Lifes : "+lifes, canvas_width/2, 0, 0);

//affichage du score en haut à droite
  g.setColor(0x000000);
  g.drawString(score, canvas_width*4/5, 0, 0);

  // reset the color
  g.setColor(0x000000);

}*/

private void refreshContent() {
	
	if(timer<=1500 && d>=1) {
		//System.out.println("chui la");
		   container.setBackground(new Background(l2.getMyBI()));
			lablevel.setText("Level 2");
			//container.getChildren().add(tank.getCorps());
	}


    	  	timer --;
    	   	ltim.setText("Timer : " + timer);
    	   	//ltim.setMaxSize(1950, -70);
    		if(timer<=1000 ) ltim.setTextFill(Color.RED);
    	   	if(timer<=0 ) {
				
				 Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Game Over! Votre score est :"+s);
					animation.stop();
					alert.show();
				
				}

	for(Balle balle:balles) {
		for(Monstre monster:monstres) {
			
			if(balle.touch(monster)) {
				//monster.setImage();
				//container.getChildren().add( monster.getCorps());
				container.getChildren().removeAll(balle.getCorps(),monster.getCorps());
				balle.setAlive(false);
				monster.setAlive(false);
				s=s+10;
				label.setText("Score : "+s);
				label.setMaxSize(1000, -70);
			//	label.setFont(Font.font("Cambria", 32));
				
			}
		}
	}
	monstres.removeIf(GraphicObject::isDead);
	balles.removeIf(GraphicObject::isDead);

	for(Balle balle1:balles1) {
			if(balle1.touch(player)) {
			if(d<=3) {
			
				container.getChildren().removeAll(balle1.getCorps());
		
				balle1.setAlive(false);
				player.setAlive(false);
				
					hearts.get(d).setImage();
					container.getChildren().add( hearts.get(d).getCorps());
					
					
					
					System.out.println("numb:heart"+d);
				
					d++;		System.out.println("d="+d);}
			if(d>=3 ) {
				System.out.println("dfonc="+d);
				 Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Game Over! Votre score est :"+s);
					animation.stop();
					alert.show();
				
				}
				}
			
				
			//	player.setAlive(false);
			
	}
	//monstres.removeIf(GraphicObject::isDead);
	balles1.removeIf(GraphicObject::isDead);
	for(Balle balle:balles) {
		balle.update();
	}
	for(Balle balle1:balles1) {
		balle1.update();
	}
	if(Math.random()<0.003) {
		
		Cloud c=new Cloud(zone1);
		container.getChildren().add(c.getCorps());
		}
	if(Math.random()<0.004) {
		Monstre m=new Monstre(zone1);
	container.getChildren().add(m.getCorps());
	monstres.add(m);

	}
	
	if(Math.random()<0.02) {
	for(Monstre monster:monstres) {
		Balle balle1=new Balle(monster);
		container.getChildren().add(balle1.getCorps());
		balles1.add(balle1);}
		
	}
  
	
	//container.getChildren().add(balle1.getCorps());
	//balles1.add(balle1);
	}
	


	public static void main(String[] args) {
	//	Program server = new Program(5000); 
		Application.launch(args);
	
		
	
	}
	

	private void createContentl1() {


//label.setFont();
hearts.add(heart);
hearts.add(heart1);
hearts.add(heart2);
		//container.getChildren().addAll(mv);
//alert = new Alert(AlertType.INFORMATION);
 Level l=new Level();
 ltim.setFont(new Font("Arial", 24));
 label.setFont(new Font("Arial", 24));
 labelarm.setFont(new Font("Arial", 24));
 lablevel.setFont(new Font("Arial", 24));
		   container.setBackground(new Background(l.getMyBI()));
     	//container.getChildren().add(backgGroup);
		container.getChildren().add(line);
		//container.getChildren().add(line1);
	//	container.getChildren().add(line2);
		
		//container.getChildren().add(line3);...........................................................................................................................................
		container.getChildren().add(player.getCorps());
		container.getChildren().add(arme.getCorps());
		container.getChildren().add(arme1.getCorps());
		container.getChildren().add(heart.getCorps());
		container.getChildren().add(heart1.getCorps());
		container.getChildren().add(heart2.getCorps());
		GridPane gridpane = new GridPane();
	    gridpane.setPadding(new Insets(5));
	    gridpane.setHgap(10);
	    gridpane.setVgap(10);
	    GridPane.setHalignment(labelarm, HPos.CENTER);
	    gridpane.add(labelarm, 25, 4); 
	    gridpane.add(label, 0, 4);
	    gridpane.add(lablevel, 45, 4);
	    gridpane.add(ltim, 70, 4);
		container.getChildren().add(gridpane);
		//container.getChildren().add(label);
		//container.getChildren().add(chrono.getDureeTxt());
		//container.getChildren().add(t);
		//container.getChildren().add(heart1.getCorps());
		//container.getChildren().add(arme.getSortie());
	
		
		
		}
	@Override
	public void start(Stage windows) throws Exception {
		 
		String family = "Helvetica";
		double size = 50;

	
		windows.setWidth(widthwindow);
		windows.setHeight(heightwindow);
		windows.setTitle("je de guerre");
		createContentl1();
		Scene scene=new Scene(container);
		windows.setScene(scene);
		animation.start();
	   

		scene.setOnKeyPressed(event);
	
		windows.show();
	
	
	}
	

}
