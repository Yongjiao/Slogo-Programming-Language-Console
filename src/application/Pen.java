package application;

public class Pen {
	private int myStatus;
	
	public Pen(int status)
	{
		myStatus = status;
	}
	
	public void setStatus(int newStatus)
	{
		myStatus = newStatus;
	}
	
	public int getStatus()
	{
		return myStatus;
	}

}
