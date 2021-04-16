package com.wouterbaudoin.decorator;

import javafx.scene.paint.Color;

public interface Shape {
	void draw();
	void clear();
	void setColor(Color color);
	void setBorderColor(Color color);
	void drawPolygon(Double[] polygonPoints);
	void clearPolygon();
}