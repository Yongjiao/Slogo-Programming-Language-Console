package gui;

import java.awt.event.KeyEvent;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;



public class UserInputBox extends TextField {
	
	public UserInputBox(Parser p, ObservableList<String> list){
		this.setOnKeyPressed(e -> doInput(e, p, list));
	}

	private void doInput(KeyEvent e, Parser p, ObservableList<String> list) {
		if (e.getCode() == KeyCode.ENTER) {
			p.parse(this.getText());
			list.add(this.getText());
			this.clear();
		}
	}
}
	
