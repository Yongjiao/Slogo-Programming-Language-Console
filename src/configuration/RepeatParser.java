package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import application.CommandFactory;
import Tree.Node;
/**
 * subclass for Repeat command parsing
 * @author Yongjiao Yu
 */
public class RepeatParser extends Parser{
	private CommandFactory myFactory;
	
	public RepeatParser(CommandFactory cf) throws IOException{
		myFactory = cf;
		super.setCommandFactory(cf);
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
		System.out.println("why are oyu zero " + iter);
		parseCommands(tokens, iter);
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;
	}
	private int fetchNumericExpr(Queue<String> qu) throws ParserError{
		//double result = 0; to be refactored here
		Node node = buildTree(qu);
		/*if(node.hasChild() != 0)
			throw new ParserError("see" + qu.poll() + "expected a numeric expression here!");
			*/
		return (int) node.getValue();
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
		System.out.println("start is " + start + " end is " + end + " inc is " + inc );
		for(int i = start; i < end; i++){
			result = n.getValue();		
			System.out.println(result);
		}
		return result;
	}	
	
	public static void main(String[] args) throws IOException, ParserError {
		//RepeatParser example = new RepeatParser();	
		String repeat = "repeat 10 [ sum tan 50 10 ]";
		//example.parse(repeat);
	}

}
