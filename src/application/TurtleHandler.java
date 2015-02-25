package application;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
 * As a result, movement methods are formatted as follows:
 * 
 * public void moveTurtle(int dist)
 * {
 * 		myTurtle.setLocation(getViewTurtleLocation());		// set View's turtle location to turtle loc
 * 		Point2D origLoc = myTurtle.getLoc();				// get turtle location
 * 		myTurtle.move(dist);								// move
 * 		Point2D newLoc = myTurtle.getLoc();					// get new turtle location
 * 		this.moveTurtleImageAndDraw(origLoc, newLoc); 		// pass View new location
 * 		// view calculates new loc. in terms of turtle coordinates
 * 		myTurtle.setLocation(getViewTurtleLocation());		// set View's updated turtle location to turtle loc
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
	
	/**
	 * Constructor
	 * sets fields of View and Turtle based on parameters
	 * @param view
	 * @param turtle
	 */
	public TurtleHandler(View view){
		myView = view;
		myTurtle = new Turtle();
		this.initializeTurtle();
	}
	
	private void initializeTurtle()
	{
		Image newIm = new Image("resources/turtle.png");
		this.changeTurtleImage((newIm));
		this.myView.initializeTurtle(newIm);
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
	
	/**
	 * sets the turtle's location to View's turtle location
	 */
	private void setTurtleLocToViewTurtleLoc()
	{
		myTurtle.setLocation(getViewTurtleLocation());
	}
	
	/**
	 * Moves the turtle from current location by the additional distance
	 * Updates fields in Turtle accordingly
	 * @param distance
	 */
	public void moveTurtle(int distance){ 
		setTurtleLocToViewTurtleLoc();
//>>>>>>> a19726d3bb45e55eee19444acb4fc407bd1255fb
		Point2D locOrig = myTurtle.getLoc();
		setTurtleLocToViewTurtleLoc();
		myTurtle.move(distance);
		Point2D locNew = myTurtle.getLoc();
		this.moveTurtleImageAndDraw(locOrig, locNew);
		setTurtleLocToViewTurtleLoc();
		
	}
	
	/**
	 * 
	 * Moves the turtle from current location to the new location
	 * Updates fields in Turtle accordingly
	 *
	 * @param newLoc
	 */
	public void changeLocationOfTurtle(Point2D newLoc){ 
		setTurtleLocToViewTurtleLoc();
//>>>>>>> a19726d3bb45e55eee19444acb4fc407bd1255fb
		Point2D locOrig = myTurtle.getLoc();
		myTurtle.setLocation(newLoc);
		Point2D locNew = myTurtle.getLoc();
		this.moveTurtleImageAndDraw(locOrig, locNew);
		setTurtleLocToViewTurtleLoc();
	}
	
	/**
	 * Updates turtle image on View canvas; draws line if pen is down
	 * @param locOrig
	 * @param locNew
	 */
	private void moveTurtleImageAndDraw(Point2D locOrig, Point2D locNew) {
		this.updateTurtleOnView();
		
		if (myTurtle.getPenPos() == 1)
		{
			// pass pen to check color
			this.myView.drawLine(locOrig, locNew);
			
			// draw line design considerations / discussion - see analysis document
		}

	}

	/**
	 * sets turtle orientation to current orientation + angle turned
	 * Calls method to update view's turtle image
	 * @param deg
	 */
	public void rotateTurtle(double deg){
		myTurtle.turn(deg);
		this.updateTurtleOnView();
	}
	
	/**
	 * sets turtle orientation to new orientation
	 * Calls method to update view's turtle image
	 * @param newAngle
	 */
	public void setTurtleOrientation(double newAngle){
		myTurtle.setOrientation(newAngle);
		updateTurtleOnView();
	}
	
	/**
	 * @return current orientation of turtle
	 */
	public double getTurtleOrientation()
	{
		return myTurtle.getOrientation();
	}
	
	/**
	 * @return current location of turtle
	 */
	public Point2D getTurtleLocation()
	{
		return myTurtle.getLoc();
	}
	
	/**
	 * sets visibility of turtle based on input parameter
	 * If toShow == 1, visibility ON
	 * If toShow == 0, visibility OFF
	 * @param toShow
	 */
	public void showTurtle(int toShow)
	{
		myTurtle.setVisibility(1);
		updateTurtleOnView();
	}
	
	/**
	 * @return whether or not the turtle is visible
	 * returns 1 if visible, returns 0 if hidden
	 */
	public int isVisible()
	{
		return myTurtle.getVisibility();
	}

	/**
	 * sets status of pen based on input parameter
	 * if status == 1, PENDOWN
	 * if status == 0, PENUP
	 * @param status
	 */
	public void setPenStatus(int status)
	{
		myTurtle.setPenPos(status);
	}
	
	/**
	 * @return 1 if PENDOWN, 0 if PENUP
	 */
	public int getPenStatus()
	{
		return myTurtle.getPenPos();
	}
	

	
	/**
	 * updates turtle's image file and calls to update image of turtle displayed on View
	 * @param newIm
	 */
	public void changeTurtleImage(Image newIm)
	{
		myTurtle.updateMyImage(newIm);
		updateTurtleOnView();
	}
	
	/**
	 * clears screen
	 * called if user enters command CLEARSCREEN
	 */
	public void clearScreen()
	{
		this.myView.clearScreen();
	}
	
	
	/**
	 * called whenever turtle's image, location, or orientation is changed in 
	 * order to update the appropriate fields in View
	 */
	public void updateTurtleOnView()
	{
		if (this.isVisible() == 1)
		{
			// make turtle visible, then update turtle movement
			this.myView.showTurtle(true);
			this.myView.rotateAndMoveTurtle(this.getTurtleLocation(), this.myTurtle.getTurtleImage(), this.getTurtleOrientation());
		}
		else
		{
			// tell view to make turtle invisible
			this.myView.showTurtle(false);
		}
	}

}
