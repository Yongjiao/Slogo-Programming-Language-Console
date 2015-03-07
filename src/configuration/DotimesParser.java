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
 * subclass for Dotimes command parsing
 * @author Yongjiao Yu
 *
 */
public class DotimesParser extends Parser{
	private String comment, constant, variable, command, liststart, listend, groupstart,groupend;		
	private List<Entry<String, Pattern>> patterns; 
	private HashSet<String> oneParComs;
	private HashSet<String> twoParComs;
	
	public DotimesParser() throws IOException{
		initialize();
	}
	@Override
	public double parse(String s) throws ParserError{
		Queue<String> tokens = toCommandQueue(s);
		System.out.println(tokens);
		skip(tokens);
		return parse(tokens);
	}	
	private double parse(Queue<String> tokens) throws ParserError {
		double result = -1;
		int limit = parseDotimesIterator(tokens);		
		//parse [ command ]
		if(!tokens.peek().matches(liststart))
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		while(!isEnd(tokens) && !tokens.peek().matches(listend)){
			result = parseFor(1, limit, 1, tokens);
		}
		if(isEnd(tokens) || !tokens.poll().matches(listend))
			throw new ParserError("Expected ] here !");
		//
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;		
	}
	
	private int parseDotimesIterator(Queue<String> qu) throws ParserError{
		int limit = 0;
		if(!qu.peek().matches(liststart))	
			throw new ParserError("see " + qu.poll() + ", expected [ here!" );
		skip(qu);
		if(!qu.peek().matches(variable))
			throw new ParserError("see" + qu.poll() + "expected variable here!" );
		skip(qu); //skip variable
		limit = fetchConstant(qu);
		if(!qu.peek().matches(listend))	
			throw new ParserError("see" + qu.poll() + "expected ] here!");
		skip(qu);
		return limit;
	}
	
	private int fetchConstant(Queue<String> qu) throws ParserError{
		if(!qu.peek().matches(constant))
			throw new ParserError("see" + qu.poll() + "expected number here!");
		return Integer.parseInt(qu.poll());
	}
	//different from other method of same name
	private double parseFor(int start, int end, int inc, Queue<String> qu) throws ParserError{
		double result = -1; //make more Treeparser.parse(Queue, String, int i);
		Node n = buildTree(qu);
		System.out.println("Tree parsed is " + n);
		for(int i = start; i <= end; i++){
			result = n.getValue();		//execute tree for # iterations	
		}
		return result;
	}	
	
	public static void main(String[] args) throws IOException, ParserError {
		DotimesParser example = new DotimesParser();
		String dotimes = "dotimes [ :name 200 ] [ sin 300 atan 100 ]";
		example.parse(dotimes);
	}

}
