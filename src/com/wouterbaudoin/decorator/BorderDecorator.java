package com.wouterbaudoin.decorator;

import javafx.scene.paint.Color;

public class BorderDecorator extends ShapeDecorator {
	public Color color;
	
	public BorderDecorator(Color color, Shape decoratedShape) {
		super(decoratedShape);
		this.color = color;
		setBorderColor(color);
	}

}
