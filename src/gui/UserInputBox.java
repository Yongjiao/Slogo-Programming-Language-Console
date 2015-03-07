package gui;



import java.io.IOException;

import configuration.BasicParser;
import configuration.ParserError;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;



public class UserInputBox extends TextField {
	
	public UserInputBox(BasicParser p, ObservableList<String> list){
		this.setOnKeyPressed(e -> doInput(e, p, list));
	}

	private void doInput(KeyEvent e, BasicParser p, ObservableList<String> list) {
		if (e.getCode() == KeyCode.ENTER) {
			try {
				p.parse(this.getText());
			} catch (ParserError e1) {
				e1.getMessage(); // error message?
			} catch (IOException e1) {
				
			}
			list.add(this.getText());
			this.clear();
		}
	}
}
	
