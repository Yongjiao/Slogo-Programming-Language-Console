package application;

import java.awt.Point;

public class TurtleHandler {
	
	private View myView;
	private Turtle myTurtle;
	
	public TurtleHandler(View v, Turtle t){
		myView = v;
		myTurtle = t;
	}
	
	public void moveTurtle(int x, int y){ // Point p1, Point p2?
		int xorig = myTurtle.getX();
		int yorig = myTurtle.getY();
		
		Point p1 = new Point(xorig, yorig);
		Point p2 = new Point(xorig + x, yorig + y);
		
		myView.drawLine(p1, p2);
		myTurtle.setX(p1.x);
		myTurtle.setY(p2.y);
	}
	
	public void rotateTurtle(int deg){
		// TODO: Implement
	}
	
}
