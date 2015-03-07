package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import Tree.Node;
/**
 * subclass for If command parsing
 * @author Yongjiao Yu
 *
 */
public class IfParser extends Parser{
	
	public IfParser() throws IOException{
		initializeSyntax();		
		initializeSets();
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
	}	

	public double parse(String s) throws IOException, ParserError{
		Queue<String> tokens = toCommandQueue(s);
		System.out.println(tokens);
		skip(tokens);
		return parse(tokens);
	}
	/**
	 * @param command queue
	 * @return last executed command return value if boolean is evaluated to 0 
	 * @throws ParserError
	 */
	private double parse(Queue<String> tokens) throws ParserError {
		ArrayList<Node> ifstatements = new ArrayList<Node>();
		if(!isboolean(tokens.peek()))	throw new ParserError("see " + tokens.poll() + "Expected boolean expression Here!");
		double expr = buildTree(tokens).getValue();
		ifstatements = parseCommands(tokens);
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		if(expr == 0)	return -1;
		return executeAll(ifstatements);
	}

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
	
	private boolean isboolean(String s){	
		String comKey = Match.findCommandKey(s, patterns);
		return comKey.matches("(LessThan|GreaterThan|Equal|NotEqual|And|Or|Not)");
	}
	
	public static void main(String[] args) throws IOException, ParserError {
		IfParser example = new IfParser();
		String ifl = "if equal? 2 6 [ * 30 20 / 20 10 ]";
		example.parse(ifl);
	}
	
}
