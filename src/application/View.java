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
		
		// for testing
		Point2D orig = new Point2D(0, 0);
		Point2D dest = new Point2D(-1600, -300);	
		drawLine(orig, dest);
		
		}
	
	/**
	 * set background image if user desires
	 * @param back
	 */
	public void setBackgroundImage(Image back)
	{
		//this.myBackgroundCanvasGraphCont.drawImage(back, 0, 0);
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
	public void drawLine(Point2D orig, Point2D dest){
	//	myGC.setStroke(c);
		Point2D p = findBoundaryPoint(orig, dest);
		if (p == null){
			myGC.strokeLine(orig.getX()+XCENTER, (orig.getY()-YCENTER)*-1, 
			dest.getX()+XCENTER, (dest.getY()-YCENTER)*-1);
		}
		else{
			myGC.strokeLine(orig.getX()+XCENTER, (orig.getY()-YCENTER)*-1,
					p.getX()+XCENTER, (p.getY()-YCENTER)*-1);
	//		drawLine(newStart, newDest, c);
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
		double slope = (dest.getY()-orig.getY())/(dest.getX()-orig.getX()); // slope of two points
		double mCorner = (YCENTER- orig.getY())/(XCENTER - orig.getX()); // slope from orig to corner
		if (dest.getX() > XCENTER && dest.getY() > YCENTER){
			return findCorner(XCENTER, YCENTER, mCorner, slope, dest);
		}
		else if (dest.getX() > XCENTER && dest.getY() < YCENTER*-1){
			return findCorner(XCENTER, YCENTER*-1, mCorner*-1, slope, dest);
		}
		else if (dest.getX() < XCENTER*-1 && dest.getY() > YCENTER){
			return findCorner(XCENTER*-1, YCENTER, mCorner*-1, slope, dest);
		}
		else if (dest.getX() < XCENTER*-1 && dest.getY() < YCENTER*-1){
			return findCorner(XCENTER*-1, YCENTER*-1, mCorner, slope, dest);
		}
		else if(dest.getX() > XCENTER){
			return findXEdge(XCENTER, slope, dest);
		}
		else if(dest.getX() < XCENTER*-1){
			return findXEdge(XCENTER*-1, slope, dest);
		}
		else if(dest.getY() > YCENTER){
			return findYEdge(YCENTER, slope, dest);
		}
		else if(dest.getY() < YCENTER*-1){
			return findYEdge(YCENTER*-1, slope, dest);
		}
		return null;
	}
	
	private Point2D findCorner(double x, double y, double mCorner, double slope, Point2D dest){
		if (mCorner > Math.abs(slope)){
			// use y axis
			return findYEdge(y, slope, dest);
		}
		else{
			// use x axis
			return findXEdge(x, slope, dest);
		}
	}
	
	private Point2D findXEdge(double x, double slope, Point2D dest){
		double ycoord = slope*x + dest.getY() - dest.getX()*slope;
		newStart = new Point2D(x*-1, ycoord);
		newDest = new Point2D(dest.getX()-x*2, dest.getY());
		return new Point2D(x, ycoord);
	}
	
	private Point2D findYEdge(double y, double slope, Point2D dest){
		double xcoord = (y-dest.getY() + dest.getX()*slope)/slope;
		newStart = new Point2D(xcoord, y*-1);
		newDest = new Point2D(dest.getX(), dest.getY()-y*2);
		return new Point2D(xcoord, y);
	}
	
	
	/**
	 * changes location and/or orientation of turtle image
	 * @param newLoc
	 * @param turtleImage
	 * @author Anika (version 1)
	 */
	public void changeTurtleImage(Point2D newLoc, ImageView turtleImage){
		// TODO: handle location and orientation and visibility of turtle

		// clear turtle canvas, then relocate image
		//this.turtleGraphCont.clearRect(0, 0, this.myTurtleCanvas.getWidth(), this.myTurtleCanvas.getHeight());

		if (turtleImage.isVisible())
		{
			// if turtle is not hidden, put turtle on new location on screen

			double xViewLoc = newLoc.getX() + this.XCENTER;
			double yViewLoc = newLoc.getY() + this.YCENTER;

			Point2D viewLocation = new Point2D(xViewLoc, yViewLoc);

			//TODO: rotation

			//	this.turtleGraphCont.drawImage((turtleImage), xViewLoc, yViewLoc);
		}
	}

	public void clearScreen(){
		//this.myLines.clearRect(0, 0, this.myBackgroundCanvas.getWidth(), this.myBackgroundCanvas.getHeight());
	}
}
