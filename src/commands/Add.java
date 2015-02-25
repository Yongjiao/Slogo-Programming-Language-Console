package commands;

/**
 * Command Subclass for addition
 * 
 * @author TheSweatshopKid
 *
 */

public class Add extends Arithmetic{
	
	public Add(){
	}
	
	public void execute(Object[] o){
		super.add(o);
	}
	
}
