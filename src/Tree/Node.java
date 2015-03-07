package Tree;

/**
 * superclass of all Nodes Represents a node of any type in an expression tree.
 * @author Yongjiao Yu
 *
 */
public interface Node {
	
	abstract public double getValue();
	abstract int hasChild();
	
}

