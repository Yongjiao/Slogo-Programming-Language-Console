package application;

// This entire file is part of my masterpiece.
// ANIKA RADIYA-DIXIT

import gui.BackgroundView;
import gui.LineView;
import gui.TurtleView;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

/**
 * This class contains methods and parameters to update the LineView, TurtleView,
 * or BackgroundView.
 * <p> If a command is called to move or rotate the turtle, this class
 * updates the location / orientation of the Turtle. If the Turtle set to 
 * IS_TURTLE_VISIBLE, this class calls the appropriate method of TurtleView to 
 * update the location of the turtle's image on the screen.
 * <p> If the pen's status is set to PEN_DOWN, this class calls the line 
 * drawing method in LineView.
 * <p>
 * <p> If a command is called to change the background color, this class calls
 * the color changing method in BackgroundView.
 * 
 * @author Anika
 * @version analysis refactoring
 */
public class ViewHandler2 {

	private LineView myLineView; // Canvas used for drawing lines
	private TurtleView myTurtleView; // Canvas used for placing turtle image
	private BackgroundView myBackgroundView; // Canvas used for background color
	private Turtle myTurtle;
	private PenHandler myPenHandler;
	private static String DEFAULT_TURLTLE_IMAGE = "/resources/rsz_turtle.png";
	private static int PEN_DOWN = 1; // constant to signify pen status as down
	private static int VISIBLE = 1; // constant to compare visible status to integer
	private boolean IS_TURTLE_VISIBLE = true; // boolean to indicate visibility of turtle image
	
	/**
	 * Constructor
	 * sets fields of each View and Turtle based on parameters
	 * @param lineView
	 * @param turtleView
	 * @param backgroundView
	 * @param penHandler
	 */
	public ViewHandler2(LineView lineView, TurtleView turtView, BackgroundView bkView, PenHandler penHandler) {
		myLineView = lineView;
		myTurtleView = turtView;
		myPenHandler = penHandler;
		myBackgroundView = bkView;
		initializeTurtle();
	}
	
	/**
	 * initializes turtle with image
	 * <p> calls setInfoParamsOfTurtle() to set initial info 
	 */
	private void initializeTurtle() {
		myTurtle = new Turtle();
		Image image = new Image(getClass().getResourceAsStream(DEFAULT_TURLTLE_IMAGE));
		myTurtleView.initializeTurtle(image); // tells View to initialize turtle image
		setInfoParamsOfTurtleAndLine(); // initializes information to be displayed
			// from [ Turtle Info ] button on GUI
	}
	
	
	/**
	 * sets the turtle's location to View's turtle location
	 * due to differences in coordinate systems
	 * <p> View coordinate system origin at top left of Canvas
	 * <p> Turtle coordinate system origin at [Width/2, Height/2]
	 */
	private void setTurtleLocToViewTurtleLoc() {
		myTurtle.setLocation(myTurtleView.getNewPoint());
	}
	
	/**
	 * helper method for moveTurtle and changeLocationOfTurtle
	 * @return Turtle's current location in View coordinates
	 */
	private Point2D calculateOriginalLocation() {
		setTurtleLocToViewTurtleLoc();
		return myTurtle.getLoc();
	}
	
	/**
	 * helper method to call View's update methods to move turtle image
	 * @param originalLocation
	 * @param newLocation
	 */
	private void setTurtleLocAndMove(Point2D originalLocation, Point2D newLocation) {
		myTurtle.setLocation(newLocation);
		moveTurtleImageAndDraw(originalLocation, newLocation);
		setTurtleLocToViewTurtleLoc();
		updateTurtleOnView();
	}
	
	/**
	 * @called by movement commands
	 * Moves the turtle from current location by the additional distance
	 * <p> Updates fields in Turtle accordingly
	 * @param distance
	 */
	public void moveTurtle(double distance) { 
		Point2D locOrig = calculateOriginalLocation();
		Point2D locNew = locOrig.add(distance*Math.sin(Math.toRadians(getTurtleOrientation())), distance*Math.cos(Math.toRadians(getTurtleOrientation())));
		setTurtleLocAndMove(locOrig, locNew);
	}
	
