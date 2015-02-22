package application;


import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class View{
	
	private Canvas myTurtleCanvas, myLineCanvas, myBackgroundCanvas;
	private GraphicsContext turtleGraphCont;
	private GraphicsContext linesGraphCont;
	private GraphicsContext myLineCanvasGraphCont, myBackgroundCanvasGraphCont;
	private static double XCENTER, YCENTER;
	
	public View(int x, int y){
		
		myTurtleCanvas = new Canvas();
		myLineCanvas = new Canvas();
		myBackgroundCanvas = new Canvas();
		
		
		myTurtleCanvas.setWidth(x);
		myBackgroundCanvas.setWidth(x);
		myTurtleCanvas.setHeight(y);
		myBackgroundCanvas.setHeight(y);
		myLineCanvas.setWidth(x);
		myLineCanvas.setHeight(y);
		
		linesGraphCont = myLineCanvas.getGraphicsContext2D();
		myBackgroundCanvasGraphCont = myBackgroundCanvas.getGraphicsContext2D();
		
		//TODO: set z indices of canvas order
		
		XCENTER = myTurtleCanvas.getWidth()/2;
		YCENTER = myTurtleCanvas.getHeight()/2;
			
	}
	
	
	public void setBackgroundImage(Image back)
	{
		//TODO: change image of BackgroundCanvas
	}
	
	public void setBackgroundColor(Color newC)
	{
		myBackgroundCanvasGraphCont.setFill(newC);
	}
	
	public void drawLine(Point2D originalLocation, Point2D newLocation, Pen pen){
		// TODO: draw a line from point originalLocation to newLocation
		// draw line if pen status  = 1 get color from turtleHandler with TH.getPenColor()
		// TODO: check for boundary conditions
	}
	
	/**
	 * possible helper method
	 */
	public void checkBoundaryConditions()
	{
		// TODO
	}
	
	/**
	 * changes location and/or orientation of turtle image
	 * @param newLoc
	 * @param turtleImage
	 * @author Anika (version 1)
	 */
	public void changeTurtleImage(Point2D newLoc, ImageView turtleImage){
		// TODO: handle location and orientation and visibility of turtle

		// clear turtle canvas, then relocate image
		this.turtleGraphCont.clearRect(0, 0, this.myTurtleCanvas.getWidth(), this.myTurtleCanvas.getHeight());

		if (turtleImage.isVisible())
		{
			// if turtle is not hidden, put turtle on new location on screen

			double xViewLoc = newLoc.getX() + this.XCENTER;
			double yViewLoc = newLoc.getY() + this.YCENTER;

			Point2D viewLocation = new Point2D(xViewLoc, yViewLoc);

			//TODO: rotation

			//	this.turtleGraphCont.drawImage((turtleImage), xViewLoc, yViewLoc);
		}
	}

	public void clearScreen(){
		this.linesGraphCont.clearRect(0, 0, this.myBackgroundCanvas.getWidth(), this.myBackgroundCanvas.getHeight());
	}
}
