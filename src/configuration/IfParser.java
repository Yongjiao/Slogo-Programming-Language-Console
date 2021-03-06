package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import application.CommandFactory;
import Tree.Node;
/**
 * subclass for If command parsing
 * @author Yongjiao Yu
 *
 */
public class IfParser extends IfelseParser{
	private CommandFactory myFactory;	
	public IfParser(CommandFactory cf) throws IOException{
		super(cf);
		myFactory = cf;
	}	
	public double parse(String s) throws IOException, ParserError{
		Queue<String> tokens = Util.toCommandQueue(s);
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
		int expr = (int) evaluateBoolExpr(tokens);
		ifstatements = parseListCommands(tokens);
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		if(expr == 0)	return -1;
		return Util.executeAll(ifstatements);
	}

	public static void main(String[] args) throws IOException, ParserError {
		//IfParser example = new IfParser();
		String ifl = "if equal? 2 6 [ * 30 20 / 20 10 ]";
		//example.parse(ifl);
	}
}
