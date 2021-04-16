package com.wouterbaudoin.decorator;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class CircleShape extends ShapeDrawer {
	
	Circle circle;
	
	public CircleShape(Group group) {
		super(group);
	}

	@Override
	public void draw() {
		System.out.println("Shape: Circle");		
		Circle circle = new Circle();  
		this.circle = circle;
		circle.setCenterX(550);  
		circle.setCenterY(350);  
		circle.setRadius(100);  
		circle.setFill(color);
		circle.setStrokeWidth(4);
		circle.setStroke(borderColor);
		group.getChildren().add(circle);
	}

	public void clear() {
		System.out.println("Removed: Circle");
		group.getChildren().remove(circle);
	}

}
