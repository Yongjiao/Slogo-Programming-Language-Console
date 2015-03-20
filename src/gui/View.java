package gui;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;

/**
 * General abstract View class which contains
 * methods and variables that are shared by all Views
 * 
 * @author Andrew Sun
 *
 */

public abstract class View extends Canvas {
	
	private static double XOFFSET, YOFFSET;
	private static final Point2D DEFAULT_POINT = new Point2D(0,0);
	private static Point2D newDest;
	
	/**
	 * Constructor
	 * @param x width
	 * @param y height
	 */
	public View(int x, int y){
		this.setWidth(x);
		this.setHeight(y);
		XOFFSET = x/2;
		YOFFSET = y/2;
		newDest = DEFAULT_POINT;
	}
	
	/**
	 * Returns new point that of the turtle location
	 * @return new turtle destination
	 */
	public Point2D getNewPoint(){
		return newDest;
	}
	
	/**
	 * sets the new turtle destination point
	 * @param dest
	 */
	public void setNewPoint(Point2D dest){
		newDest = dest;
	}
	
	/**
	 * Gets XOffset of turtle
	 * @return
	 */
	public double getXOffset(){
		return XOFFSET;
	}
	
	/**
	 * Gets YOffset of turtle
	 * @return
	 */
	public double getYOffset(){
		return YOFFSET;
	}
}
