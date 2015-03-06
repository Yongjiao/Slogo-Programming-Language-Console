package Tree;
/**
 * ConstNode represents leafNode with only constants
 * @author Yongjiao Yu
 *
 */

public class ConstNode extends Node{
	private final int numChild = 0;
	double value;	
	
	public ConstNode(double num){
		value = num;
	}
	
	
	@Override
	public double getValue() {
		return value;
	}
	

	@Override
	public String toString(){
		return " " + value;
	}
	
}
