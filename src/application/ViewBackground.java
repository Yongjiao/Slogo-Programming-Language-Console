package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Creates the background for the view
 * 
 * @author Andrew Sun
 *
 */

public class ViewBackground extends Canvas {
	
	private static final Color DEFAULT_COLOR = Color.WHITE;
	
	private GraphicsContext myGC;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public ViewBackground(int x, int y){
		this.setWidth(x);
		this.setHeight(y);
		myGC = this.getGraphicsContext2D();
		
		// default background
		myGC.setFill(DEFAULT_COLOR);
		myGC.fillRect(0, 0, x, y);
	}
	
	
	
}
