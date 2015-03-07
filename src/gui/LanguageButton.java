package gui;


import configuration.BasicParser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * Creates the button for the user to select the language
 * @author Andrew
 *
 */
public class LanguageButton extends ComboBox<String> {
	
	private static final ObservableList<String> lANGUAGE_NAMES = FXCollections.observableArrayList();
	
	
	public LanguageButton(BasicParser p, String buttonStyle){
		lANGUAGE_NAMES.addAll(new String[] {"English", "Chinese", "French", "German", "Italian", "Japanese", 
				"Korean", "Portuguese", "Russian", "Spanish"});
		initialize(p, buttonStyle);
	}
	
	public void initialize(BasicParser p, String buttonStyle){
		this.setItems(lANGUAGE_NAMES);
		this.setStyle(buttonStyle);
		this.setValue("English");
		this.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue<? extends String> ov, String t, String t1) { 
            	p.setLanguage("resources.languages." + t1);
            }    
        });
	}
}
