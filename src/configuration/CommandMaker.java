package configuration;

import java.util.ArrayList;

import application.CommandFactory;
import commands.*;

/**
 * a Command factory that makes commands.
 * @author Yongjiao Yu
 *
 */
public class CommandMaker {
/**
 * Make commands where no paramters are required
 * @return the desired command object
 */
	static public CommandFactory makeNoParmsCommands(String com){
			switch(com){
				case "Home":		    	return new Home();
				case "PenDown":  			return new PenDown();
				case "PenUp": 				return new PenUp();
				case "ClearScreen":			return new ClearScreen();
				case "ShowTurtle":			return new ShowTurtle();
				case "HideTurtle":			return new HideTurtle();
				case "IsPenDown":			return new PenDown();
				case "IsShowing":			return new Showing();
				case "Heading":				return new Heading();
				case "XCoordinate":			return new XCor();
				case "YCoordinate":			return new YCor();			
			}
			return null;
	}
	
/**
 * makes commands where parameters are required.
 * @param command key, arraylist of parameters of type Double or String
 * @param parList
 * @return
 */
   	static public CommandFactory makeBasicCommands(String com, ArrayList<Object> parList){
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
   				//case "#":
   				case "Left":			return new Left(parList);
   				case "Right":			return new Right(parList);
   				case "Setheading":		return new SetHeading(parList);
   				case "Sine":			return new Sin(parList);
   				case "Cosine":			return new Cos(parList);
   				case "Tangent":			return new Tan(parList);
   				case "Arctangent":		return new ATan(parList);
   				case "LessThan":		return new Less(parList);
   				case "GreaterThan":		return new Greater(parList);
   				case "Equal":			return new Equal(parList);
   				case "NotEqual":		return new NotEq(parList);
   				}
   				return null;	
   	}
   	
}
