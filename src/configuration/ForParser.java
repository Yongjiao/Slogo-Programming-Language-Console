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
 * subclass for For command parsing
 * @author Yongjiao Yu
 *
 */
public class ForParser extends Parser{
	private String comment, constant, variable, command, liststart, listend, groupstart,groupend;		
	private List<Entry<String, Pattern>> patterns; 

	
	public ForParser() throws IOException{
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
		int start, end, inc;
		double result = -1;
		if(!tokens.peek().matches(liststart))	
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		if(!tokens.peek().matches(variable))
			throw new ParserError("see" + tokens.poll() + "expected variable here!" );
		skip(tokens); //skip variable
		start = fetchConstant(tokens);
		end  = fetchConstant(tokens);
		inc = fetchConstant(tokens);
		if(!tokens.peek().matches(listend))	
			throw new ParserError("see" + tokens.poll() + "expected ] here!");
		skip(tokens);
		//
		if(!tokens.peek().matches(liststart))
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		while(!isEnd(tokens) && !tokens.peek().matches(listend)){
			result = parseFor(start, end, inc, tokens);
		}
		if(isEnd(tokens) || !tokens.poll().matches(listend))
			throw new ParserError("Expected ] here !");
		//
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;		
	}
/*
	//qu -> { tParser.parse(qu); }
	private ArrayList<Node> parseCommands(Queue<String> qu) throws ParserError{
		ArrayList<Node>	list = new ArrayList();
		if(!qu.peek().matches(liststart))
			throw new ParserError("see " + qu.poll() + ", expected [ here!" );
		skip(qu);
		while(!isEnd(qu) && !qu.peek().matches(listend)){
			list.add(buildTree(qu));
			System.out.println("Tree parsed is " + list.get(list.size() -1));
		}
		if(isEnd(qu) || !qu.poll().matches(listend))
			throw new ParserError("Expected ] here !");
		return list;
	}
*/	
	private double parseFor(int start, int end, int inc, Queue<String> qu) throws ParserError{
		double result = -1; //make more Treeparser.parse(Queue, String, int i);
		Node n = buildTree(qu);
		System.out.println("Tree parsed is " + n);
		for(int i = start; i < end; i++){
			result = n.getValue();		//execute tree for # iterations	
		}
		return result;
	}	
	private int fetchConstant(Queue<String> qu) throws ParserError{
		if(!qu.peek().matches(constant))
			throw new ParserError("see" + qu.poll() + "expected number here!");
		return Integer.parseInt(qu.poll());
	}
	public static void main(String[] args) throws IOException, ParserError {
		ForParser example = new ForParser();
		String forl =  "for [ :v 0 10 1 ] [ / sum 3 5 10 ]";
		example.parse(forl);
	}
}
