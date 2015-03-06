package gui;

import java.util.ResourceBundle;

import configuration.NestedParser.Parser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class LanguageButton extends ComboBox<String> {
	
	private static final ObservableList<String> lANGUAGE_NAMES = FXCollections.observableArrayList();
	
	
	public LanguageButton(Parser p, String buttonStyle){
		lANGUAGE_NAMES.addAll(new String[] {"English", "Chinese", "French", "German", "Italian", "Japanese", 
				"Korean", "Portuguese", "Russian", "Spanish"});
		initialize(p, buttonStyle);
	}
	
	public void initialize(Parser p, String buttonStyle){
		this.setItems(lANGUAGE_NAMES);
		this.setStyle(buttonStyle);
		this.setValue("English");
		this.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue<? extends String> ov, String t, String t1) { 
            	ResourceBundle myCurrentBundle = ResourceBundle.getBundle("resources.languages." + t1);
            	p.changeLanguage(myCurrentBundle);
            }    
        });
	}
}
