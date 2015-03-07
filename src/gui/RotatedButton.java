package gui;


public class RotatedButton extends NormalButton{
	
	public RotatedButton(String name, String buttonStyle, int rotationAngle){
		super(name, buttonStyle);
		this.setRotate(rotationAngle);
	}
	
	
	
}
