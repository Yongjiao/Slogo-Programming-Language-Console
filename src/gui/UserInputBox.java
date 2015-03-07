package gui;



import java.io.IOException;

import commands.UserMadeUtilities;

import configuration.BasicParser;
import configuration.ParserError;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;



public class UserInputBox extends TextField {
	
	
	public UserInputBox(BasicParser p, ObservableList<String> list, UserMadeUtilities myUtils, TextField errorBox){
		this.setPromptText("Enter commands here");
		this.setOnKeyPressed(e -> doInput(e, p, list, myUtils, errorBox));
	}

	private void doInput(KeyEvent e, BasicParser p, ObservableList<String> list, UserMadeUtilities myUtils, TextField errorBox) {
		if (e.getCode() == KeyCode.ENTER) {
			try {
				p.parse(this.getText());
			} catch (ParserError e1) {
				errorBox.setText(e1.getMessage()); // error message?
			} catch (IOException e1) {
				
			}
			list.add(this.getText());
			myUtils.checkUDCommands();
			myUtils.checkVars();
			this.clear();
		}
	}
	
	
}
	
