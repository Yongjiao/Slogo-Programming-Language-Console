package commands;

import application.Turtle;

public class SetHeading extends Rotate{
	Turtle turt;
	
	public void setHeading(int degrees){
		turt.setOrientation(degrees);
	}
	
}
