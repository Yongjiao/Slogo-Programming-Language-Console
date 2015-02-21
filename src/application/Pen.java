package application;

import javafx.scene.paint.Color;

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

}
