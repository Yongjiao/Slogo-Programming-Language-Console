package application;

import java.awt.Point;

import javafx.scene.canvas.Canvas;

public class View extends Canvas {
	
	private int myWidth, myHeight;
	
	public View(int x, int y){
		myWidth = x;
		myHeight = y;
		this.setWidth(myWidth);
		this.setHeight(myHeight);
		// TODO: implement other parameter, such as color, etc.
	}
	
	public void drawLine(Point p1, Point p2){
		// TODO: draw a line from point p1 to p2
	}
	
	public void changeTurtleImage(){
		// TODO: implement
	}
	
	public void clearScreen(){
		// TODO: implement
	}
}
