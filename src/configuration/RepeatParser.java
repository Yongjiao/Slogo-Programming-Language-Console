package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import Tree.Node;
/**
 * subclass for Repeat command parsing
 * @author Yongjiao Yu
 */
public class RepeatParser extends Parser{
	
	public RepeatParser() throws IOException{
		super();
	}
	@Override
	public double parse(String s) throws IOException, ParserError{
		Queue<String> tokens = Util.toCommandQueue(s);
		System.out.println(tokens);
		skip(tokens);
		return parse(tokens);
	}	
	private double parse(Queue<String> tokens) throws ParserError {
		double result = -1;
		int iter = fetchNumericExpr(tokens);
		parseCommands(tokens, iter);
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;
	}
	private int fetchNumericExpr(Queue<String> qu) throws ParserError{
		double result = 0;
		Tree node = buildTree(qu);
		if(node.hasChild() != 0)
			throw new ParserError("see" + qu.poll() + "expected a numeric expression here!");
		return result;
	}
	private double parseCommands(Queue<String> qu, int iter) throws ParserError{
		double result = -1;
		if(!isListStart(qu.peek()))
			throw new ParserError("see " + qu.poll() + ", expected [ here!" );
		skip(qu);
		while(!isEnd(qu) && !isListEnd(qu.peek())){
			result = parseFor(0, iter, 1, qu);
		}
		if(isEnd(qu) || !isListEnd(qu.poll()))
			throw new ParserError("Expected ] here !");
		return result;
	}
	private double parseFor(int start, int end, int inc, Queue<String> qu) throws ParserError{
		double result = -1; 
		Node n = buildTree(qu);
		System.out.println("Tree parsed is " + n);
		for(int i = start; i < end; i++){
			result = n.getValue();		
		}
		return result;
	}	
	
	public static void main(String[] args) throws IOException, ParserError {
		RepeatParser example = new RepeatParser();	
		String repeat = "repeat 10 [ sum tan 50 10 ]";
		example.parse(repeat);
	}

}
