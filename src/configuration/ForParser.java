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
 * subclass for For command parsing
 * @author Yongjiao Yu
 *
 */
public class ForParser extends Parser{
	private String localVar;
	private CommandFactory myFactory;
	
	public ForParser(CommandFactory cf) throws IOException{
		myFactory = cf;
		super.setCommandFactory(cf);
	}
	@Override
	public double parse(String s) throws ParserError{
		Queue<String> tokens = Util.toCommandQueue(s);
		System.out.println(tokens);
		skip(tokens);
		return parse(tokens);
	}	
	private double parse(Queue<String> tokens) throws ParserError {
		int start, end, inc;
		double result = -1;
		if(!isListStart(tokens.peek()))	
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		if(!isVariable(tokens.peek()))
			throw new ParserError("see" + tokens.poll() + "expected variable here!" );
		localVar = tokens.poll();
		start = fetchNumericExpr(tokens);
		end  = fetchNumericExpr(tokens);
		inc = fetchNumericExpr(tokens);
		if(!isListEnd(tokens.peek()))	
			throw new ParserError("see" + tokens.poll() + "expected ] here!");
		skip(tokens);
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;		
	}
	private double parseCommands(Queue<String> qu, int start, int end, int inc) throws ParserError{
		double result = -1;
		if(!isListStart(qu.peek()))
			throw new ParserError("see " + qu.poll() + ", expected [ here!" );
		skip(qu);
		result = parseFor(start, end, inc, qu);
		if(isEnd(qu) || !isListEnd(qu.poll()))
			throw new ParserError("Expected ] here !");
		return result;
	}
	private int fetchNumericExpr(Queue<String> qu) throws ParserError{
		Node node = buildTree(qu);
		if(node.hasChild() != 0)
			throw new ParserError("see" + qu.poll() + "expected a numeric expression here!");		
		return (int) node.getValue();
	}
	private double parseFor(int start, int end, int inc, Queue<String> qu) throws ParserError{
		Queue<String> temp = new LinkedList<>(qu);
		double result = -1;
		for(int i = start; i <= end; i++){
			while(!isEnd(temp) && !isListEnd(temp.peek())){
				Node n = buildTree(temp, localVar, i); 
				System.out.println("Tree parsed is " + n);
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
//		ForParser example = new ForParser();
		String forl =  "for [ :v 0 10 1 ] [ / sum :v 5 10 ]";
//		example.parse(forl);
	}
}
