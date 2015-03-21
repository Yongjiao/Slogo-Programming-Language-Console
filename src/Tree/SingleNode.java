package Tree;

import java.util.ArrayList;

import application.CommandFactory;
import commands.CommandCenter;
import configuration.Util;

/**
 * Represents a single node with one child/commands with only one parameter 
 * @author Yongjiao Yu
 *
 */
public class SingleNode implements Node{
	private final int numChild = 1;
	private String command;
	private Node child;
	private CommandFactory myFactory;
	
	public SingleNode(String s, Node c, CommandFactory cf){
		command = s;
		child = c;
		myFactory = cf;
	}

	@Override 
	public double getValue() {
		ArrayList<Object> parList = new ArrayList<Object>();
		double chi = child.getValue();
		parList.add(chi);
		CommandCenter com =  myFactory.makeBasicCommands(command, parList);
		return com.execute();
	}
	
	@Override
	public String toString(){
		StringBuilder s  = new StringBuilder();
		s.append(" " + command +" " + child.toString());
		return s.toString();
	}

	@Override
	public int hasChild() {
		return numChild;
	}
	
}
