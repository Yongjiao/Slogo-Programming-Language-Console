package Tree;

import application.CommandFactory;

/**
 * superclass of all Nodes Represents a node of any type in an expression tree.
 * @author Yongjiao Yu
 *
 */

public abstract class Node {
	private final int numChild = -1;
	
	abstract public double getValue();
	abstract public void printTree();
	
	public int hasChild(){
		return numChild;
	}
	
	public CommandFactory execute(){
		return null;
	}

}

