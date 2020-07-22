package com.jeuv1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class Level {
Image image;
BackgroundImage myBI;
	public BackgroundImage getMyBI() {
	return myBI;
}
public void setMyBI(BackgroundImage myBI) {
	this.myBI = myBI;
}
	public Level() {
		try {
			 image=new Image(new FileInputStream("imag/forest.jpg"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		//Group backgGroup;
		ImageView mv=new ImageView(image);
	/*	mv.setFitHeight(900);
		mv.setFitWidth(1500);
		ImageView mv1=new ImageView(image1);
		mv1.setFitHeight(900);
		mv1.setFitWidth(1500);
		ImageView mv2=new ImageView(image2);
		mv2.setFitHeight(900);
		mv2.setFitWidth(1500);
		backgGroup=new Group(mv);
		Timeline t=new Timeline();
		t.setCycleCount(Timeline.INDEFINITE);
		t.getKeyFrames().add(new KeyFrame(
				Duration.millis(1200),
				(ActionEvent event) -> {backgGroup.getChildren().setAll(mv);}));
		t.getKeyFrames().add(new KeyFrame(
				Duration.millis(2400),
				(ActionEvent event) -> {backgGroup.getChildren().setAll(mv1);}));
		t.getKeyFrames().add(new KeyFrame(
				Duration.millis(4800),
				(ActionEvent event) -> {backgGroup.getChildren().setAll(mv2);}));
		t.play();*/
			//Image image = getImage("imag/game-background-p4-4.jpg");
			/*container.setStyle("-fx-background-image: url('imag/game-background-p4-4.jpg'); " +
			           "-fx-background-position: center center; " +
			           "-fx-background-repeat: stretch;");*/

			 
	        myBI = new BackgroundImage(image,
	               BackgroundRepeat.NO_REPEAT,
	               BackgroundRepeat.NO_REPEAT,
	               BackgroundPosition.DEFAULT,
	               new BackgroundSize(BackgroundSize.AUTO, 900, true, true, true, true));
	        	//then you set to your node
	    
	}

}
