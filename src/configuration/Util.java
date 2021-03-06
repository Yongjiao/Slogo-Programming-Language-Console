package configuration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import Tree.Node;

/**
 * A utility class for convenience of Parsing
 * @author Yongjiao Yu, Professor Robert Duvell
 *
 */
public class Util {
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
	public static Queue<String> toCommandQueue(String str) {
		String[] s = str.split(" ");
		Queue<String> qu = new LinkedList<String>();
		for(int i =0; i < s.length; i++){
			qu.add(s[i]);
		}
		return qu;
	}	
	/**
	 * @param execute all commands in the list of tree
	 * @return return value of last executed command
	 */
	public static double executeAll(ArrayList<Node> commands){
		double result = -1;
		for(int i =0; i < commands.size(); i++)
			result = commands.get(i).getValue();
		return result;
	}
   		
}
