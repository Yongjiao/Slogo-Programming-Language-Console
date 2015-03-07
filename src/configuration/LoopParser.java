package configuration;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import Tree.Node;

public class LoopParser extends Parser{
	
	@Override
	protected double parse(String s) throws ParserError, IOException {
		return 0;
	}
	private int fetchNumericExpr(Queue<String> qu) throws ParserError{
		double result = 0;
		Tree node = buildTree(qu);
		if(node.hasChild() != 0)
			throw new ParserError("see" + qu.poll() + "expected a numeric expression here!");
		return result;
	}
	/*
	private int fetchConstant(Queue<String> qu) throws ParserError{
		if(!isConstant(qu.peek()))
			throw new ParserError("see" + qu.poll() + "expected number here!");
		return Integer.parseInt(qu.poll());
	}
	*/
	private double parseFor(int start, int end, int inc, Queue<String> qu) throws ParserError{
		Queue<String> temp = new LinkedList<>(qu);
		double result = -1;
		for(int i = start; i <= end; i++){
			while(!isEnd(temp) && !isListEnd(temp.peek())){
				Node n = buildTree(temp, localVar, i); 
				System.out.println("Tree parsed is " + n);
				result = n.getValue();		//execute tree for # iterations	
				System.out.println(result);
				}
			if(i < end)		temp = new LinkedList<>(qu);
			}
		while(qu != temp)	skip(qu); //update command qu
		localVar = "";
		return result;
	}

	
	
}
