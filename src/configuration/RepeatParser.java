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
		Queue<String> tokens = toCommandQueue(s);
		System.out.println(tokens);
		skip(tokens);
		return parse(tokens);
	}	
	private double parse(Queue<String> tokens) throws ParserError {
		double result = -1;
		Node expr = buildTree(tokens); //can be a numeric node
		int iter = (int) expr.getValue();
		//comment parse start from here
		if(!isListStart(tokens.peek()))
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		while(!isEnd(tokens) && !isListEnd(tokens.peek())){
			result = parseFor(0, iter, 1, tokens);
		}
		if(isEnd(tokens) || !isListEnd(tokens.poll()))
			throw new ParserError("Expected ] here !");
		//
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;
	}
	
	private double parseFor(int start, int end, int inc, Queue<String> qu) throws ParserError{
		double result = -1; //make more Treeparser.parse(Queue, String, int i);
		Node n = buildTree(qu);
		System.out.println("Tree parsed is " + n);
		for(int i = start; i < end; i++){
			result = n.getValue();		//execute tree for # iterations	
		}
		return result;
	}	
	
	public static void main(String[] args) throws IOException, ParserError {
		RepeatParser example = new RepeatParser();	
		String repeat = "repeat 10 [ sum tan 50 10 ]";
		example.parse(repeat);
	}

}
