package Tree;

import java.util.*;

import application.CommandFactory;
import commands.CommandCenter;

/**
 * Represents a binary node with two children/operator with two parameters node
 * @author Yongjiao Yu
 *
 */
public class BinNode implements Node{
	private final int numChild = 2;
	private String command;
	private Node left;
	private Node right;
	private CommandFactory myFactory;
	
	public BinNode(String s, Node l, Node r, CommandFactory cf){
		command = new String(s);
		left = l; //will this cause problem?
		right = r;
		cf = myFactory;
	}

	//needs execution which involves construct commandObject
	@Override 
	public double getValue() {
		ArrayList<Object> parList = new ArrayList<Object>();
		parList.add(left.getValue());
		parList.add(right.getValue());
		System.out.println("Binary node get evaluated is " + command + ""+ parList);
		System.out.println(myFactory);
		CommandCenter com = myFactory.makeBasicCommands(command, parList);
		return com.execute();
	}
	@Override
	public String toString(){
		StringBuilder s  = new StringBuilder();
		s.append(" " + command);
		s.append(" " + left.toString() + " " + right.toString());
		return s.toString();
	}

	@Override
	public int hasChild() {	
		return numChild;
	}
	
}
