package application;

import java.awt.Point;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

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

	public void rotateTurtle(double deg){
		myTurtle.turn(deg);
		//TODO: update turtle image to rotated
	}
	
	public void setTurtleOrientation(double newAngle){
		myTurtle.setOrientation(newAngle);
		//TODO: update turtle image to rotated
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
		myTurtle.setVisibility((toShow==1));
		//TODO: update image
	}
	
	public int isVisible()
	{
		if (myTurtle.getVisibility()) {
			return 1;
		}
		return 0;
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
		// TODO: update view
	}
	
	public void clearScreen()
	{
		// TODO: view handles clearing all the lines
	}
	
	
	public Color getPenColor()
	{
		return this.myTurtle.getPenColor();
	}
	
//<<<<<<< HEAD
//	public void rotateTurtle(int deg){
//		int currentOri = myTurtle.getOrientation();
//		myTurtle.setOrientation(currentOri + deg);
//=======
	public void setPenColor(Color newColor)
	{
		this.myTurtle.setPenColor(newColor);
//>>>>>>> 2c8d8d787400067a0fd141a5bd1ad8cd3e3b32bc
	}
	
}
