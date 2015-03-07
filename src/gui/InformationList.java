package gui;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class InformationList extends ListView<String>{
	
	public InformationList(ObservableList<String> list, String title){
		list.add(title);
		this.setItems(list);
	}

}
