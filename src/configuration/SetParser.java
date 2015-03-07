package configuration;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;

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
	
	public SetParser() throws IOException{
		super();
	}

	public double parse(String s) throws ParserError, IOException{
		Queue<String> tokens = toCommandQueue(s);
		skip(tokens);
		CommandCenter com = parse(tokens);	
		return com.execute();	
	}
	//can just execute() and change to double but keep for ease of debugging
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
		String sett = "set :v sum 50 100";
		SetParser example = new SetParser();
		example.parse(sett);
	}
	
}
