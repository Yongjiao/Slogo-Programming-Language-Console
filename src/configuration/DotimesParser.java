package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import application.CommandFactory;
import Tree.Node;
/**
 * subclass for Dotimes command parsing
 * @author Yongjiao Yu
 *
 */
public class DotimesParser extends Parser{
	private String localVar = "";
	
	public DotimesParser(CommandFactory cf) throws IOException {
		super.setCommandFactory(cf);
	}	
	@Override
	public double parse(String s) throws ParserError{
		Queue<String> tokens = Util.toCommandQueue(s);
		skip(tokens);
		return parse(tokens);
	}	
	private double parse(Queue<String> tokens) throws ParserError {
		double result = -1;
		int limit = parseDotimesIterator(tokens);		
		parseCommands(tokens, limit);
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;		
	}
	private double parseCommands(Queue<String> qu, int limit) throws ParserError{
		double result = -1;
		if(!isListStart(qu.peek()))
			throw new ParserError("see " + qu.poll() + ", expected [ here!" );
		skip(qu);
		result = parseFor(1, limit, 1, qu);
		if(isEnd(qu) || !isListEnd(qu.poll()))
			throw new ParserError("Expected ] here !");	
		return result;
	}
	
	private int parseDotimesIterator(Queue<String> qu) throws ParserError{
		int limit = 0;
		if(!isListStart(qu.peek()))	
			throw new ParserError("see " + qu.poll() + ", expected [ here!" );
		skip(qu);
		if(!isVariable(qu.peek()))
			throw new ParserError("see" + qu.poll() + "expected variable here!" );
		localVar = qu.poll();
		limit = fetchNumericExpr(qu);
		if(!isListEnd(qu.peek()))	
			throw new ParserError("see" + qu.poll() + "expected ] here!");
		skip(qu);
		return limit;
	}
	private int fetchNumericExpr(Queue<String> qu) throws ParserError{
		Node node = buildTree(qu);
		return (int) node.getValue();
	}
	/**
	 * Parses for loop and handles local variable
	 * @param qu
	 * @return
	 * @throws ParserError
	 */
	protected double parseFor(int start, int end, int inc, Queue<String> qu) throws ParserError{
		Queue<String> temp = new LinkedList<>(qu);
		double result = -1;
		for(int i = start; i <= end; i = i+inc){
			while(!isEnd(temp) && !isListEnd(temp.peek())){
				System.out.println("It is definitely here!");
				Node n = buildTree(temp, localVar, i);
				System.out.println(n);
				result = n.getValue();	
				System.out.println("The result of the command is " + result);
			}
			if(i < end)		temp = new LinkedList<>(qu);
		}
		while(qu != temp)	skip(qu); 
		localVar = "";
		return result;
	}			
	public static void main(String[] args) throws IOException, ParserError {
		CommandFactory cf = new CommandFactory();
		DotimesParser example = new DotimesParser(cf);
		//String dotimes = "dotimes [ :name 10 ] [ sum :name 2 atan 100 ]";
		String dotimes = "dotimes [ :v 3 ] [ sum 20 :v ]";
		example.parse(dotimes);
	}
}
