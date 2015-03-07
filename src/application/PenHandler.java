package application;

import gui.LineView;
import javafx.scene.paint.Color;

public class PenHandler {
	private Pen myPen;
	private LineView myLineView;
	
	public PenHandler(LineView view)
	{
		myPen = new Pen();
		myLineView = view;
	}
	
	
	/**
	 * sets status of pen based on input parameter
	 * if status == 1, PENDOWN
	 * if status == 0, PENUP
	 * @param status
	 */
	
	public int getPenStatus()
	{
		return  myPen.getStatus();
	}
	
	
	public void setPenStatus(int statusNew)
	{
		myPen.setStatus(statusNew);
	}
	
	/**
	 * sets color of pen based on input parameter
	 * @param newColor
	 */
	public void setPenColor(Color newColor)
	{
		myPen.setColor(newColor);
	}
	
	public void setPenColor(int index)
	{
		Color newColor = myPen.getColorFromPalette(index);
		this.setPenColor(newColor);
	}
	
	public void setPaletteColor(int paletteIndex, int redIndex, int greenIndex, int blueIndex)
	{
		myPen.setPaletteColor(paletteIndex, redIndex, greenIndex, blueIndex);
	}
	
		
	/**
	 * 
	 * @return Color of pen
	 */
	public Color getPenColor()
	{
		return myPen.getColor();
	}
	
	/**
	 * called when PENCOLOR command is executed (Sprint 3)
	 * @return
	 */
	public int getPenColorIndex()
	{
		return myPen.getCurrentColorIndexFromPalette();
	}
	
	public void setPenWeight(double pixels)
	{
		myPen.setWeight(pixels);
	}
	
	public double getPenWeight()
	{
		return myPen.getWeight();
	}

	public void setThicknessParameter()
	{
		this.myLineView.setThickness(getPenWeight());
	}	
}
