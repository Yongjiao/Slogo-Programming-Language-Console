package commands;

import application.CommandFactory;

/**
 * Superclass for basic arithmetic subclasses to extend.
 * 
 * @author TheSweatshopKid
 *
 */

public abstract class Arithmetic extends CommandFactory{
	
	/**
	 * Adds a and b
	 * @param a integer to be added to b
	 * @param b integer to be added to a
	 * @return sum of a and b
	 */
	public int add(int a, int b){
		return a + b;
	}
	
	/**
	 * Multiplies a by b
	 * @param a integer to be multiplied
	 * @param b integer to be multiplied
	 * @return product of a and b
	 */
	public int mult(int a, int b){
		return a * b;
	}
	
	/**
	 * divides a by b
	 * @param a integer dividend
	 * @param b integer divisor
	 * @return quotient of a and b
	 */
	public int div(int a, int b){
		return a/b;
	}
	
	/**
	 * gives remainder of a divided by b
	 * @param a integer dividend
	 * @param b integer divisor
	 * @return remainder of the division
	 */
	public int remainder(int a, int b) {
		Integer c = div(a, b);
		return a - (b * c);
	}
	
}