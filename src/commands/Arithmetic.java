package commands;

import application.CommandFactory;

public abstract class Arithmetic extends CommandFactory{
	
	public int add(int a, int b){
		return (a + b);
	}
	
	public int mult(int a, int b){
		return (a * b);
	}
	
	public int div(int a, int b){
		return (a / b);
	}
	
}