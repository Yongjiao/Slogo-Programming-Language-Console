package application;

// REFACTOR TODO
/*
 * TH moves turtle
 * NONONO: Pen handler sets pen color / status / DRAWSLINES
 * - separate pen handling
 */


import gui.BackgroundView;
import gui.LineView;
import gui.TurtleView;
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
public class ViewHandler {

	private LineView myLineView;
	private TurtleView myTurtleView;
	private BackgroundView myBackgroundView;
	private Turtle myTurtle;
	private Pen myPen;
	
	/**
	 * Constructor
	 * sets fields of View and Turtle based on parameters
	 * @param view
	 * @param turtle
	 */
	public ViewHandler(LineView lv, TurtleView tv, BackgroundView bk){
		myLineView = lv;
		myTurtleView = tv;
		myBackgroundView = bk;
		myTurtle = new Turtle();
		myPen = new Pen(1);
		this.initializeTurtle();
	}
	
	/**
	 * initializes turtle with image
	 * calls setInfoParamsOfTurtle() to set initial info 
	 */
	private void initializeTurtle()
	{
		Image image = new Image(getClass().getResourceAsStream("/resources/rsz_turtle.png"));
		this.myTurtleView.initializeTurtle(image);
		setInfoParamsOfTurtle();
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
		return myTurtleView.getNewPoint();
	
	}
	
	/**
	 * sets the turtle's location to View's turtle location
	 */
	private void setTurtleLocToViewTurtleLoc()
	{
		System.out.println("   in  setTurtleLocToViewTurtleLoc  " + this.myTurtle.getLoc().getX() + "  " +this.myTurtle.getLoc().getX());
		myTurtle.setLocation(getViewTurtleLocation());
	}
	
	/**
	 * Moves the turtle from current location by the additional distance
	 * Updates fields in Turtle accordingly
	 * @param distance
	 */
	public void moveTurtle(double distance){ // WORKS
		System.out.println("in move");

		setTurtleLocToViewTurtleLoc();
		Point2D locOrig = myTurtle.getLoc();
		System.out.println("  in move - setTurtleLocToViewTurtleLoc 1");
		setTurtleLocToViewTurtleLoc();
		myTurtle.move(distance);
		Point2D locNew = myTurtle.getLoc();
		this.moveTurtleImageAndDraw(locOrig, locNew);
		//System.out.println("  in move - setTurtleLocToViewTurtleLoc 2");
		setTurtleLocToViewTurtleLoc();

		this.updateTurtleOnView();
	}
	
	/**
	 * 
	 * Moves the turtle from current location to the new location
	 * Updates fields in Turtle accordingly
	 *
	 * @param newLoc
	 */
	public void changeLocationOfTurtle(Point2D newLoc){ //WORKS
		setTurtleLocToViewTurtleLoc();
		Point2D locOrig = myTurtle.getLoc();
		myTurtle.setLocation(newLoc);
		Point2D locNew = myTurtle.getLoc();
		this.moveTurtleImageAndDraw(locOrig, locNew);
		setTurtleLocToViewTurtleLoc();
		/*		double ang = Math.toDegrees(Math.atan2((locNew.getY()-locOrig.getY()), (locNew.getX()-locOrig.getX())));
		this.myTurtle.setOrientation(ang);*/
		this.updateTurtleOnView();
	}
	
	/**
	 * Updates turtle image on View canvas; draws line if pen is down
	 * @param locOrig
	 * @param locNew
	 */
	private void moveTurtleImageAndDraw(Point2D locOrig, Point2D locNew) {
		this.updateTurtleOnView();
		
		if (myPen.getStatus() == 1)
		{
			this.myLineView.drawLine(locOrig, locNew);
			
			// draw line design considerations / discussion - see analysis document
		}

	}

	/**
	 * sets turtle orientation to current orientation + angle turned
	 * Calls method to update view's turtle image
	 * @param deg
	 */
	public void rotateTurtle(double deg){
		System.out.println("in rotate");

		myTurtle.turn(deg);
		this.updateTurtleOnView();
	}
	
	/**
	 * sets turtle orientation to new orientation
	 * Calls method to update view's turtle image
	 * @param newAngle
	 */
	public void setTurtleOrientation(double newAngle){
		System.out.println("in set turtle orientation");
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
		myTurtle.setVisibility(toShow);
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
	 * clears screen
	 * called if user enters command CLEARSCREEN
	 */
	public void clearScreen() // WORKS
	{
		this.myLineView.clearScreen();
	}
	
	
	/**
	 * called whenever turtle's image, location, or orientation is changed in 
	 * order to update the appropriate fields in View
	 */
	public void updateTurtleOnView()
	{
		// update turtle info to View
		setInfoParamsOfTurtle();
		
		if (this.isVisible() == 1)
		{
			// make turtle visible, then update turtle movement
			this.myTurtleView.showTurtle(true);
			this.myTurtleView.rotateAndMoveTurtle(this.getTurtleLocation(), this.getTurtleOrientation());
		}
		else
		{
			// tell view to make turtle invisible
			this.myTurtleView.showTurtle(false);
		}
	}
	
	
	public void setBackground(double index)
	{
	//	this.myBackgroundView.setBackgroundColor(index);
	}
	 

	
	/**
	 * Contains information of turtle regarding
	 * - x location
	 * - y location
	 * - orientation
	 * - pen status
	 * 
	 * Used to display status of turtle to user from GUI
	 */
	public void setInfoParamsOfTurtle()
	{
		this.myTurtleView.setTurtleInfo("Position: \t\t[" + Math.floor(getTurtleLocation().getX()) + ", " + Math.floor(getTurtleLocation().getY()) + "]"
				+ " \n" + "Heading: \t\t" + this.getTurtleOrientation()
				+ " \n" + "Pen Status: \t" + myPen.getStatus()
				);
	}	
}
