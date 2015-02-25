package application;


import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * Creates the view where the lines are drawn and the turtle is displayed.
 * 
 * @author Andrew Sun
 *
 */

public class View extends StackPane{
	
	private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
	
	private static double XCENTER, YCENTER;
	private Point2D newStart, newDest;
	private double turtleAngle;
	private Canvas backgroundView, turtleView, linesView;
	
	private GraphicsContext backgroundGC, turtleGC, linesGC;
	private Color penColor;
	private ViewTurtle myTurtleView;
	
	/**
	 * Constructor for the view
	 * @param x width of canvas
	 * @param y height of canvas
	 */
	public View(int x, int y){
		
		backgroundView = new Canvas(x, y);
		turtleView = new Canvas(x, y);
		linesView = new Canvas(x, y);
		
		XCENTER = x/2;
		YCENTER = y/2;
		
		backgroundGC = backgroundView.getGraphicsContext2D();
		turtleGC = turtleView.getGraphicsContext2D();
		linesGC = linesView.getGraphicsContext2D();
		
		newDest = new Point2D(0, 0); // default point 
		penColor = Color.BLACK; // default color
		turtleAngle = 0;
		
		// for testing
//		Point2D orig = new Point2D(0, 0);
//		Point2D dest = new Point2D(-1600, -400);	
//		drawLine(orig, dest);
		}
	
	public void initializeTurtle(ImageView turtle){
		myTurtleView = new ViewTurtle(turtle, this.getWidth(), this.getHeight());
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
		linesGC.setStroke(penColor);
		Point2D p = findBoundaryPoint(orig, dest);
		if (p == null){
			linesGC.strokeLine(orig.getX()+XCENTER, (orig.getY()-YCENTER)*-1, 
			dest.getX()+XCENTER, (dest.getY()-YCENTER)*-1);
			newDest = dest;
			// turtleAngle = Math.toDegrees(Math.atan2((dest.getY()-orig.getY()), (dest.getX()-orig.getX())));
		}
		else{
			linesGC.strokeLine(orig.getX()+XCENTER, (orig.getY()-YCENTER)*-1,
					p.getX()+XCENTER, (p.getY()-YCENTER)*-1);
			//moveTurtle(p.getX()+XCENTER, (p.getY()-YCENTER)*-1));
			drawLine(newStart, newDest);
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
		if (dest.getX() > XCENTER && dest.getY() > YCENTER){
			double mCorner = (YCENTER- orig.getY())/(XCENTER - orig.getX()); // slope from orig to corner
			return findCorner(XCENTER, YCENTER, mCorner, slope, dest);
		}
		else if (dest.getX() > XCENTER && dest.getY() < YCENTER*-1){
			double mCorner = (YCENTER*-1- orig.getY())/(XCENTER - orig.getX()); // slope from orig to corner
			return findCorner(XCENTER, YCENTER*-1, mCorner, slope, dest);
		}
		else if (dest.getX() < XCENTER*-1 && dest.getY() > YCENTER){
			double mCorner = (YCENTER- orig.getY())/(XCENTER*-1 - orig.getX()); // slope from orig to corner
			return findCorner(XCENTER*-1, YCENTER, mCorner, slope, dest);
		}
		else if (dest.getX() < XCENTER*-1 && dest.getY() < YCENTER*-1){
			double mCorner = (YCENTER*-1- orig.getY())/(XCENTER*-1 - orig.getX()); // slope from orig to corner
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
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param mCorner
	 * @param slope
	 * @param dest
	 * @return
	 */
	private Point2D findCorner(double x, double y, double mCorner, double slope, Point2D dest){
		if (Math.abs(mCorner) < Math.abs(slope)){
			return findYEdge(y, slope, dest);
		}
		else{
			return findXEdge(x, slope, dest);
		}
	}
	
	/**
	 * 
	 * @param x
	 * @param slope
	 * @param dest
	 * @return
	 */
	private Point2D findXEdge(double x, double slope, Point2D dest){
		double ycoord = slope*x + dest.getY() - dest.getX()*slope;
		newStart = new Point2D(x*-1, ycoord);
		newDest = new Point2D(dest.getX()-x*2, dest.getY());
		return new Point2D(x, ycoord);
	}
	
	/**
	 * 
	 * @param y
	 * @param slope
	 * @param dest
	 * @return
	 */
	private Point2D findYEdge(double y, double slope, Point2D dest){
		double xcoord = (y-dest.getY() + dest.getX()*slope)/slope;
		newStart = new Point2D(xcoord, y*-1);
		newDest = new Point2D(dest.getX(), dest.getY()-y*2);
		return new Point2D(xcoord, y);
	}
	
	/**
	 * 
	 * @return
	 */
	public Point2D getNewPoint(){
		return newDest;
	}
	
	/**
	 * changes location and/or orientation of turtle image
	 * @param newLoc
	 * @param turtleImage
	 * 
	 */
	public void rotateAndMoveTurtle(Point2D newLoc, ImageView turtleImage){
		// TODO: handle location and orientation and visibility of turtle

		// clear turtle canvas, then relocate image
		//this.turtleGraphCont.clearRect(0, 0, this.myTurtleCanvas.getWidth(), this.myTurtleCanvas.getHeight());

		
		
		if (turtleImage.isVisible())
		{
			// if turtle is not hidden, put turtle on new location on screen

//			double xViewLoc = newLoc.getX() + this.XCENTER;
//			double yViewLoc = newLoc.getY() + this.YCENTER;
//
//			Point2D viewLocation = new Point2D(xViewLoc, yViewLoc);

			//TODO: rotation

			//	this.turtleGraphCont.drawImage((turtleImage), xViewLoc, yViewLoc);
		}
	}
	
	public void showTurtle(boolean b){
		turtleView.setVisible(b);
	}
	
	public void updateTurtleImage(ImageView turtleImage){
		
	}

	/**
	 * Clears all lines
	 */
	public void clearScreen(){
		linesGC.clearRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	/**
	 * Sets color of line drawn
	 * @param c
	 */
	public void setColor(Color c){
		penColor = c;
	}
}
