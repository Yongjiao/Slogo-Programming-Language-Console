package application;


import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Creates the view where the lines are drawn and the turtle is displayed.
 * 
 * @author Andrew Sun
 *
 */

public class View extends Canvas{
	
	private static double XCENTER, YCENTER;
	private Point2D newStart, newDest;
	
	private GraphicsContext myGC;
	
	/**
	 * Constructor for the view
	 * @param x width of canvas
	 * @param y height of canvas
	 */
	public View(int x, int y){
		
		this.setWidth(x);
		this.setHeight(y);
		
		XCENTER = x/2;
		YCENTER = y/2;
		
		myGC = this.getGraphicsContext2D();
		
		// draw rectangle for background color
		myGC.setFill(Color.WHITE);
		myGC.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// for testing
		Point2D orig = new Point2D(0, 0);
		Point2D dest = new Point2D(250, 100);
		
		drawLine(orig, dest, Color.BLACK);
		
		}
	
	
	public void setBackgroundImage(Image back)
	{
		//TODO: change image of BackgroundCanvas
	}
	
	public void setBackgroundColor(Color newC)
	{
		myGC.setFill(newC);
	}
	
	/**
	 * Draws a line from one point to another
	 * Accounts for destination point being out of bounds of canvas
	 * 
	 * @param orig original coordinates of the turtle (turtle coordinate system)
	 * @param dest destination coordinates of the turtle (turtle coordinate system)
	 * @param c color of line drawn
	 */
	public void drawLine(Point2D orig, Point2D dest, Color c){
		myGC.setStroke(c);
		Point2D p = findBoundaryPoint(orig, dest);
		if (p == null){
			myGC.strokeLine(orig.getX()+XCENTER, (orig.getY()-YCENTER)*-1, 
			dest.getX()+XCENTER, (dest.getY()-YCENTER)*-1);
		}
		else{
			myGC.strokeLine(orig.getX()+XCENTER, (orig.getY()-YCENTER)*-1,
					p.getX()+XCENTER, (p.getY()-YCENTER)*-1);
			drawLine(newStart, newDest, c);
		}
	}
	
	/**
	 * This helper method returns a point where the turtle crosses a boundary.
	 * If the turtle doesn't cross a boundary, the method returns null.
	 * 
	 * @param orig original coordinates of the turtle (turtle coordinate system)
	 * @param dest destination coordinates of the turtle (turtle coordinate system)
	 * @return a point where the turtle crosses a boundary
	 */
	private Point2D findBoundaryPoint(Point2D orig, Point2D dest){
		double slope = (dest.getY()-orig.getY())/(dest.getX()-orig.getX());
		if (dest.getX() > XCENTER && dest.getY() > YCENTER){
			// find slope of corner
			double mCorner = (YCENTER- orig.getY())/(XCENTER - orig.getX());
			if (mCorner > slope){
				// use y axis
			}
			else if (mCorner < slope){
				// use x axis
			}
			else{
				// switch corners
			}
		}
		else if (dest.getX() > XCENTER && dest.getY() < YCENTER*-1){
			
		}
		else if (dest.getX() < XCENTER*-1 && dest.getY() > YCENTER){
			
		}
		else if (dest.getX() < XCENTER*-1 && dest.getY() < YCENTER*-1){
			
		}
		else if(dest.getX() > XCENTER){
			// find ycoordinate of out of bounds intersection
			double ycoord = slope*XCENTER + dest.getY() - dest.getX()*slope;
			newStart = new Point2D(XCENTER*-1, ycoord);
			newDest = new Point2D(dest.getX()-XCENTER*2, dest.getY());
			return new Point2D(XCENTER, ycoord);
		}
		else if(dest.getX() < XCENTER*-1){
			
		}
		else if(dest.getY() > YCENTER){
			
		}
		else if(dest.getY() < YCENTER*-1){
			
		}
		return null;
	}
	

	/**
	 * changes location and/or orientation of turtle image
	 * @param newLoc
	 * @param turtleImage
	 */
	public void changeTurtleImage(Point2D newLoc, ImageView turtleImage){
		// TODO: handle location and orientation and visibility of turtle
	}
	
	public void clearScreen(){
		//this.myLines.clearRect(0, 0, this.myBackgroundCanvas.getWidth(), this.myBackgroundCanvas.getHeight());
	}
}
