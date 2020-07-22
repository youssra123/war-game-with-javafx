package com.jeuv1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Monstre extends GraphicObject{
	Image image=null;
	Image image1=null;
	double x,y;
	
	public Monstre(Zone zone) {
		// TODO Auto-generated constructor stub
		
		try {
			 this.image= new Image("file:///C:/Users/fadla/eclipse-workspace/jeu_guerre/imag/g1.gif", 120, 100, false, false);
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
					corps=new ImageView(this.image);
				
					((ImageView)corps).setX(0);
					((ImageView)corps).setY(0);
					 x=zone.getX1()+(zone.getX2()-zone.getX1())*Math.random();
					 y=zone.getY1()+(zone.getY2()-zone.getY1())*Math.random();
					
					corps.setTranslateX(x);
					corps.setTranslateY(y+70);
					FXMLDocumentController fx=new FXMLDocumentController(((ImageView)corps));
					fx.rotateImage();
	}


	public Image getImage() {
		return image;
	}

	public void setImage() {
		try {
			 image=new Image(new FileInputStream("imag/fire.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
					corps=new ImageView(image);
					((ImageView)corps).setX(0);
					((ImageView)corps).setY(0);
				
					
					corps.setTranslateX(this.x);
					corps.setTranslateY(this.y);
		
	}

}
