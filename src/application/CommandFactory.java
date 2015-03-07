package application;

import java.util.ArrayList;

import commands.*;
import commands.arithmeticCommands.*;
import commands.viewCommands.*;
import commands.viewCommands.turtleCommands.*;

/**
 * a Command factory that makes commands.
 * @author Yongjiao Yu, modified by Anika
 *
 */
public class CommandFactory {
	
	private Pen myPen;
	private ViewHandler myViewHandler;
	
	public CommandFactory(Pen newPen, ViewHandler newVH)
	{
		myPen = newPen;
		myViewHandler = newVH;
	}
	
/**
 * Make commands where no paramters are required
 * @return the desired command object
 */
public CommandCenter makeNoParmsCommands(String com){
			switch(com){
				case "Home":		    	return new Home(myViewHandler);
				case "PenDown":  			return new PenDown(myPen);
				case "PenUp": 				return new PenUp(myPen);
				case "ClearScreen":			return new ClearScreen(myViewHandler);
				case "ShowTurtle":			return new ShowTurtle(myViewHandler);
				case "HideTurtle":			return new HideTurtle(myViewHandler);
				case "IsPenDown":			return new IsPD(myPen);
				case "IsShowing":			return new Showing(myViewHandler);
				case "Heading":				return new Heading(myViewHandler);
				case "XCoordinate":			return new XCor(myViewHandler);
				case "YCoordinate":			return new YCor(myViewHandler);	
				case "GetPenColor":			return new PenColor(myPen);		
				
			}
			return null;
	}
	
/**
 * makes commands where parameters are required.
 * @param command key, arraylist of parameters of type Double or String
 * @param parList
 * @return
 */
   	public CommandCenter makeBasicCommands(String com, ArrayList<Object> parList){
   		switch(com){
   				case "Forward": 		return new Forward(parList, myViewHandler);
   				case "Backward":		return new Backward(parList, myViewHandler);
   				case "SetTowards":		return new GoTowardsLoc(parList, myViewHandler);
   				case "SetPosition":		return new GoToLocation(parList, myViewHandler);
   				case "Sum":				return new Add(parList);
   				case "Difference":		return new Subtract(parList);
   				case "Product":			return new Multiply(parList);
   				case "Quotient":		return new Divide(parList);
   				case "Remainder":		return new Remainder(parList);
   				case "Left":			return new Left(parList, myViewHandler);
   				case "Right":			return new Right(parList, myViewHandler);
   				case "SetHeading":		return new SetHeading(parList, myViewHandler);
   				case "Sine":			return new Sin(parList);
   				case "Cosine":			return new Cos(parList);
   				case "Tangent":			return new Tan(parList);
   				case "ArcTangent":		return new ATan(parList);
   				case "LessThan":		return new Less(parList);
   				case "GreaterThan":		return new Greater(parList);
   				case "Equal":			return new Equal(parList);
   				case "NotEqual":		return new NotEq(parList);
   				case "NaturalLog": 		return new Log(parList);
   				case "And":				return new And(parList);
   				case "Minus":			return new Minus(parList);
   				case "Not":				return new Not(parList);
   				case "Or":				return new Or(parList);
   				case "Power":			return new Pow(parList);
   				case "Random":			return new Random(parList);
   				case "SetBackground":	return new SetBackground(parList, myViewHandler);
   				case "SetPenColor":		return new SetPenColor(parList, myPen);
   				case "SetPenSize":		return new SetPenSize(parList, myPen);
				case "SetPalette":		return new SetPalette(parList, myPen);
   				//case "#":
   				}
   				return null;	
   	}
   	
 	static public CommandCenter makeBasicCommands(String com, String s, ArrayList<Object> parList){ 
 		return null;
 	}
   	
}
