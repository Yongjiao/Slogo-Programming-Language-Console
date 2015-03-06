package commands;

public class Home extends Move{
	
	public Home() {
		
	}
	
	public double execute(){
		return super.goToLocation(0, 0);
	}

}
