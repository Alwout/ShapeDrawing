package com.wouterbaudoin.decorator;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class RectangleShape extends ShapeDrawer {
	
	Rectangle rect;
	
	public RectangleShape(Group group) {
		super(group);
	}

	@Override
	public void draw() {
		System.out.println("Shape: rectangle");
		Rectangle rect = new Rectangle(); //instantiating Rectangle
		this.rect = rect;
	    rect.setX(450); //setting the X coordinate of upper left //corner of rectangle   
	    rect.setY(250); //setting the Y coordinate of upper left //corner of rectangle   
	    rect.setWidth(200); //setting the width of rectangle   
	    rect.setHeight(200); // setting the height of rectangle   
	    rect.setFill(color);
	    rect.setStrokeWidth(4);
	    rect.setStroke(borderColor);
	    group.getChildren().add(rect);
	}

	@Override
	public void clear() {
		System.out.println("Clear: rectangle");
		group.getChildren().remove(rect);
	}

}
