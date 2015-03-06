package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import configuration.NestedParser.Match;
import configuration.NestedParser.TreeParser;

public class DotimesParser extends Parser{
	private TreeParser tParser;
	
	public DotimesParser() throws IOException{
		initializeSyntax();		
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
