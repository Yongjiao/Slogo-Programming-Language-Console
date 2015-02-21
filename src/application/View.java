package application;

import java.awt.Point;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

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
		
		XCENTER = myTurtleCanvas.getWidth()/2;
		YCENTER = myTurtleCanvas.getHeight()/2;
			
	}
	
	
	
	public void drawLine(Point2D originalLocation, Point2D newLocation, Pen pen){
		// TODO: draw a line from point originalLocation to newLocation
		// draw line if pen status  = 1 get color from turtleHandler with TH.getPenColor()
		// TODO: check for boundary conditions
	}
	
	/**
	 * possible helper method
	 */
	public void checkBoundaryConditions()
	{
		// TODO
	}
	
	/**
	 * changes location and/or orientation of turtle image
	 * @param newLoc
	 * @param turtleImage
	 */
	public void changeTurtleImage(Point2D newLoc, ImageView turtleImage){
		// TODO: handle location and orientation of turtle
	}
	
	public void clearScreen(){
		this.linesGraphCont.clearRect(0, 0, this.myBackgroundCanvas.getWidth(), this.myBackgroundCanvas.getHeight());
	}
}
