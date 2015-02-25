package commands;

public class Home extends Move{
	
	public Home() {
		
	}
	
	public void execute(){
		super.GoToLocation(0, 0);
	}

}
