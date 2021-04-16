package com.wouterbaudoin.decorator;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public abstract class ShapeDrawer implements Shape {
	
	Group group;
	public Paint color = Color.BLACK;
	public Paint borderColor = Color.BLACK;
	Polygon polygon;
	
	public ShapeDrawer(Group group) {
		this.group = group;
	}
	
	public void drawPolygon(Double[] polygonPoints) {
		System.out.println("Draw polygons");
		Polygon polygon = new Polygon();  
		this.polygon = polygon;
		polygon.getPoints().addAll(polygonPoints);
		polygon.setFill(color);
		polygon.setStrokeWidth(4);
		polygon.setStroke(borderColor);
		group.getChildren().add(polygon);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setBorderColor(Color color) {
		this.borderColor = color;
	}
	
	public void clearPolygon() {
		group.getChildren().remove(polygon);
	}

}
