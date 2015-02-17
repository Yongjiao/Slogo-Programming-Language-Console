package application;

public class Turtle {
	private int myX, myY, myOrientation;
	private boolean isVisible;
	
	public Turtle(int x, int y, int ori, boolean visibility){
		myX = x;
		myY = y;
		myOrientation = ori;
		isVisible = visibility;
	}
	
	public int getX(){
		return myX;
	}
	
	public void setX(int x){
		myX = x;
	}
	
	public int getY(){
		return myY;
	}
	
	public void setY(int y){
		myY = y;
	}
	
	public int getOrientation(){
		return myOrientation;
	}
	
	public void setOrientation(int ori){
		myOrientation = ori;
	}
	
	public void setVisible(boolean state){
		isVisible = state;
	}
	
	public boolean getVisible(){
		return isVisible;
	}
	
}
