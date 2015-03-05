package configuration;

import java.util.*;
import java.util.regex.*;
import commands.Set;
import application.CommandFactory;

/**
 * A subclass dedicated only for set command parsing
 * @author Yongjiao Yu
 *
 */
public class SetParser extends Parser{
	private final String setRegex = variable + onenum;
	private final String comKey = "makevariable";
	/*@Override
	CommandFactory parse(String in ){
		return parseInput(in);  //not sure if will call the correct one
	}
	*/
	private CommandFactory parseInput(String in){
		String s = in.trim().toLowerCase();//sanitized input 
		String command = s.split(" ")[0];	
		s = s.replaceFirst(comKey, "");
		Pattern p = Pattern.compile(setRegex);
		Matcher m = p.matcher(in);				
		ArrayList<Integer> par = new ArrayList<>();
		String var = "";
		while(m.find()){
			var = m.group(1); 
			for(int i = 2; i <= m.groupCount(); i++){
				par.add(Integer.parseInt(m.group(i)));	
			}
			System.out.println("Subclass SetParser is called.");
			System.out.println("Makevairable parameters is " + var + " "+ par.get(0));
			return new Set(var, par.get(0));
		}	
		return null;		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
