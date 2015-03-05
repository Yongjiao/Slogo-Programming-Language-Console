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
				case "home":		    	return new Home();
				case "pendown":  			return new PenDown();
				case "penup": 				return new PenUp();
				case "clearscreen":			return new ClearScreen();
				case "showturtle":			return new ShowTurtle();
				case "hideturtle":			return new HideTurtle();
				case "ispendown":			return new Down();
				case "isshowing":			return new Showing();
				case "heading":				return new Heading();
				case "xcoordinate":			return new XCor();
				case "ycoordinate":			return new YCor();			
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
   		CommandFactory comFactory;
   		switch(com){
   				case "forward": 		return new Forward(parList);
   				case "backward":		return new Backward(parList);
   				case "settowards":		return new GoTowardsLoc(parList);
   				case "setposition":		return new GoToLocation(parList);
   				case "sum":				return new Add(parList);
   				case "difference":		return new Subtract(parList);
   				case "product":			return new Multiply(parList));
   				case "quotient":		return new Divide(parList);
   				case "remainder":		return new Remainder(parList);
   				//case "#":
   				case "left":			return new Left(parList);
   				case "right":			return new Right(parList);
   				case "setheading":		return new SetHeading(parList);
   				case "sine":			return new Sin(parList);
   				case "cosine":			return new Cos(parList);
   				case "tangent":			return new Tan(parList);
   				case "arctangent":		return new ATan(parList);
   				case "lessthan":		return new Less(parList);
   				case "greaterthan":		return new Greater(parList);
   				case "equal":			return new Equal(parList);
   				case "notequal":		return new NotEq(parList);
   				}
   				return null;	
   	}
   	
}
