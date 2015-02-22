package application;

import javafx.scene.paint.Color;

/**
 * 
 * @author anika
 *
 */
public class Pen {
	private int myStatus;
	private Color myColor;
	
	public Pen(int status)
	{
		myStatus = status;
	}
	
	public void setStatus(int newStatus)
	{
		myStatus = newStatus;
	}
	
	public int getStatus()
	{
		return myStatus;
	}
	
	public void setColor(Color newColor)
	{
		myColor = newColor;
	}
	
	public Color getColor()
	{
		return myColor;
	}

}
