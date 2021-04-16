package com.wouterbaudoin.decorator;

public class PolyShapeDecorator extends ShapeDecorator {
	
	Double[] polygonPoints;

	public PolyShapeDecorator(Double[] polygonPoints, Shape decoratedShape) {
		super(decoratedShape);
		this.polygonPoints = polygonPoints;
	}
	
	@Override
	public void draw() {
		decoratedShape.drawPolygon(polygonPoints);
	}
	
	@Override
	public void clear() {
		decoratedShape.clearPolygon();
	}

}
