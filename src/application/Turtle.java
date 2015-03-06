package application;


import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;



/**
 * Back-end turtle
 * Keeps track of turtle's data
 * Changes to data made through TurtleHandler
 * @author Anika
 *
 */
public class Turtle {
	private double myOrientation;
	private int isVisible;
	private Point2D myLoc;
	ImageView myImage;
	
	
	/**
	 * constructor to initialize turtle
	 */
	public Turtle(){
		myLoc = new Point2D(0, 0); // set Turtle's initial location in the center of the screen
		myOrientation = 0; //  set orientation to be straight up
		isVisible = 1;
		
	}
	
	/**
	 * @return current orientation of turtle
	 */
	public double getOrientation(){
		return myOrientation;
	}
	
	/**
	 * sets orientation of turtle
	 * @param ori
	 */
	public void setOrientation(double ori){
		myOrientation = ori;
	}
	
	
	/**
	 * updates orientation
	 * adds number of degrees to current orientation
	 * @param degrees
	 */
	public void turn(double degrees){
		myOrientation = myOrientation + degrees;
	}
	
	/**
	 * sets visiblity based on input parameter
	 * if state == 1, visibility ON
	 * if state == 0, visibility OFF
	 * @param state
	 */
	public void setVisibility(int state){
		isVisible = state;
	}
	
	/**
	 * @return if the turtle is showing or hidden
	 */
	public int getVisibility(){
		return isVisible;
	}

	/**
	 * @return current location of the turtle
	 */
	public Point2D getLoc() {
		return myLoc;
	}
	
	/**
	 * sets location of the turtle to input Point2D parameter
	 * @param newLoc
	 */
	public void setLocation(Point2D newLoc)
	{
		myLoc = newLoc;
				
	}
	
	/**
	 * updates the turtle's location by calculating horizontal and vertical
	 * components of distance based on turtle's orientation
	 * @param distance
	 */
	public void move(double distance)
	{
		myLoc = myLoc.add(distance*Math.sin(Math.toRadians(myOrientation)), distance*Math.cos(Math.toRadians(myOrientation)));
	}
	
	/**
	 * sets turtle image to input file
	 * @param newImage
	 */
	public void updateMyImage(Image newImage)
	{
		this.myImage.setImage(newImage);
	}
	
	
	
	/**
	 * @return turtle's visible image
	 */
	public ImageView getTurtleImage()
	{
		return myImage;
	}
	
	
	/**
	 * changes visibility of turtle's image based on input parameter
	 * toShow == 1 -> VISIBLE
	 * toShow == 0 -> HIDDEN 
	 * @param toShow
	 */
	public void toggleShowHide(int toShow)
	{
		this.myImage.setVisible((toShow == 1));
	}
	
		
}
