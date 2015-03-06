package application;

import javafx.scene.paint.Color;

/**
 * 
 * @author Anika
 *
 */
public class Pen {
	//  Properties: up/down, thickness, solid, dashed, dotted, etc.
	private int myStatus;
	private Color myColor;
	private double myThickness;
	private PENSTYLE myStyle;
	
	private enum PENSTYLE {
		SOLID, DASHED, DOTTED;
	}
	
	/**
	 * Constructor of pen class
	 * - initializes status based on integer passed by user
	 * - initializes color to black
	 * - initializes original thickness to 1
	 * - initializes line-drawing style to solid line
	 * @param status
	 */
	public Pen(int status)
	{
		myStatus = status;
		myColor = Color.BLACK;
		myThickness = 1;
		myStyle = PENSTYLE.SOLID;
	}
	
	/**
	 * Sets pen status to input status
	 * Called when user declares penup or pendown
	 * @param newStatus of pen
	 */
	public void setStatus(int newStatus)
	{
		myStatus = newStatus;
	}
	
	/**
	 * @return current status of pen: 1 if DOWN; 0 if UP
	 */
	public int getStatus()
	{
		return myStatus;
	}
	
	/**
	 * Used for displaying pen status to user in a readable form
	 * Single if statement used since condition for mapping
	 * 1 to DOWN and 0 to UP is only referred to once in the code
	 * @return current status of pen in the form of a string
	 */
	public String getStatusString()
	{
		if (myStatus==0) {return "UP";}
		else {return "DOWN";}
	}
	
	/**
	 * Sets color of pen to inputted pen color
	 * @param newColor
	 */
	public void setColor (Color newColor)
	{
		myColor = newColor;
	}
	
	/**
	 * @return color of pen
	 */
	public Color getColor()
	{
		return myColor;
	}
	
	/**
	 * Sets thickness of pen based on inputted value
	 * Higher values correspond to thicker lines
	 * @param newWeight
	 */
	public void setWeight(double newWeight)
	{
		myThickness = newWeight;
	}
	
	/**
	 * @return thickness of pen
	 */
	public double getWeight()
	{
		return myThickness;
	}
	
	/**
	 * Sets style of pen's line drawing based on input parameter
	 * Choices:
	 * - solid
	 * - dotted
	 * - dashed
	 * @param newStyle
	 */
	public void setStyle(PENSTYLE newStyle)
	{
		myStyle = newStyle;
	}
	
	/**
	 * @return current style of pen
	 */
	public PENSTYLE getStyle()
	{
		return myStyle;
	}
}
