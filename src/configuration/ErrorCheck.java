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

	//non-nested command validation	
	public boolean validateInput(String in){
		String s = in.trim().toLowerCase();
		String command = s.split(" ")[0];
		System.out.println(in);
		String commandRegix = commandMap.get(command);
		if(commandRegix != null){
			//System.out.println(commandRegix);
			return s.matches(commandRegix);
			//call parser here.
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
		commandMap.put("fd", "^fd"+ regix1);
		commandMap.put("foward", "^foward" + regix1);
		commandMap.put("back","^back" +regix1);
		commandMap.put("bk", "^bk" + regix1);
		commandMap.put("towards", "^towards"+regix2);
		commandMap.put("tw", "^tw" + regix2);
		commandMap.put("setxy", "^setxy" + regix2);
		commandMap.put("sum", "^sum" + regix2);
		commandMap.put("+", "^+" + regix2);
		commandMap.put("difference","^difference"+ regix2);
		commandMap.put("-", "^-" + regix2);
		commandMap.put("product", "^product" + regix2);
		commandMap.put("*", "^*" + regix2);
		commandMap.put("quotient", "^quotient" + regix2);
		commandMap.put("remainder" , "^remainder" + regix2);
		commandMap.put("%", "^%" + regix2);
		commandMap.put("/", "^/" + regix2);
		commandMap.put("^#.*", "^#.*"+".*"); //comment: to be fixed
		commandMap.put("left","^left" +regix1);
		commandMap.put("lt","^lt" +regix1);
		commandMap.put("right","^right" +regix1);
		commandMap.put("rt","^rt" +regix1);
		commandMap.put("setheading","setheading" +regix1);
		commandMap.put("seth","^seth" +regix1);
		commandMap.put("sin","^sin" +regix1);
		commandMap.put("cos","^cos" +regix1);
		commandMap.put("tan","^tan" +regix1);
		commandMap.put("atan","^atan" +regix1);
	}

	public static void main(String[] args) {
		ErrorCheck example = new ErrorCheck();
		String s1 = "fd a";
		String s2= "sum 50 50";
		String s4 = "#.* 1"; //comment not working: to be fixed
		String s3 = "sum a b";
		String s5 = "REmainder 50 50";
		String s6 = " rt 50   ";
		String s7= "setheading 30";
		System.out.println(example.validateInput(s1));
		System.out.println(example.validateInput(s2));
		System.out.println(example.validateInput(s3));
		System.out.println(example.validateInput(s4));
		System.out.println(example.validateInput(s5));
		System.out.println(example.validateInput(s6));
		System.out.println(example.validateInput(s7));
	}	
}
