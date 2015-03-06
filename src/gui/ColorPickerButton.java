package gui;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class ColorPickerButton extends ColorPicker{

	public ColorPickerButton(String buttonStyle, Color defaultColor){
		this.setValue(defaultColor);
		this.setStyle(buttonStyle);
	}
}
