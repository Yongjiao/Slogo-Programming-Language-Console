package gui;

import java.io.File;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

/**
 * Creates the layer that displays the turtle
 * @author Andrew
 *
 */
public class TurtleView extends View{

	private ImageView myTurtle;
	private double currentRotation;
	private double XOFFSET, YOFFSET;
	private GraphicsContext turtleGC;
	private Point2D newDest;
	private String myTurtleInfo;
	
	public TurtleView(int x, int y) {
		super(x, y);
		currentRotation = 0;
		turtleGC = this.getGraphicsContext2D();
		myTurtle = new ImageView();
		newDest = this.getNewPoint();
		XOFFSET = this.getXOffset();
		YOFFSET = this.getYOffset();
	}
	
	public void initializeTurtle(Image turtle){
		myTurtle.setImage(turtle);
		turtleGC.drawImage(turtle, XOFFSET- myTurtle.getImage().getWidth() / 2, 
				YOFFSET- myTurtle.getImage().getHeight() / 2);
	}
	
	/**
	 * changes location and/or orientation of turtle image
	 * @param newLoc
	 * @param turtleImage
	 * 
	 */
	public void rotateAndMoveTurtle(Point2D newLoc, double angle){
		turtleGC.clearRect(0, 0, this.getWidth(), this.getHeight());
		turtleGC.save();
		rotate(angle, newLoc.getX() + XOFFSET, 
				(newLoc.getY() - YOFFSET)*-1);
        turtleGC.clearRect(0, 0, this.getWidth(), this.getHeight());
		turtleGC.drawImage(myTurtle.getImage(), newLoc.getX() + XOFFSET- myTurtle.getImage().getWidth() / 2, 
				(newLoc.getY()-YOFFSET + myTurtle.getImage().getHeight() / 2)*-1);
		newDest = newLoc;
		this.setNewPoint(newDest);
    	turtleGC.restore();
	}
	
	/**
	 * Sets turtle visibility
	 * @param b
	 */
	public void showTurtle(boolean b){
		this.setVisible(b);
	}
	
	/**
	 * Updates the turtle image either by file or location
	 * @param loc
	 */
	public void updateTurtleImage(File loc){
        Image image = new Image("file:///" + loc.getPath());
		updateTurtleImage(image);
	}
	
	public void updateTurtleImage(Image image){
		turtleGC.save();
        myTurtle.setImage(image);
		rotate(currentRotation, newDest.getX() + XOFFSET, (newDest.getY() - YOFFSET)*-1);
        turtleGC.clearRect(0, 0, this.getWidth(), this.getHeight());
    	turtleGC.drawImage(myTurtle.getImage(), newDest.getX() + XOFFSET- myTurtle.getImage().getWidth() / 2, 
    			(newDest.getY()-YOFFSET+ myTurtle.getImage().getHeight() / 2)*-1);
    	turtleGC.restore();
	}
	
	/**
	 * Rotates the turtle
	 * @param angle
	 * @param x
	 * @param y
	 */
	private void rotate(double angle, double x, double y) {
		currentRotation = angle;
		Rotate r = new Rotate(angle, x, y);
		turtleGC.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(),
				r.getTx(), r.getTy());
	}

	
	/**
	 * @author Anika
	 * @param info
	 */
	public void setTurtleInfo(String info)
	{
		this.myTurtleInfo = info;
	}
	
	/**
	 * @author Anika
	 * @return
	 */
	public String getTurtleInfo()
	{
		return myTurtleInfo;
	}
}
