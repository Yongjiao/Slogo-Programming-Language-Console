package configuration;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import Tree.BinNode;
import Tree.ConstNode;
import Tree.Node;
import Tree.SingleNode;
/**
 * super class for input parsing and validation using expression tree 
 * @author Yongjiao Yu
 *
 */
public abstract class Parser {
	private String comment, constant, variable, command, liststart, listend, groupstart,groupend;		
	private List<Entry<String, Pattern>> patterns; 
	private HashSet<String> oneParComs;
	private HashSet<String> twoParComs;
	
	/** parses user input to expression tree and execute 
	 * @param user input
	 * @return return value of last executed command
	 */
	abstract protected double parse(String s) throws ParserError, IOException;
	protected void initialize() throws IOException{
		initializeSyntax();		
		initializeSets();
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
	}
	protected void setLanguage(String path){
        patterns.addAll(Match.makePatterns(path));
	}
	protected void initializeSyntax(){
		ResourceBundle b = ResourceBundle.getBundle("resources.languages.Syntax"); 
		comment = b.getString("Comment");
		constant = b.getString("Constant");
		variable = b.getString("Variable");
		command = b.getString("Command");
		liststart = b.getString("ListStart");
		listend = b.getString("ListEnd");
		groupstart = b.getString("GroupStart");
		groupend = b.getString("GroupEnd");
	}
	protected void initializeSets() throws IOException{		
		oneParComs = Match.makeSet("src/resources/languages/OneParCommands");
		twoParComs = Match.makeSet("src/resources/languages/TwoParCommands");
	}	
	/**
	 * parses commands till a full command is parsed or when a single tree is built.
	 * @param  command tokens
	 * @return an expression tree for a full (nested) command
	 * @throws ParserError
	 */
	protected Node buildTree(Queue<String> tokens) throws ParserError {
		String token = tokens.poll();
		System.out.println("TreeParsing the token: " + token);
		if(token.matches(command)){
			String comKey = Match.findCommandKey(token, patterns);	
			System.out.println();
			if(oneParComs.contains(comKey)){
				Node child = buildTree(tokens);
				return new SingleNode(comKey , child);
			}			
			if(twoParComs.contains(comKey)){
				Node left = buildTree(tokens);
				Node right = buildTree(tokens); 
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
	protected Queue<String> toCommandQueue(String str) {
		String[] s = str.split(" ");
		Queue<String> qu = new LinkedList<String>();
		for(int i =0; i < s.length; i++){
			qu.add(s[i]);
		}
		return qu;
	}	
	protected void skip(Queue<String> qu){
		qu.poll();
	}
	protected boolean isEnd(Queue<String> qu){
		return qu.isEmpty();
	}
	/**
	 * @param execute all commands in the list of tree
	 * @return return value of last executed command
	 */
	protected double executeAll(ArrayList<Node> commands){
		double result = -1;
		for(int i =0; i < commands.size(); i++)
			result = commands.get(i).getValue();
		return result;
	}
}
