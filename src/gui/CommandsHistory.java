package gui;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class CommandsHistory extends ListView<String>{
	
	public static final String HISTORY_TITLE = "Previous Commands";
	
	public CommandsHistory(ObservableList<String> list){
		list.add(HISTORY_TITLE);
		this.setItems(list);
	}
}
