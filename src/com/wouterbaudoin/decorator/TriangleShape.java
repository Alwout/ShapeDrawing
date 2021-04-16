package com.wouterbaudoin.decorator;

import javafx.scene.Group;
import javafx.scene.shape.Polygon;

public class TriangleShape extends ShapeDrawer {
	
	Polygon triangle;
	
	public TriangleShape(Group group) {
		super(group);
	}

	@Override
	public void draw() {		
		Polygon triangle = new Polygon();  
		this.triangle = triangle;
		triangle.getPoints().addAll(new Double[]{  
				550.0, 250.0,  
				450.0, 450.0,  
				650.0, 450.0 });
		triangle.setFill(color);
		triangle.setStrokeWidth(4);
		triangle.setStroke(borderColor);
		group.getChildren().add(triangle);
	}

	@Override
	public void clear() {
		group.getChildren().remove(triangle);
	}

}
