package application;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
/**
 * 
 * Feb 22, 2015
 * NOTE: Turtle Coordinate system
 * 			
 * 			^ +y
 * 			|
 * 			|
 * 			|
 * ------------------> +x
 * 			|
 * 			|
 * 			|
 * 			|
 * 
 * Canvas / View coordinate system
 * 
 * ------------------> +x
 * |
 * |
 * |
 * |
 * |
 * |
 * |
 * v +y
 * 
 * 
 * Therefore, to center the turtle based on the middle of the canvas,
 * put turtle at [(turtleCoordX + X_CENTER), (turtleCoordY - Y_CENTER)]
 * 
 * Therefore, movement methods are formatted as follows:
 * 
 * public void moveTurtle(int dist)
 * {
 * 		myTurtle.setLocation(getViewTurtleLocation());
 * 		Point2D origLoc = myTurtle.getLoc();
 * 		myTurtle.move(dist);
 * 		Point2D newLoc = myTurtle.getLoc();
 * 		this.moveTurtleImageAndDraw(origLoc, newLoc); // pass View new location
 * 		// view calculates new location in terms of turtle coordinates
 * 		myTurtle.setLocation(getViewTurtleLocation());
 * 
 * }
 * 
 * 
 * @author anika
 *
 */
public class TurtleHandler {
	
	private View myView;
	private Turtle myTurtle;
	
	public TurtleHandler(View v, Turtle t){
		myView = v;
		myTurtle = t;
	}
	
	/**
	 * * NOTE: Turtle Coordinate system
	 * 			
	 * 			^ +y
	 * 			|
	 * 			|
	 * 			|
	 * ------------------> +x
	 * 			|
	 * 			|
	 * 			|
	 * 			|
	 * 
	 * Canvas / View coordinate system
	 * 
	 * ------------------> +x
	 * |
	 * |
	 * |
	 * |
	 * |
	 * |
	 * |
	 * v +y
	 * 
	 * 
	 * therefore, for the Canvas below:
	 * 
	 * 				|--a--|
	 * ===========================
	 * ||		    |			||
	 * ||		    |			|| _._
	 * ||		    |	 Q		||  |
	 * ||		    |			||  b
	 * ||___________|___________|| _|_
	 * ||		    |			||
	 * ||		    |			||
	 * ||		    |			||
	 * ||		    |			||
	 * ===========================
	 * 
	 * Point Q in turtle coordinates 	= [(XCENTER + a), (YCENTER + b)]
	 * while,
	 * Point Q in view coordinates 		= [(Width/2 + a), -(Height/2 - b)]
	 * 
	 * 
	 * @return location of turtle on view in turtle coordinates
	 */
	private Point2D getViewTurtleLocation()
	{
//		return myView.getTurtleLocation();
		
		//DELETE
		Point2D locNew = myTurtle.getLoc();
		return locNew;
		//DELETE
	}
	
	private void setTurtleLocToViewTurtleLoc()
	{
		myTurtle.setLocation(getViewTurtleLocation());
	}
	
	
	public void moveTurtle(int distance){ 
		setTurtleLocToViewTurtleLoc();
		Point2D locOrig = myTurtle.getLoc();
		setTurtleLocToViewTurtleLoc();
		myTurtle.move(distance);
		Point2D locNew = myTurtle.getLoc();
		this.moveTurtleImageAndDraw(locOrig, locNew);
		setTurtleLocToViewTurtleLoc();
		
	}
	
	public void changeLocationOfTurtle(Point2D newLoc){ 
		setTurtleLocToViewTurtleLoc();
		Point2D locOrig = myTurtle.getLoc();
		myTurtle.setLocation(newLoc);
		Point2D locNew = myTurtle.getLoc();
		this.moveTurtleImageAndDraw(locOrig, locNew);
		setTurtleLocToViewTurtleLoc();
	}

	private void moveTurtleImageAndDraw(Point2D locOrig, Point2D locNew) {
		this.updateTurtleOnView();
		
		if (myTurtle.getPenPos() == 1)
		{
			this.myView.drawLine(locOrig, locNew, getPen());
		}
		
	}

	public void rotateTurtle(double deg){
		myTurtle.turn(deg);
		this.updateTurtleOnView();
	}
	
	public void setTurtleOrientation(double newAngle){
		myTurtle.setOrientation(newAngle);
		updateTurtleOnView();
	}
	
	public double getTurtleOrientation()
	{
		return myTurtle.getOrientation();
	}
	
	public Point2D getTurtleLocation()
	{
		return myTurtle.getLoc();
	}
	
	public void showTurtle(int toShow)
	{
		myTurtle.setVisibility(1);
		updateTurtleOnView();
	}
	
	public int isVisible()
	{
		return myTurtle.getVisibility();
	}

	public void setPenStatus(int status)
	{
		myTurtle.setPenPos(status);
	}
	
	public int getPenStatus()
	{
		return myTurtle.getPenPos();
	}
	
	public Pen getPen()
	{
		return myTurtle.getPen();
	}
	
	
	public void changeTurtleImage(Image newImage)
	{
		myTurtle.updateMyImage(newImage);
		updateTurtleOnView();
	}
	
	public void clearScreen()
	{
		this.myView.clearScreen();
	}
	
	
	public Color getPenColor()
	{
		return this.myTurtle.getPenColor();
	}

	public void setPenColor(Color newColor)
	{
		this.myTurtle.setPenColor(newColor);
	}
	
	public void updateTurtleOnView()
	{
		this.myView.changeTurtleImage(this.getTurtleLocation(), this.myTurtle.getTurtleImage());
	}
	
}
