package configuration;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;

import application.CommandFactory;
import commands.CommandCenter;
import commands.viewCommands.turtleCommands.Set;
import Tree.BinNode;
import Tree.ConstNode;
import Tree.SingleNode;

/**
 * A subclass dedicated only for set command parsing
 * @author Yongjiao Yu
 *
 */
public class SetParser extends Parser{
	private CommandFactory myFactory;
	
	public SetParser(CommandFactory cf) throws IOException{
		myFactory = cf;
		super.setCommandFactory(cf);
	}

	public double parse(String s) throws ParserError, IOException{
		Queue<String> tokens = Util.toCommandQueue(s);
		skip(tokens);
		CommandCenter com = parse(tokens);	
		return com.execute();	
	}

	private CommandCenter parse(Queue<String> tokens) throws ParserError {		
		String token = tokens.poll();
		if(!isVariable(token))
			throw new ParserError("Expected Variable here!");		
		double val = buildTree(tokens).getValue();
		ArrayList<Object> par = new ArrayList<>();
		par.add(val);
		System.out.println("set parameter is " + par);
		if(!isEnd(tokens))	
			throw new ParserError("Too many commands for Set command!");
		System.out.println(par);
		return new Set(token, par);
	}
	
	public static void main(String[] args) throws IOException, ParserError {
	//	String sett = "set :v sum 50 100";
	//	SetParser example = new SetParser();
	//	example.parse(sett);
	}
	
}
