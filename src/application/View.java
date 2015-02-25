package application;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

/**
 * Creates the view where the lines are drawn and the turtle is displayed.
 * 
 * @author Andrew Sun
 *
 */

public class View extends StackPane{
	
	private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
	private static final Color DEFAULT_PEN_COLOR = Color.BLACK;
	private static final Point2D DEFAULT_POINT = new Point2D(0,0);
	
	private static double XOFFSET, YOFFSET;
	private Point2D newStart, newDest;
	private double turtleAngle;
	private Canvas backgroundView, turtleView, linesView;
	
	private GraphicsContext backgroundGC, turtleGC, linesGC;
	private Color penColor;
	private ImageView myTurtle;
	
	/**
	 * Constructor for the view
	 * @param x width of canvas
	 * @param y height of canvas
	 */
	public View(int x, int y){
		
		backgroundView = new Canvas(x, y);
		turtleView = new Canvas(x, y);
		linesView = new Canvas(x, y);
		
		XOFFSET = x/2;
		YOFFSET = y/2;
		
		backgroundGC = backgroundView.getGraphicsContext2D();
		turtleGC = turtleView.getGraphicsContext2D();
		linesGC = linesView.getGraphicsContext2D();
		
		newDest = DEFAULT_POINT; // default point 
		penColor = DEFAULT_PEN_COLOR; // default color
		backgroundGC.setFill(DEFAULT_BACKGROUND_COLOR); // default background
		backgroundGC.fillRect(0, 0, x, y);
		
		myTurtle = new ImageView();
		
		 //for testing
//		Point2D orig = new Point2D(0, 0);
//		Point2D dest = new Point2D(-1600, -400);	
//		drawLine(orig, dest);
//		
		this.getChildren().addAll(backgroundView, linesView, turtleView);
		
		}

	public void initializeTurtle(Image turtle){
		myTurtle.setImage(turtle);
		turtleGC.drawImage(turtle, XOFFSET, YOFFSET);
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
	public void rotateAndMoveTurtle(Point2D newLoc, double angle){
		turtleGC.clearRect(0, 0, turtleView.getWidth(), turtleView.getHeight());
		turtleGC.save();
		rotate(angle, newDest.getX() + XOFFSET + myTurtle.getImage().getWidth()/2, 
				(newDest.getY() - YOFFSET + myTurtle.getImage().getHeight()/2)*-1);
        turtleGC.clearRect(0, 0, turtleView.getWidth(), turtleView.getHeight());
		turtleGC.drawImage(myTurtle.getImage(), newLoc.getX() + XOFFSET, (newLoc.getY()-YOFFSET)*-1);
    	turtleGC.restore();
	}
	
	public void showTurtle(boolean b){
		turtleView.setVisible(b);
	}
	
	public void updateTurtleImage(File loc){
        Image image = new Image("file:///" + loc.getPath());
		//turtleGC.save();
        myTurtle.setImage(image);
//		rotate(60, newDest.getX() + XOFFSET
//				+ myTurtle.getImage().getWidth() / 2, (newDest.getY() - YOFFSET
//				+ myTurtle.getImage().getHeight() / 2)*-1);
        turtleGC.clearRect(0, 0, turtleView.getWidth(), turtleView.getHeight());
    	turtleGC.drawImage(myTurtle.getImage(), newDest.getX() + XOFFSET, (newDest.getY()-YOFFSET)*-1);
    	//turtleGC.restore();
	}
	
	private void rotate(double angle, double x, double y) {
		Rotate r = new Rotate(angle, x, y);
		turtleGC.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(),
				r.getTx(), r.getTy());
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

	public void setBackgroundColor(Color c) {
		backgroundGC.setFill(c);
		backgroundGC.fillRect(0, 0, backgroundView.getWidth(), backgroundView.getHeight());
	}
}
