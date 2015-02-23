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
		String[] command = new String[]{"fd", "forward", "back", "bk", "towards", "tw", "setxy", "sum", "+", "difference","-", "product","*",
				"quotient","remainder", "%", "/","#.*","left", "lf", "right", "rt", "setheading", "seth", "sin", "cos", "tan", "atan"};
		String[] regix = new String[]{ "^fd"+ regix1,"^foward" + regix1, "^back" +regix1, "^bk"+ regix1, "^towards"+regix2, "^tw" + regix2, "^setxy" + regix2,
				"^sum" + regix2, "^+" + regix2, "^difference"+ regix2, "^-" + regix2, "^product" + regix2, "^*" + regix2, "^quotient" + regix2,
				"^remainder" + regix2, "^%" + regix2, "^/" + regix2, "#//.*"+".*", "^left" +regix1,"^lt" +regix1, "^right" +regix1,"^rt" +regix1, "setheading" +regix1,
				"^seth" +regix1,"^sin" +regix1,"^cos" +regix1, "^tan" +regix1, "^atan" +regix1};
		System.out.println("what is the size difference"+ command.length + regix.length);
		for(int i=0; i < command.length; i++){
			commandMap.put(command[i],regix[i]);			
		}
	}

	public static void main(String[] args) {
		ErrorCheck example = new ErrorCheck();
		String s1 = "fd a";
		String s2= "sum 50 50";
		String s4 = "#.*1"; //comment not working: to be fixed
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
