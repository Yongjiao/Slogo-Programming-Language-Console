package configuration;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import commands.UserMadeUtilities;
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
	
	protected Parser() throws IOException{
		initialize();
	}
	/**abstract function, parses user input to expression tree and execute 
	 * @param user input
	 * @return return value of last executed command
	 */
	abstract protected double parse(String s) throws ParserError, IOException;
	protected void initialize() throws IOException{
		initializeSyntax();		
		initializeSets();
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Util.makePatterns("resources/languages/English"));
	}
	protected void setLanguage(String path){
		patterns.clear();
        patterns.addAll(Util.makePatterns(path));
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
		oneParComs = Util.makeSet("src/resources/languages/OneParCommands");
		twoParComs = Util.makeSet("src/resources/languages/TwoParCommands");
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
		if(isCommand(token)){
			String comKey = Util.findCommandKey(token, patterns);	
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
		if(isConstant(token)){
			double val = Double.parseDouble(token);
			return new ConstNode(val);
		}
		if(isVariable(token)){
			if(!UserMadeUtilities.containsVars(token))
				throw new ParserError("Undefined global variable" + token);
			double val = UserMadeUtilities.getFromVars(token);
			return new ConstNode(val);
		}
		else		 
			throw new ParserError("unexpected Token: "+ token);
	}
	/**
	 * parses commands for each loop iteration with the loop iterator/local variables 
	 * @param command string
	 * @param localVar
	 * @param value of iterator
	 * @return the constructed tree for one iteration
	 * @throws ParserError
	 */
	protected Node buildTree(Queue<String> tokens, String localVar, int iterator) throws ParserError {
		String token = tokens.poll();
		System.out.println("TreeParsing the token: " + token);
		if(isCommand(token)){
			String comKey = Util.findCommandKey(token, patterns);	
			System.out.println();
			if(oneParComs.contains(comKey)){
				Node child = buildTree(tokens, localVar, iterator);
				return new SingleNode(comKey , child);
			}			
			if(twoParComs.contains(comKey)){
				Node left = buildTree(tokens, localVar, iterator);
				Node right = buildTree(tokens, localVar, iterator); 
				return new BinNode(comKey, left, right);
			}
			else
				throw new ParserError("Command Undefined: " + token);
		}
		if(isConstant(token)){
			double val = Double.parseDouble(token);
			return new ConstNode(val);
		}
		if(isVariable(token)){
			System.out.println(token + "the local vairbale is " + localVar);
			double val = 0;
			if(token.equals(localVar))	return new ConstNode(iterator);
			if(!UserMadeUtilities.containsVars(token))
				throw new ParserError("Undefined global variable " + token);
			val = UserMadeUtilities.getFromVars(token);
			return new ConstNode(val);
		}
		else		 
			throw new ParserError("unexpected Token: "+ token);
	}
	protected boolean isListEnd(String s){
		return s.matches(listend);
	}
	protected boolean isListStart(String s){
		return s.matches(liststart);
	}
	protected boolean isVariable(String s){
		return s.matches(variable);	
	}
	protected boolean isConstant(String s){
		return s.matches(constant);
	}
	protected boolean isCommand(String s){
		return s.matches(command);
	}
	protected void skip(Queue<String> qu){
		qu.poll();
	}
	protected boolean isEnd(Queue<String> qu){
		return qu.isEmpty();
	}
	protected List<Entry<String, Pattern>> getPatterns(){
		return patterns;
	}
}
