package configuration;

import java.util.ArrayList;
import commands.*;
import commands.arithmeticCommands.*;
import commands.viewCommands.*;
import commands.viewCommands.turtleCommands.*;

/**
 * a Command factory that makes commands.
 * @author Yongjiao Yu
 *
 */
public class CommandFactory {
/**
 * Make commands where no paramters are required
 * @return the desired command object
 */
	static public CommandCenter makeNoParmsCommands(String com){
			switch(com){
				case "Home":		    	return new Home();
				case "PenDown":  			return new PenDown();
				case "PenUp": 				return new PenUp();
				case "ClearScreen":			return new ClearScreen();
				case "ShowTurtle":			return new ShowTurtle();
				case "HideTurtle":			return new HideTurtle();
				case "IsPenDown":			return new IsPD();
				case "IsShowing":			return new Showing();
				case "Heading":				return new Heading();
				case "XCoordinate":			return new XCor();
				case "YCoordinate":			return new YCor();	
				case "GetPenColor":			return new PenColor();		
				
			}
			return null;
	}
	
/**
 * makes commands where parameters are required.
 * @param command key, arraylist of parameters of type Double or String
 * @param parList
 * @return
 */
   	static public CommandCenter makeBasicCommands(String com, ArrayList<Object> parList){
   		switch(com){
   				case "Forward": 		return new Forward(parList);
   				case "Backward":		return new Backward(parList);
   				case "SetTowards":		return new GoTowardsLoc(parList);
   				case "SetPosition":		return new GoToLocation(parList);
   				case "Sum":				return new Add(parList);
   				case "Difference":		return new Subtract(parList);
   				case "Product":			return new Multiply(parList);
   				case "Quotient":		return new Divide(parList);
   				case "Remainder":		return new Remainder(parList);
   				case "Left":			return new Left(parList);
   				case "Right":			return new Right(parList);
   				case "SetHeading":		return new SetHeading(parList);
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
   				case "SetBackground":	return new SetBackground(parList);
   				case "SetPenColor":		return new SetPenColor(parList);
   				case "SetPenSize":		return new SetPenSize(parList);
				case "SetPalette":		return new SetPalette(parList);
   				//case "To":				return new To();
   				//case "#":
   				}
   				return null;	
   	}
   	
 	static public CommandCenter makeBasicCommands(String com, String s, ArrayList<Object> parList){ 
 		return null;
 	}
   	
}