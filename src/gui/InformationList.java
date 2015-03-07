package gui;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 * Creates lists of information to be added by GUI
 * @author Andrew
 *
 */
public class InformationList extends ListView<String>{
	
	public InformationList(ObservableList<String> list, String title){
		list.add(title);
		this.setItems(list);
	}

}
