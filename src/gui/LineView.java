package gui;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LineView extends View {
	
	private GraphicsContext linesGC;
	private double XOFFSET, YOFFSET;
	private static final Color DEFAULT_PEN_COLOR = Color.BLACK;
	private Point2D newStart, newDest;

	public LineView(int x, int y) {
		super(x, y);
		linesGC = this.getGraphicsContext2D();
		linesGC.setStroke(DEFAULT_PEN_COLOR); // default color
		newDest = this.getNewPoint();
		XOFFSET = x/2;
		YOFFSET = y/2;
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
		Point2D p = findBoundaryPoint(orig, dest);
		if (p == null){
			linesGC.strokeLine(orig.getX()+XOFFSET, (orig.getY()-YOFFSET)*-1, 
			dest.getX()+XOFFSET, (dest.getY()-YOFFSET)*-1);
			newDest = dest;
			this.setNewPoint(newDest);
			// turtleAngle = Math.toDegrees(Math.atan2((dest.getY()-orig.getY()), (dest.getX()-orig.getX())));
		}
		else{
			linesGC.strokeLine(orig.getX()+XOFFSET, (orig.getY()-YOFFSET)*-1,
					p.getX()+XOFFSET, (p.getY()-YOFFSET)*-1);
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
		if (dest.getX() > XOFFSET && dest.getY() > YOFFSET){
			double mCorner = (YOFFSET- orig.getY())/(XOFFSET - orig.getX()); // slope from orig to corner
			return findCorner(XOFFSET, YOFFSET, mCorner, slope, dest);
		}
		else if (dest.getX() > XOFFSET && dest.getY() < YOFFSET*-1){
			double mCorner = (YOFFSET*-1- orig.getY())/(XOFFSET - orig.getX()); // slope from orig to corner
			return findCorner(XOFFSET, YOFFSET*-1, mCorner, slope, dest);
		}
		else if (dest.getX() < XOFFSET*-1 && dest.getY() > YOFFSET){
			double mCorner = (YOFFSET- orig.getY())/(XOFFSET*-1 - orig.getX()); // slope from orig to corner
			return findCorner(XOFFSET*-1, YOFFSET, mCorner, slope, dest);
		}
		else if (dest.getX() < XOFFSET*-1 && dest.getY() < YOFFSET*-1){
			double mCorner = (YOFFSET*-1- orig.getY())/(XOFFSET*-1 - orig.getX()); // slope from orig to corner
			return findCorner(XOFFSET*-1, YOFFSET*-1, mCorner, slope, dest);
		}
		else if(dest.getX() > XOFFSET){
			return findXEdge(XOFFSET, slope, dest);
		}
		else if(dest.getX() < XOFFSET*-1){
			return findXEdge(XOFFSET*-1, slope, dest);
		}
		else if(dest.getY() > YOFFSET){
			return findYEdge(YOFFSET, slope, dest);
		}
		else if(dest.getY() < YOFFSET*-1){
			return findYEdge(YOFFSET*-1, slope, dest);
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
		this.setNewPoint(newDest);
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
		this.setNewPoint(newDest);
		return new Point2D(xcoord, y);
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
		linesGC.setStroke(c);
	}
	

	public void setThickness(double lw){
		linesGC.setLineWidth(lw);
	}
	
	public void setParamsOfPen(Color color, double thickness)
	{
		linesGC.setStroke(color);
		linesGC.setLineWidth(thickness);
	}
	
}
