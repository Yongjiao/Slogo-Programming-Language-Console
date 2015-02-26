package commands;

public class Home extends Move{
	
	public Home() {
		
	}
	
	public int execute(){
		return super.GoToLocation(0, 0);
	}

}
