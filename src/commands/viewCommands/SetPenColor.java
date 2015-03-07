package commands.viewCommands;

import java.util.ArrayList;

import application.Pen;
import application.PenHandler;
import application.ViewHandler;
import commands.viewCommands.turtleCommands.Display;

public class SetPenColor extends ViewCommands{
	
	
	
	public SetPenColor(ArrayList<Object> p, PenHandler pen) {
		super(p, pen);
	}
	
	// Modified: Anika
	public double execute() {
		int index = (Integer) super.getParams().get(super.getParams().size() - 1);
		super.getPenHandler().setPenColor(index);
		return index;
	}

}
