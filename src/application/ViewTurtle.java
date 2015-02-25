package application;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class ViewTurtle extends Canvas {
	
	private ImageView myTurtle;
	private GraphicsContext myGC;
	private static double XOFFSET, YOFFSET;
	
	public ViewTurtle(ImageView turtle, double x, double y){
		myTurtle = turtle;
		this.setWidth(x);
		this.setHeight(y);
		XOFFSET = x/2;
		YOFFSET = y/2;
		myGC = this.getGraphicsContext2D();
		myGC.drawImage(myTurtle.getImage(), XOFFSET, YOFFSET);
	}
	
	public void moveTurtle(Point2D p){
		
	}
	
	public void rotateTurtle(double deg){
		
	}
	
	
	
}
