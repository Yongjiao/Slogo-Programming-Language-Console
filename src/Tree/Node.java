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
	
	public int hasChild(){
		return numChild;
	}
	
}

