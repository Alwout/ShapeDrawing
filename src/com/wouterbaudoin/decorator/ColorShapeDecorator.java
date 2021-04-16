package com.wouterbaudoin.decorator;

import javafx.scene.paint.Color;

public class ColorShapeDecorator extends ShapeDecorator {
	public Color color;
	
	public ColorShapeDecorator(Color color, Shape decoratedShape) {
		super(decoratedShape);
		this.color = color;
		setColor(color);
	}
	
}
