package gui;

import javafx.scene.control.Button;

public class NormalButton extends Button{

	public NormalButton(String name, String buttonStyle){
		this.setText(name);
		this.setStyle(buttonStyle);
		this.setOnMousePressed(e -> mouseDown());
		this.setOnMouseReleased(e -> mouseUp());
	}
	
	/**
	 * added button styles
	 * @author anika, edited by Andrew
	 * @param b
	 */
	private void mouseDown()
	{
		this.setStyle("-fx-font: 14 georgia; -fx-text-fill: #CC0000;  -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) ,.5, 0.0 , 0 , 1 ); -fx-border-width: 2 2 2 2; -fx-border-color: white; -fx-background-color: black;");
	}
	
	private void mouseUp()
	{
		this.setStyle("-fx-font: 14 georgia; -fx-text-fill: black;  -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-border-width: 2 2 2 2; -fx-border-color: #006652; -fx-background-color: white;");
	}
}
