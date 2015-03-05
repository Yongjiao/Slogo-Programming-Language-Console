package configuration.NestedParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;
import application.CommandFactory;
import commands.*;
import Tree.Node;

/**
 * A utility class for convenience of Parsing
 * @author Yongjiao
 *
 */
public class Match {
    private static boolean match (String input, Pattern regex) {
        return regex.matcher(input).matches();
    }
    public static String findCommandKey (String s, List<Entry<String, Pattern>> patterns) {
                for (Entry<String, Pattern> p : patterns) {
                    if (match(s, p.getValue())) {
                        return p.getKey();
                    }
                }
                return null;
    }
    
    public static List<Entry<String, Pattern>> makePatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        List<Entry<String, Pattern>> patterns = new ArrayList<>();
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            patterns.add(new SimpleEntry<String, Pattern>(key,
                         // THIS IS THE KEY LINE
                         Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
        return patterns;
    }
   	public static HashSet<String> makeSet(String s) throws IOException{
   		File f = new File(s);
   		HashSet<String> set = new HashSet<>();
   		BufferedReader br = new BufferedReader(new FileReader(s));
   		String line;
   		while ((line = br.readLine()) != null) {
   		   set.add(line.trim());
   		}
   		br.close();
   		return set;
   	}
   	public static CommandFactory makeCommands(String com, ArrayList<Object> parList){
   		CommandFactory comFactory;
   		switch(com){
   				case "forward": 		return new Forward(parList);
   				case "backward":		return new Backward(parList);
   				case "settowards":		return new GoTowardsLoc(parList);
   				case "setposition":		return new GoToLocation(parList);
   				case "sum":				return new Add(parList);
   				case "difference":		return new Subtract(parList);
   				case "product":			return new Multiply(parList));
   				case "quotient":		return new Divide(parList);
   				case "remainder":		return new Remainder(parList);
   				//case "#":
   				case "left":			return new Left(parList);
   				case "right":			return new Right(parList);
   				case "setheading":		return new SetHeading(parList);
   				case "sine":			return new Sin(parList);
   				case "cosine":			return new Cos(parList);
   				case "tangent":			return new Tan(parList);
   				case "arctangent":		return new ATan(parList);
   				case "lessthan":		return new Less(parList);
   				case "greaterthan":		return new Greater(parList);
   				case "equal":			return new Equal(parList);
   				case "notequal":		return new NotEq(parList);
   				}
   				return null;	
   	}
   	
}
