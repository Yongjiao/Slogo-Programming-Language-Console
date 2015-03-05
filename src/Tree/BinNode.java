package Tree;

import java.util.*;

import application.CommandFactory;
import configuration.CommandMaker;

/**
 * Represents a binary node with two children/operator with two parameters node
 * @author Yongjiao Yu
 *
 */

public class BinNode extends Node{
	private final int numChild = 2;
	private String command;
	private Node left;
	private Node right;
	
	public BinNode(String s, Node l, Node r){
		command = new String(s);
		left = l; //will this cause problem?
		right = r;
	}

	//needs execution which involves construct commandObject
	@Override 
	public double getValue() {
		ArrayList<Object> parList = new ArrayList<Object>();
		parList.add(left.getValue());
		parList.add(right.getValue());
		CommandFactory com = CommandMaker.makeBasicCommands(command, parList);
		return com.execute();
	}
	
	public void printTree(){
		System.out.print(command + " ");
		left.printTree();
		right.printTree();
	}
}
