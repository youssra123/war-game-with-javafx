package com.jeuv1;

import javafx.scene.Node;

public class GraphicObject {
	protected Node corps;
	private boolean alive=true;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	
	}

	public GraphicObject() {
	}

	public Node getCorps() {
		return corps;
	}
	public boolean isDead() {	
	return !alive;

}
	public void setCorps(Node corps) {
		this.corps = corps;
	}
public boolean touch(GraphicObject obj) {
	return corps.getBoundsInParent().intersects(obj.getCorps().getBoundsInParent());
	// TODO Auto-generated method stub

}
	
	

}
