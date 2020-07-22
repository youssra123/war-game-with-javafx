package com.jeuv1;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Balle extends GraphicObject{
private Point2D direction=new Point2D(0, 0);
	public Balle(Arme arme) {
		corps=new Circle(0,0,4,Color.BLUE);
		corps.setTranslateX(arme.getCorps().getTranslateX()+145);
		corps.setTranslateY(arme.getCorps().getTranslateY()+100);
		updateDirection(arme.getRotate());
		// TODO Auto-generated constructor stub
	}
	public Balle(Monstre arme) {
		corps=new Circle(0,0,4,Color.BLUE);
		corps.setTranslateX(arme.getCorps().getTranslateX()+80);
		corps.setTranslateY(arme.getCorps().getTranslateY()+100);
		Point2D p;
		double x=Math.cos(Math.toRadians(90));
		double y=Math.sin(Math.toRadians(90));
		p=new Point2D(x, y);
		direction=p.normalize().multiply(7);
		//updateDirection(arme.getRotate());
		// TODO Auto-generated constructor stub
	}
/*	public Balle(Monstre mo) {
		corps=new Circle(0,0,4,Color.BLUE);
		corps.setTranslateX(mo.getCorps().getTranslateX()+145);
		corps.setTranslateY(mo.getCorps().getTranslateY()+100);
		// TODO Auto-generated constructor stub
	}*/
	 private void updateDirection(double rotation) {
		Point2D p;
		double x=Math.cos(Math.toRadians(rotation));
		double y=Math.sin(Math.toRadians(rotation));
		p=new Point2D(x, y);
		direction=p.normalize().multiply(7);

	}
	 public void update() {
		corps.setTranslateX(corps.getTranslateX()+direction.getX());
		
		corps.setTranslateY(corps.getTranslateY()+direction.getY());

	}

}
