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
 * subclass for Ifelse command parsing
 * @author Yongjiao Yu
 *
 */
public class IfelseParser extends Parser{
	private String comment, constant, variable, command, liststart, listend, groupstart,groupend;		
	private List<Entry<String, Pattern>> patterns; 
	private HashSet<String> oneParComs;
	private HashSet<String> twoParComs;
	
	public IfelseParser() throws IOException{
		initialize();
	}
	public double parse(String s) throws IOException, ParserError{
		Queue<String> tokens = toCommandQueue(s);
		System.out.println(tokens);
		skip(tokens);
		return parse(tokens);
	}
	private double parse(Queue<String> tokens) throws ParserError {
		double result = -1; 
		ArrayList<Node> ifTree = null, elseTree = null;
		if(!isboolean(tokens.peek()))	
			throw new ParserError("see " + tokens.poll() + "Expected boolean expression Here!");
		double expr = buildTree(tokens).getValue();
		ifTree = parseCommands(tokens);
		while(!isEnd(tokens) && tokens.peek().matches(listend)) //skip till the second command
			skip(tokens);
		elseTree = parseCommands(tokens);
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		if(expr == 1)	return executeAll(ifTree);
		System.out.println("Else statement gets executed");
		return executeAll(elseTree);	
	}
	/**
	 * parses list of nested commands in bracket. [ command1 command2 command3 ]
	 * @param a queue of commands
	 * @return list of tree node representing each command
	 * @throws ParserError
	 */
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
		IfelseParser example = new IfelseParser();
		String ifelse = "ifelse equal? 2 6 [ sin 50 ] [ cos 50 tan 100 ]";
		example.parse(ifelse);
	}
	
	
}
