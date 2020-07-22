package com.jeuv1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heart extends GraphicObject{
	Image image=null;
	double x;
	double y;
public Heart(double x,double y) {
	// TODO Auto-generated constructor stub
this.x=x;
this.y=y;
	try {
		 image=new Image(new FileInputStream("imag/heart.png"));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	corps=new ImageView(image);
	((ImageView)corps).setX(0);
	((ImageView)corps).setY(0);
	corps.setTranslateX(x);
	corps.setTranslateY(y);
}
public Image getImage() {
	return image;
}
public void setImage() {
	try {
		 image=new Image(new FileInputStream("imag/heart1.png"));
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