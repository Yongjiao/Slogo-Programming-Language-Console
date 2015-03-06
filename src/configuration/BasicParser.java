package configuration;

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
public class BasicParser extends Configuration{
	private HashMap<String, Configuration> myParsers;	
	
	public BasicParser() throws IOException{
		initializeSyntax();		
		initializeSets();
		initializeParsers();
	    //initialize userdefined Set
		String elements[] = { "IfElse", "If", "DoTimes", "Repeat", "For","MakeVariable"};
		userdefined = new HashSet(Arrays.asList(elements));
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
	}
	public double parse(String s) throws ParserError, IOException{
		String comKey;
		double result = -1;
		Queue<String> tokens = toCommandQueue(s);
		String command = tokens.peek();
		comKey = Match.findCommandKey(tokens.peek(), patterns);
		System.out.println(comKey);
		if(userdefined.contains(comKey)){
			return myParsers.get(comKey).parse(s);
		}
		else{
			result = parse(tokens);
		}
		return result;			
	}
	
	/**
	 * parses basic nested or non-nested commands,
	 * builds more than one tree for multiple nested or non-nested commands.
	 * @param  input command in string form
	 * @return the result of the last executed commands (if nested)
	 * @throws ParserError
	 */
	public double parse(Queue<String> qu) throws ParserError{
		ArrayList<Node> roots = new ArrayList<Node>(); //dont really need the arrayList of node
		double result = -1;
		Node expRoot = buildTree(qu);			
		System.out.println("The full comamnd parsed is " + expRoot);
		if(expRoot.hasChild() == 0) 		
			throw new ParserError("Additional numeric tokens: " + expRoot.getValue());
		result = expRoot.getValue();
		System.out.println("a tree parsed is evaluated to " + result);
		roots.add(expRoot);
		System.out.println();
		return result;
	}
	private void initializeParsers() throws IOException{
		myParsers = new HashMap<>();
		myParsers.put("Makevariable", new SetParser());
		myParsers.put("If", new IfParser());
		myParsers.put("IfElse", new IfelseParser());
		myParsers.put("Repeat", new RepeatParser());
		myParsers.put("DoTimes", new DotimesParser());
		myParsers.put("For", new ForParser());
	}
	@Override
	protected void setLanguage(String path){
        patterns.addAll(Match.makePatterns(path));
        for(String key : myParsers.keySet()){
        	myParsers.get(key).setLanguage(path);
        }
	}	
	public static void main(String[] args) throws IOException, ParserError {
		String s1 = "fd 1";
		String s2= "sum 50 50";
		String s4 = "# ignore this is just comment!"; //broken when no space after #
		String s3 = "sum a b";
		String s5 = "REmainder 50 50";
		String s6 = " rt 50   ";
		String s7= "setheading 30";
		String repeat = "repeat 10 [ fd 50 ]";
		//String dotimes = "dotimes [ :name 200 ] [ rt :name ]";
		String forl = "for [ :v 0 10 1 ] [ sum 3 5 ]"; 
		//String ifl = "if less? 1 5 [ back 30 ]";
		String ifelse = "ifelse equal? 2 6 [ rt 50 ] [ lt 50 ]";
		String set = "set :m [ SUM 5 100 ]";
		String make = "make :n [ % 30 40 ]";//change to set
		//String to = "to line [ :va ] [ back 40 ]";		
		//--------------------  nested -----------------
		String basic = "+ 100 + 10 20 - 10 30"; //cant test fd
		String fd = "fd sum sum 20 sum 10 30 100 / 30 10";
		String sum = "sum sum sum sum 20 30 50 100 200 * 50 50 1000"; //will always be one last token at the very end
		String errorsum = "setxy fd sum 50 30 50 fdl";
		String m = "";
		String ifl = "if equal? 2 6 [ * 30 20 / 20 10 ]";
		String repeat2 = "repeat 10 [ sum tan 50 10 ]";
		String ifelse2 = "ifelse equal? 2 6 [ sin 50 ] [ cos 50 tan 100 ]";
		String dotimes2 = "dotimes [ :name 200 ] [ sin 300 atan 100 ]";
		String forl2 =  "for [ :v 0 10 1 ] [ / sum 3 5 10 ]";
		BasicParser example = new BasicParser(); 
		example.parse(forl2);	
	}

}
