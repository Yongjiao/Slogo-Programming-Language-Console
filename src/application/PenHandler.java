package application;

import gui.LineView;
import javafx.scene.paint.Color;

/**
 * Class to handle pen data and update view
 * @author anika
 *
 */
public class PenHandler {
	private Pen myPen;
	private LineView myLineView;
	
	/**
	 * Constructor to initialize Pen and LineView
	 * @param view = LineView
	 */
	public PenHandler(LineView view)
	{
		myPen = new Pen();
		myLineView = view;
	}
	
	
	/**
	 * @return current status of the Pen
	 */
	public int getPenStatus()
	{
		return  myPen.getStatus();
	}
	
	/**
	 * sets status of pen based on input parameter
	 * if status == 1, PENDOWN
	 * if status == 0, PENUP
	 * @param statusNew
	 */
	public void setPenStatus(int statusNew)
	{
		myPen.setStatus(statusNew);
	}
	
	/**
	 * sets color of pen based on input color
	 * @param newColor
	 */
	public void setPenColor(Color newColor)
	{
		myPen.setColor(newColor);
	}
	
	/**
	 * sets color of pen based on input integer
	 * accesses Palette map to get returned color
	 * @param index
	 */
	public void setPenColor(int index)
	{
		Color newColor = myPen.getColorFromPalette(index);
		this.setPenColor(newColor);
	}
	
	/**
	 * puts in Pen's Palette map Key: Index; Value: Color(r,g,b)
	 * @param paletteIndex
	 * @param redIndex
	 * @param greenIndex
	 * @param blueIndex
	 */
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
	
	/**
	 * sets thickness of pen to input pixels
	 * @param pixels
	 */
	public void setPenWeight(double pixels)
	{
		myPen.setWeight(pixels);
	}
	
	/**
	 * @return thickness of pen
	 */
	public double getPenWeight()
	{
		return myPen.getWeight();
	}

	/**
	 * sets thickness parameter in LineView so that line drawing
	 * knows parameters of pen to draw appropriately
	 */
	public void setThicknessParameter()
	{
		this.myLineView.setThickness(getPenWeight());
	}	
}
