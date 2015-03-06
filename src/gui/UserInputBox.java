package gui;

import configuration.BasicParser;


public class UserInputBox extends TextField {
	
	public UserInputBox(BasicParser p, ObservableList<String> list){
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
	
