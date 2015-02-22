package commands;

public class Greater extends Compare{
	
	public int execute(int a, int b){
		return super.Less(b, a);
	}
	
}
