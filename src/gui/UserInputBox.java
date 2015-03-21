package gui;



import java.io.IOException;

import commands.UserMadeUtilities;

import configuration.BasicParser;
import configuration.ParserError;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * Creates the textfield for the user to input information
 * @author Andrew
 *
 */
public class UserInputBox extends TextField {
	
	private BasicParser myParser;
	
	public UserInputBox(BasicParser p, ObservableList<String> list, UserMadeUtilities myUtils, TextField errorBox){
		myParser = p;
		this.setPromptText("Enter commands here");
		this.setOnKeyPressed(e -> doInput(e, list, myUtils, errorBox));
	}

	/**
	 * Sends information to parser/errorcheck
	 * @param e
	 * @param p
	 * @param list
	 * @param myUtils
	 * @param errorBox
	 */
	private void doInput(KeyEvent e, ObservableList<String> list, UserMadeUtilities myUtils, TextField errorBox) {
		if (e.getCode() == KeyCode.ENTER) {
			try {
				myParser.parse(this.getText());
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
	
	public void setParser(BasicParser p){
		myParser = p;
	}
	
}
	
