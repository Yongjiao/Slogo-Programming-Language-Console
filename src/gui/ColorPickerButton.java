package gui;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * Creates the button for the user to select a color from.
 * @author Andrew
 *
 */
public class ColorPickerButton extends ColorPicker{

	public ColorPickerButton(String buttonStyle, Color defaultColor){
		this.setValue(defaultColor);
		this.setStyle(buttonStyle);
	}
}
