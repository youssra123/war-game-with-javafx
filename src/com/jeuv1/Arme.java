package com.jeuv1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Arme  extends GraphicObject{
	private Image image=null;
	//private Rectangle corps=new Rectangle(-6,0,10,50);
	//private  Circle sortie=new Circle(0,0,5);
	
	public void attachToPlayer(Player player) {
		corps.setTranslateX(player.getCorps().getTranslateX());
		corps.setTranslateY(player.getCorps().getTranslateY());
	   /* sortie.setTranslateX(player.getCorps().getTranslateX());
	    sortie.setTranslateX(player.getCorps().getTranslateY());*/
		updateSortie();
		

	}
	/*public ImageView getCorps() {
		return image;
	}*/
	/*public void setCorps(Rectangle corps) {
		this.corps = corps;
	}*/
	/*public Image getSortie() {
		return image;
	}*/
	public void setSortie(Image image) {
		this.image = image;
	}
	public Arme(double x,double y) {
		// TODO Auto-generated constructor stub
		Image image=null;
		try {
			 image=new Image(new FileInputStream("imag/rifle.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		corps=new ImageView(image);
		((ImageView)corps).setX(0);
		((ImageView)corps).setY(0);
		corps.setTranslateX(x);
		corps.setTranslateY(y);
	

	}
	public Arme(GraphicObject player) {
		
		try {
			 image=new Image(new FileInputStream("imag/rifle.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
					corps=new ImageView(image);
					((ImageView)corps).setX(15);
					((ImageView)corps).setY(-10);
					
		corps.setTranslateX(player.getCorps().getTranslateX());
		corps.setTranslateY(player.getCorps().getTranslateY());
		//sortie.setTranslateX(player.getCorps().getTranslateX());
	    //sortie.setTranslateX(player.getCorps().getTranslateY());
		
		//sortie.setFill(Color.CORAL);
		updateSortie();
	}
	public void updateSortie() {
		corps.setTranslateX(corps.getTranslateX());
		corps.setTranslateY(corps.getTranslateY());

	}
	public void rotateLeft() {
		corps.setRotate(corps.getRotate()+5);

	}
	
	public void rotateRight() {
		corps.setRotate(corps.getRotate()-5);

	}
	public double getRotate() {
		return corps.getRotate()-45;

	}

	
}
