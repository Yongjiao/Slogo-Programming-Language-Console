package application;

import javafx.scene.paint.Color;

/**
 * 
 * @author anika
 *
 */
public class Pen {
	//  Properties: up/down, thickness, solid, dashed, dotted, etc.
	private int myStatus;
	private Color myColor;
	private int myThickness;
	private PENSTYLE myStyle;
	
	private enum PENSTYLE {
		SOLID, DASHED, DOTTED;
	}
	
	// constructor
	public Pen(int status)
	{
		myStatus = status;
		myColor = Color.BLACK;
		myThickness = 1;
		myStyle = PENSTYLE.SOLID;
	}
	
	public void setStatus(int newStatus)
	{
		myStatus = newStatus;
	}
	
	public int getStatus()
	{
		return myStatus;
	}
	
	public void setColor (Color newColor)
	{
		myColor = newColor;
	}
	
	public Color getColor()
	{
		return myColor;
	}
	
	public void setWeight(int newWeight)
	{
		myThickness = newWeight;
	}
	
	public int getWeight()
	{
		return myThickness;
	}
	
	public void setStyle(PENSTYLE newStyle)
	{
		myStyle = newStyle;
	}
	
	public PENSTYLE getStyle()
	{
		return myStyle;
	}
	
	
	
	
}
