package application;

import java.awt.Point;

import javafx.geometry.Point2D;

public class TurtleHandler {
	
	private View myView;
	private Turtle myTurtle;
	
	public TurtleHandler(View v, Turtle t){
		myView = v;
		myTurtle = t;
	}
	
	public void moveTurtle(int distance){ 
		Point2D locOrig = myTurtle.getLoc();
		myTurtle.move(distance);
		Point2D locNew = myTurtle.getLoc();
		this.moveTurtleImageAndDraw(locOrig, locNew);
	}
	
	public void changeLocationOfTurtle(Point2D newLoc){ 
		Point2D locOrig = myTurtle.getLoc();
		myTurtle.setLocation(newLoc);
		Point2D locNew = myTurtle.getLoc();
		this.moveTurtleImageAndDraw(locOrig, locNew);
	}
	


	private void moveTurtleImageAndDraw(Point2D locOrig, Point2D locNew) {
		//TODO: put turtle image at locNew location
		
		if (myTurtle.getPenPos() == 1)
		{
			//TODO: tell view to draw line
		}
		
	}


	
	
	public void rotateTurtle(int deg){
		// TODO: Implement
	}
	
	public double getTurtleOrientation()
	{
		return myTurtle.getOrientation();
	}
	
	public Point2D getTurtleLocation()
	{
		return myTurtle.getLoc();
	}
	
}
