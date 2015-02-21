package application;

import java.awt.Point;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class View{
	
	private Canvas myTurtleCanvas;
	private Canvas myBackgroundCanvas;
	private GraphicsContext turtleGraphCont;
	private GraphicsContext linesGraphCont;
	private static double XCENTER, YCENTER;
	
	
	public View(int x, int y){
		myTurtleCanvas.setWidth(x);
		myBackgroundCanvas.setWidth(x);
		myTurtleCanvas.setHeight(y);
		myBackgroundCanvas.setHeight(y);
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
