package Tree;

import java.util.ArrayList;

import application.CommandFactory;
import commands.CommandCenter;
import configuration.Match;

/**
 * Represents a single node with one child/commands with only one parameter 
 * @author Yongjiao Yu
 *
 */
public class SingleNode implements Node{
	private final int numChild = 1;
	private String command;
	private Node child;
	
	public SingleNode(String s, Node c){
		command = s;
		child = c;
	}

	@Override //return commandFactory or double?
	public double getValue() {
		ArrayList<Object> parList = new ArrayList<Object>();
		double chi = child.getValue();
		parList.add(chi);
		CommandCenter com =  CommandFactory.makeBasicCommands(command, parList);
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
