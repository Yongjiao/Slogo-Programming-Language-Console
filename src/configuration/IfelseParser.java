package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import configuration.NestedParser.Match;
import configuration.NestedParser.TreeParser;

public class IfelseParser extends Parser{
	private TreeParser tParser;
	
	public IfelseParser() throws IOException{
		initializeSyntax();		
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
	}


}
