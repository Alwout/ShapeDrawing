package com.wouterbaudoin.decorator;

import javafx.scene.paint.Color;

public abstract class ShapeDecorator implements Shape {
	protected Shape decoratedShape;
	
	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}
	
	public void draw() {
		decoratedShape.draw();
	}
	
	public void drawPolygon(Double[] polygonPoints) {
		decoratedShape.drawPolygon(polygonPoints);
	}
	
	public void clear() {
		decoratedShape.clear();
	}
	
	public void clearPolygon() {
		decoratedShape.clearPolygon();
	}
	
	public void setColor(Color color) {
		decoratedShape.setColor(color);
	}

	public void setBorderColor(Color color) {
		decoratedShape.setBorderColor(color);
	}
}
