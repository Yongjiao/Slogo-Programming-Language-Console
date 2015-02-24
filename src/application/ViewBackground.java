package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Creates the background for the view
 * This class is necessary in order to separate the background from the drawn lines and the turtle
 * so that we can change background independently of the lines and turtle.
 * 
 * @author Andrew Sun
 *
 */

public class ViewBackground extends Canvas {
	
	private static final Color DEFAULT_COLOR = Color.WHITE;
	
	private GraphicsContext myGC;
	
	/**
	 * Constructor for the view background. The view background width and height
	 * should be the same as those of view.
	 * 
	 * @param x view background width
	 * @param y view background height
	 */
	public ViewBackground(int x, int y){
		this.setWidth(x);
		this.setHeight(y);
		myGC = this.getGraphicsContext2D();
		
		// default background
		myGC.setFill(DEFAULT_COLOR);
		myGC.fillRect(0, 0, x, y);
	}
	
	public void setBackground(Color c){
		myGC.setFill(c);
		myGC.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
