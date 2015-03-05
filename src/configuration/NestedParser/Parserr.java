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
public class Parserr {
	private String comment, constant, variable, command, liststart, listend, groupstart,groupend;	
	private HashSet<String> oneParComs;
	private HashSet<String> twoParComs;
	private List<Entry<String, Pattern>> patterns; 
	private Queue<String> tokens;
	
	public Parserr() throws IOException{
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
	
	public void parse(String s) throws ParserError{
		String[] str = s.split(" ");
		makeCommandQueue(str);
		Node expRoot = parse(tokens);
		expRoot.printTree();
		//CommandFactory com = expRoot.getValue();
		//com.execute();
	}
	
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
				throw new ParserError("Command Undefined!");
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
			throw new ParserError("unExpected Token, Invalid Format!");
	}
		
	
	private void makeCommandQueue(String[] s) {
		tokens = new LinkedList<String>();
		for(int i =0; i < s.length; i++){
			 tokens.add(s[i]);
		}
	}

	public static void main(String[] args) throws IOException, ParserError {
		// TODO Auto-generated method stub
		String fd = "fd sum sum 20 sum 10 30 100";
		String sum = "sum sum sum sum 20 30 50 100 200";
		Parserr example = new Parserr(); 
		example.parse(sum);	
	}
	
}
