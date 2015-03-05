package Tree;

import java.util.ArrayList;

import configuration.NestedParser.Match;
import application.CommandFactory;

/**
 * Represents a single node with one child/commands with only one parameter 
 * @author Yongjiao Yu
 *
 */

public class SingleNode extends Node{
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
		CommandFactory com =  Match.makeCommands(command, parList);
		return com.execute();
	}
	
	public void printTree(){
		System.out.print(command + " ");
		child.printTree();
	}	
	
}
