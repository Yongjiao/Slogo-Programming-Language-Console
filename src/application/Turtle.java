package application;

import javafx.geometry.Point2D;



public class Turtle {
	private double myOrientation;
	private boolean isVisible;
	private Point2D myLoc;
	
	/**
	 * constructor to intialize turtle
	 */
	public Turtle(){
		myLoc = new Point2D(0, 0); // set Turtle's initial location in the center of the screen
		myOrientation = 0; //  set orientation to be straight up
		isVisible = true;
	}
	
	public double getOrientation(){
		return myOrientation;
	}
	
	public void setOrientation(double ori){
		myOrientation = ori;
	}
	
	public void turn(double degrees){
		myOrientation = myOrientation + degrees;
	}
	
	public void setVisible(boolean state){
		isVisible = state;
	}
	
	public boolean getVisible(){
		return isVisible;
	}

	public Point2D getLoc() {
		return myLoc;
	}
	
	public void setLocation(int x, int y)
	{
		//TODO
				
	}
	
	public void move(double distance)
	{
		myLoc = myLoc.add(distance*Math.cos(Math.toRadians(myOrientation)), distance*Math.sin(Math.toRadians(myOrientation)));
	}
	
	
	
}
