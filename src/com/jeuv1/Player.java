package com.jeuv1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends GraphicObject{
	
public Player(Zone zone){
	Image image=null;
	try {
		 image=new Image(new FileInputStream("imag/soldier.png"));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
				corps=new ImageView(image);
				((ImageView)corps).setX(0);
				((ImageView)corps).setY(0);
				double x=zone.getX1()+(zone.getX2()-zone.getX1())*0.001;
				double y=zone.getY1()+(zone.getY2()-zone.getY1())*0.43;
				corps.setTranslateX(x);
				corps.setTranslateY(y);
		// TODO Auto-generated constructor stub
	}
	


}
