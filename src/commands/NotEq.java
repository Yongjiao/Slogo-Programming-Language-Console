package commands;

public class NotEq extends Compare{
	
	public int execute(int a, int b){
		if(super.Equal(a, b) == 1)
			return 0;
		return 1;
	}

}
