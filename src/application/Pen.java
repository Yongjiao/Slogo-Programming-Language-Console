package application;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;

/**
 * 
 * @author Anika
 *
 */
public class Pen {
	//  Properties: up/down, thickness, solid, dashed, dotted, etc.
	private int myStatus, myPaletteColorLocation;
	private Color myColor;
	private double myThickness;
	private PENSTYLE myStyle;
	private Map<Integer, Color> myPaletteOptions;
	
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
		myPaletteOptions = new HashMap<Integer, Color>();
		myPaletteColorLocation = 0;
	}
	

	/**
	 * sets status of pen based on input parameter
	 * if status == 1, PENDOWN
	 * if status == 0, PENUP
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
	
	public void setColor (int indexOfColor)
	{
		myColor = this.getColorFromPalette(indexOfColor);
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
	

	
	public void setPaletteColor(int paletteIndex, int redIndex, int greenIndex, int blueIndex)
	{
		Color newColor = new Color(redIndex, greenIndex, blueIndex, 0);
		this.addToPalette(paletteIndex, newColor);
	}
	
	public void addToPalette(int index, Color colorToAdd)
	{
		this.myPaletteOptions.put(index, colorToAdd);
	}
	
	
	public Color getColorFromPalette(int index)
	{
		myColor = this.myPaletteOptions.get(index);
		this.myPaletteColorLocation = index;
		return myColor;
	}
	/**
	 * called when PENCOLOR command is executed (Sprint 3)
	 * @return int
	 */
	public int getCurrentColorIndexFromPalette()
	{
		return this.myPaletteColorLocation;
	}
}
