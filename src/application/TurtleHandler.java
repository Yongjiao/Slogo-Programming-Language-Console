package application;

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
		myTurtle.setVisibility((toShow==1));
		updateTurtleOnView();
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
