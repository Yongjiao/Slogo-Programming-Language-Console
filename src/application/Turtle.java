package application;


import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;




public class Turtle {
	private double myOrientation;
	private boolean isVisible;
	private Point2D myLoc;
	ImageView myImage;
	Pen myPen;
	
	/**
	 * constructor to intialize turtle
	 */
	public Turtle(){
		myLoc = new Point2D(0, 0); // set Turtle's initial location in the center of the screen
		myOrientation = 0; //  set orientation to be straight up
		isVisible = true;
		myPen = new Pen(1);
	}
	
	public double getOrientation(){
		return myOrientation;
	}
	
	public void setOrientation(double ori){
		myOrientation = ori;
	}
	
	public Color getPenColor()
	{
		return this.myPen.getColor();
	}
	
	public void setPenColor(Color newColor)
	{
		this.myPen.setColor(newColor);
	}
	
	
	public void turn(double degrees){
		myOrientation = myOrientation + degrees;
	}
	
	public void setVisibility(boolean state){
		isVisible = state;
	}
	
	public boolean getVisibility(){
		return isVisible;
	}

	public Point2D getLoc() {
		return myLoc;
	}
	
	public void setLocation(Point2D newLoc)
	{
		myLoc = newLoc;
				
	}
	
	public void move(double distance)
	{
		myLoc = myLoc.add(distance*Math.cos(Math.toRadians(myOrientation)), distance*Math.sin(Math.toRadians(myOrientation)));
	}
	
	public void updateMyImage(Image newImage)
	{
		this.myImage.setImage(newImage);;
	}
	
	public void setPenPos(int pos)
	{
		this.myPen.setStatus(pos);
	}
	
	public int getPenPos()
	{
		return myPen.getStatus();
	}
	
	public ImageView getTurtleImage()
	{
		return myImage;
	}
	
	public Pen getPen()
	{
		return this.myPen;
	}

	public void toggleShowHide(int toShow)
	{
		this.myImage.setVisible((toShow == 1));
	}
	

}
