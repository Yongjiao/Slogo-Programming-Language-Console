package configuration.NestedParser;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import application.CommandFactory;
import Tree.*;
/**
 * Parses nested Command
 * @author Yongjiao Yu
 *
 */
public class TreeParser {
	private String comment, constant, variable, command, liststart, listend, groupstart,groupend;	
	private HashSet<String> oneParComs;
	private HashSet<String> twoParComs;
	private List<Entry<String, Pattern>> patterns; 
	
	public TreeParser() throws IOException{
		initializeSyntax();		
		initializeSets();
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
	}
	
	private void initializeSets() throws IOException{		
		oneParComs = Match.makeSet("src/resources/languages/OneParCommands");
		twoParComs = Match.makeSet("src/resources/languages/TwoParCommands");
	}
	
	private void initializeSyntax(){
		ResourceBundle b = ResourceBundle.getBundle("resources.languages.Syntax"); 
		constant = b.getString("Constant");
		variable = b.getString("Variable");
		command = b.getString("Command");		
		comment = b.getString("Comment");
		liststart = b.getString("ListStart");
		listend = b.getString("ListEnd");
		groupstart = b.getString("GroupStart");
		groupend = b.getString("GroupEnd");		
	}	
	
	/**
	 * parses basic nested or non-nested commands,
	 * builds more than one tree for multiple nested or non-nested commands.
	 * @param  input command in string form
	 * @return the result of the last executed commands (if nested)
	 * @throws ParserError
	 */
	public double parse(String s) throws ParserError{
		String[] str = s.split(" ");
		Queue<String> tokens = makeCommandQueue(str);
		ArrayList<Node> roots = new ArrayList<Node>(); //dont really need the arrayList of node
		double result = -1;
		while(!isEnd(tokens)){
			Node expRoot = parse(tokens);
			System.out.println(expRoot);
			if(expRoot.hasChild() == 0) 		
				throw new ParserError("Additional numeric tokens: " + expRoot.getValue());
			roots.add(expRoot);
			System.out.println();
		}
		//result = expRoot.getValue(); put inside loop
		return result;
		//CommandFactory com = expRoot.getValue();
		//com.execute();
	}
	/**
	 * parses commands till a full command is parsed or when a single tree is built.
	 * @param  tokens
	 * @return an expression tree for a full (nested) command
	 * @throws ParserError
	 */
	public Node parse(Queue<String> tokens) throws ParserError {
		String token = tokens.poll();
		if(token.matches(command)){
			String comKey = Match.findCommandKey(token, patterns);	
			if(oneParComs.contains(comKey)){
				Node child = parse(tokens);
				return new SingleNode(comKey , child);
			}			
			if(twoParComs.contains(comKey)){
				Node left = parse(tokens);
				Node right = parse(tokens); 
				return new BinNode(comKey, left, right);
			}
			else
				throw new ParserError("Command Undefined: " + token);
		}
		if(token.matches(constant)){
			double val = Double.parseDouble(token);
			return new ConstNode(val);
		}
		if(token.matches(variable)){
			//get value from Map
			double val = Double.parseDouble(token);
			return new ConstNode(val);
		}
		else		 
			throw new ParserError("unexpected Token: "+ token);
	}
		
	private Queue<String> makeCommandQueue(String[] s) {
		Queue<String> qu = new LinkedList<String>();
		for(int i =0; i < s.length; i++){
			 qu.add(s[i]);
		}
		return qu;
	}
	protected boolean isEnd(Queue<String> qu){
		return qu.isEmpty();
	}
	
	public static void main(String[] args) throws IOException, ParserError {
		// TODO Auto-generated method stub
		String fd = "fd sum sum 20 sum 10 30 100 / 30 10";
		String sum = "sum sum sum sum 20 30 50 100 200 * 50 50 1000"; //will always be one last token at the very end
		String errorsum = "setxy fd sum 50 30 50 fdl";
		TreeParser example = new TreeParser(); 
		example.parse(errorsum);			
	}
	
}
