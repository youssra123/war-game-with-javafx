package com.jeuv1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tank extends GraphicObject{
	Image image=null;
	Image image1=null;
	double x,y;
	
	public Tank(Zone zone) {
		// TODO Auto-generated constructor stub
		
		try {
			 this.image=new Image(new FileInputStream("imag/tank.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
					corps=new ImageView(this.image);
					((ImageView)corps).setX(0);
					((ImageView)corps).setY(0);
					 x=zone.getX1()+(zone.getX2()-zone.getX1())*Math.random();
					 y=zone.getY1()+(zone.getY2()-zone.getY1())*Math.random()-40;
					
					corps.setTranslateX(x);
					corps.setTranslateY(y);
					FXMLDocumentController fx=new FXMLDocumentController(((ImageView)corps));
					fx.rotateImage();
	}




}
