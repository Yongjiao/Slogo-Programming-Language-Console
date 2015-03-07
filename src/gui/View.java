package gui;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;

/**
 * Creates the view where the lines are drawn and the turtle is displayed.
 * 
 * @author Andrew Sun
 *
 */

public abstract class View extends Canvas {
	
	private static double XOFFSET, YOFFSET;
	private static final Point2D DEFAULT_POINT = new Point2D(0,0);
	private static Point2D newDest;
	
	public View(int x, int y){
		this.setWidth(x);
		this.setHeight(y);
		XOFFSET = x/2;
		YOFFSET = y/2;
		newDest = DEFAULT_POINT;
	}
	
	/**
	 * Returns new point that of the turtle location
	 * @return
	 */
	public Point2D getNewPoint(){
		return newDest;
	}
	
	public void setNewPoint(Point2D dest){
		newDest = dest;
	}
	
	public double getXOffset(){
		return XOFFSET;
	}

	public double getYOffset(){
		return YOFFSET;
	}
}
