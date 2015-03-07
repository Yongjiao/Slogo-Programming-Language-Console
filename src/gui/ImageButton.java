package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Creates a button with an image as its graphic
 * @author Andrew
 *
 */
public class ImageButton extends Button{
	

	public ImageButton(String name, int locX, int locY, Image i, EventHandler<ActionEvent> event){
		this.setGraphic(new ImageView(i));
		this.setButtonProperties(this, locX, locY, i, event);
	}
	
	private void setButtonProperties(Button but, int xLoc, int yLoc, Image actionImage, EventHandler<ActionEvent> event)
	{
		but.setLayoutX(xLoc);
		but.setLayoutY(yLoc);
		but.setOnAction(event);
		but.setContentDisplay(ContentDisplay.TOP);
	}
	
	
}
