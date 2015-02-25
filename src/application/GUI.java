package application;

import java.util.ResourceBundle;

import configuration.Parser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Creates the GUI
 * @author Andrew Sun
 *
 */

public class GUI {
	
	private static final int NUM_BUTTONS = 3;
	private static final int COMMANDS = 0;
	private static final int TURTLE_BUTTON = 1;
	private static final int OPEN_FILE_BUTTON = 2;
	
	private static final int HBOX_SPACING = 20;
	private static final int STAGE_HEIGHT = 800;
	private static final int STAGE_WIDTH = 1200;
	
	private static final int VIEW_HEIGHT = 700;
	private static final int VIEW_WIDTH = 900;
	
	private TextField commandsField;
	private ListView<String> prevCommands;
	private static final ObservableList<String> myCommandsList = FXCollections.observableArrayList();
	private static final ObservableList<String> myLanguageNames = FXCollections.observableArrayList();
	private BorderPane myBorders;
	private View myView;
	private Scene myScene;
	private Button[] myButtons;
	private String[] myButtonNames;
	private ResourceBundle myLabels;
	private HBox mainHBox;
	private Parser myParser;
	
	private final ColorPicker penColor = new ColorPicker();
	private final ColorPicker backgroundColor = new ColorPicker();
	
	public GUI(){
		myLabels = ResourceBundle.getBundle("buttons");		
		myButtonNames = new String[] {"commands", "turtleimage", "openfile"};
		myLanguageNames.addAll(new String[] {"English", "Chinese", "French", "German", "Italian", "Japanese", 
				"Korean", "Portuguese", "Russian", "Spanish"});
		myButtons = new Button[NUM_BUTTONS];
		myBorders = new BorderPane();
		myParser = new Parser();
		
		// default values
		penColor.setValue(Color.BLACK);
		backgroundColor.setValue(Color.WHITE);
	}

	public Scene initialize(Stage s){
		initializeView();
		initializeTextField();
		initializeCommandsHistory();
		initializeButtons();
		
		myScene = new Scene(myBorders, STAGE_WIDTH, STAGE_HEIGHT);
		return myScene;
	}
	
	
	private void initializeButtons(){
		// Creates HBox for button alignment
		mainHBox = new HBox();
		mainHBox.setSpacing(HBOX_SPACING);
		mainHBox.setAlignment(Pos.CENTER);
		
		String buttonStyle = "-fx-font: 14 georgia; -fx-text-fill: black;  -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-border-width: 2 2 2 2; -fx-border-color: #006652; -fx-background-color: white;";
		
		// Creates ColorPicker buttons
		penColor.setStyle(buttonStyle);
		penColor.setOnAction(e -> myView.setColor(penColor.getValue()));
		backgroundColor.setStyle(buttonStyle);
		backgroundColor.setOnAction(e -> myView.setBackgroundColor(backgroundColor.getValue()));
		mainHBox.getChildren().addAll(penColor, backgroundColor);
		
		// Creates normal buttons
		for (int i = 0; i < NUM_BUTTONS; i++){
			Button b = new Button(myLabels.getString(myButtonNames[i]));
			b.setStyle(buttonStyle);
			myButtons[i] = b;
			b.setOnMousePressed(e -> mouseDown(b));
			b.setOnMouseReleased(e -> mouseUp(b));
			mainHBox.getChildren().add(b);
		}		
		
		// Creates languages buttons
		ComboBox<String> langBox = new ComboBox<String>();
		langBox.setItems(myLanguageNames);
		langBox.setStyle(buttonStyle);
		langBox.setValue("English");
		// TODO: set on changed properties
		mainHBox.getChildren().add(langBox);
		myBorders.setTop(mainHBox);
	}
	
	
	private void initializeView() {
		myView = new View(VIEW_WIDTH, VIEW_HEIGHT);	
		myBorders.setCenter(myView);
	}
	
	private void initializeCommandsHistory() {
		prevCommands = new ListView<String>(myCommandsList);
		myBorders.setRight(prevCommands);
	}

	private void initializeTextField() {
		// TODO pass in string to parser
		commandsField = new TextField();
		commandsField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				if (t.getCode() == KeyCode.ENTER){
					// TODO: check error
					// TODO: if error check is good, pass string to parser
					myCommandsList.add(commandsField.getText());
					commandsField.clear();
				}
			}
		});
		myBorders.setBottom(commandsField);
	}

	/**
	 * added button styles
	 * @author anika, edited by Andrew
	 * @param b
	 */
	private void mouseDown(Button b)
	{
		b.setStyle("-fx-font: 14 georgia; -fx-text-fill: #006652;  -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-border-width: 2 2 2 2; -fx-border-color: white; -fx-background-color: black;");
	}
	
	private void mouseUp(Button b)
	{
		b.setStyle("-fx-font: 14 georgia; -fx-text-fill: white;  -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-border-width: 2 2 2 2; -fx-border-color: #006652; -fx-background-color: black;");
	}
	
	public View getView(){
		return myView;
	}
	
}
