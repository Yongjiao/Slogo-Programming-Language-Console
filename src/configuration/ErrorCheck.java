package configuration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;

public class ErrorCheck {
	/*  Other approach
	private String regix_basic = "^(FD|FORWARD|BACK|BK|)\\s+\\d+";
	private String regix_arithematic = "^(TOWARDS|SETXY|SUM|+|DIFFERENCE|-|PRODUCT|*|QUOTIENT|/|REMAINDER|%)\\s+\\d+\\s+\\d+"; //+ match one or more
	private String regix_boolean = "^(LESS?|LESSP|GREATER?|GREATERP|EQUAL? |EQUALP|NOTEQUAL?|NOTEQUALP)";
	private String regix_comment = "^#.*";
	private String regix_degree = "^(LEFT|LT|RIGHT|RT|SETHEADING|SETH|SIN|COS|TAN|ATAN)\\s+\\d+"; // degrees>360			
	private ArrayList <String> regixList = new ArrayList<String>();
	*/
	private HashMap<String, String> commandMap; //what if new commands added

		
	public boolean checkFormat(String s){
		s.trim();//s can start or end with spaces
		String[] command = s.split(" ");	
		if(!commandMap.containsKey(command[0].toLowerCase()))		return false;
		String commandRegix = commandMap.get(commandMap);
		//remove trailling and leading spaces 
		if(s.matches(commandRegix)){
			//call parser here.
			return true;
		}
		return false;
	}


	//parse after error check
	private String getStringNoSpaces(String s) {
		return s.replaceAll("\\s+", "");
	}

	public ErrorCheck(){
		commandMap = new HashMap<String,String>();
		String regix1 = "\\s\\d+"; //one parameter only exactly one space between parameters
		String regix2 = "\\s\\d+\\s\\d+";	//two parameter
		commandMap.put("fd", "^(fd)"+ regix1);
		commandMap.put("foward", "^(foward)" + regix1);
		commandMap.put("back","^back" +regix1);
		commandMap.put("bk", "^bk" + regix1);
		commandMap.put("towards", "towards"+regix2);
		commandMap.put("tw", "tw" + regix2);
		commandMap.put("setxy", "setxy" + regix2);
		commandMap.put("sum", "sum" + regix2);
		commandMap.put("+", "+" + regix2);
		commandMap.put("difference","difference"+ regix2);
		commandMap.put("-", "-" + regix2);
		commandMap.put("product", "product" + regix2);
		commandMap.put("*", "*" + regix2);
		commandMap.put("quotient", "quotient" + regix2);
		commandMap.put("remainder" , "remainder" + regix2);
		commandMap.put("%", "%" + regix2);
		commandMap.put("/", "/" + regix2);
		commandMap.put("^#.*", "\\."); //comment
		commandMap.put("left","left" +regix1);
		commandMap.put("lt","left" +regix1);
		commandMap.put("right","right" +regix1);
		commandMap.put("rt","rt" +regix1);
		commandMap.put("setheading","setheading" +regix1);
		commandMap.put("seth","seth" +regix1);
		commandMap.put("sin","sin" +regix1);
		commandMap.put("cos","cos" +regix1);
		commandMap.put("tan","tan" +regix1);
		commandMap.put("atan","atan" +regix1);
	}
}