	/**
	 * @called by movement command
	 * Moves the turtle from current location to the new location
	 * <p> Updates fields in Turtle accordingly
	 * @param newLoc
	 */
	public void changeLocationOfTurtle(Point2D newLoc) {
		Point2D locOrig = calculateOriginalLocation();
		setTurtleLocAndMove(locOrig, newLoc);
	}
	
	/**
	 * Updates turtle image on View canvas; draws line if pen is down
	 * <p> Note: This feature is the primary reason that ViewHandler needs
	 * access to current Pen info
	 * @param locOrig
	 * @param locNew
	 */
	private void moveTurtleImageAndDraw(Point2D locOrig, Point2D locNew) {
		updateTurtleOnView();	
		if (myPenHandler.getPenStatus() == PEN_DOWN) {
			myLineView.drawLine(locOrig, locNew);			
		}
	}

	/**
	 * @called by rotation command
	 * sets turtle orientation to current orientation + angle turned
	 * <p> Calls method to update view's turtle image
	 * @param deg
	 */
	public void rotateTurtle(double deg) {
		myTurtle.turn(deg);
		updateTurtleOnView();
	}
	
	/**
	 * @called by rotation command
	 * sets turtle orientation to new orientation
	 * <p> Calls method to update view's turtle image
	 * @param newAngle
	 */
	public void setTurtleOrientation(double newAngle) {
		myTurtle.setOrientation(newAngle);
		updateTurtleOnView();
	}
	
	/**
	 * @return current orientation of turtle
	 */
	private double getTurtleOrientation() {
		return myTurtle.getOrientation();
	}
	
	/**
	 * @return current location of turtle
	 */
	private Point2D getTurtleLocation() {
		return myTurtle.getLoc();
	}
	
	/**
	 * @called by showTurtle command
	 * sets visibility of turtle based on input parameter
	 * <p> If toShow == 1, visibility ON
	 * <p> If toShow == 0, visibility OFF
	 * @param toShow
	 */
	public void showTurtle(int toShow) {
		myTurtle.setVisibility(toShow);
		updateTurtleOnView();
	}

	
	/**
	 * @called by CLEARSCREEN command
	 * clears all lines on the LineView
	 */
	public void clearScreen() {
		myLineView.clearScreen();
	}
	
	
	/**
	 * called whenever turtle's image, location, or orientation is changed in 
	 * order to update the appropriate fields in View
	 */
	private void updateTurtleOnView() {
		// update turtle info to View
		setInfoParamsOfTurtleAndLine();
		IS_TURTLE_VISIBLE = (myTurtle.getVisibility() == VISIBLE);
		if (IS_TURTLE_VISIBLE) {
			// update turtle movement if turtle is visible 
			// else don't do the calculations
			myTurtleView.rotateAndMoveTurtle(getTurtleLocation(), getTurtleOrientation());
		}
		myTurtleView.showTurtle(IS_TURTLE_VISIBLE);
	}
	
	/**
	 * Contains information of turtle regarding
	 * <p> - x location
	 * <p> - y location
	 * <p> - orientation
	 * <p> - pen status
	 * <p> Contains information for Pen for line drawing of thickness
	 * of stroke/line
	 * <p> Used to display status of turtle to user from GUI
	 */
	private void setInfoParamsOfTurtleAndLine() {
		myTurtleView.setTurtleInfo("Position: \t\t[" + Math.floor(getTurtleLocation().getX()) + ", " + Math.floor(getTurtleLocation().getY()) + "]"
				+ " \n" + "Heading: \t\t" + getTurtleOrientation()
				+ " \n" + "Pen Status: \t" + myPenHandler.getPenStatus()
				);	
		myPenHandler.setThicknessParameter();
	}	
}