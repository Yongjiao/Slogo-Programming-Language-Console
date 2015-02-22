package application;

import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GUI {
	
	private static final int NUM_BUTTONS = 5;
	private static final int PEN_COLOR_BUTTON = 0;
	private static final int BACK_COLOR_BUTTON = 1;
	private static final int COMMANDS = 2;
	private static final int TURTLE_BUTTON = 3;
	private static final int OPEN_FILE_BUTTON = 4;
	
	private static final int HBOX_SPACING = 20;
	private static final int STAGE_HEIGHT = 500;
	private static final int STAGE_WIDTH = 800;
	
	//private Button penColorButton, backColorButton, langButton, turtleButton, openFileButton;
	private TextField commandsField;
	private TableView<String> prevCommands;
	private BorderPane myView;
	private Scene myScene;
	private Button[] myButtons;
	private String[] myButtonNames;
	private ResourceBundle myLabels;
	private HBox mainHBox;
	
	// Initializes GUI
	public GUI(){
		myLabels = ResourceBundle.getBundle("buttons");
		myButtonNames = new String[] {"pencolor", 
				"backcolor", "commands", "turtleimage", "openfile"};
		myButtons = new Button[NUM_BUTTONS];
		myView = new BorderPane();
		
		/*
		 * better to initialize view, turtlehandler, etc. in GUI or in main?
		 */
	}

	public Scene initialize(Stage s){
		initializeView();
		initializeTextField();
		initializeCommandsHistory();
		initializeButtons();
		
		myScene = new Scene(myView, STAGE_WIDTH, STAGE_HEIGHT);
		return myScene;
	}
	
	
	private void initializeButtons(){
		// Creates HBox for button alignment
		mainHBox = new HBox();
		mainHBox.setSpacing(HBOX_SPACING);
		mainHBox.setAlignment(Pos.CENTER);

		// Creates buttons
		for (int i = 0; i < NUM_BUTTONS; i++){
			myButtons[i] = new Button(myLabels.getString(myButtonNames[i]));
			mainHBox.getChildren().add(myButtons[i]);
		}
		// Cannot pass in method, so event handlers have to be outside loop
		myButtons[PEN_COLOR_BUTTON].setOnMouseClicked(e -> penClicked(e));
		
		myView.setTop(mainHBox);
	}
	
	private void initializeCommandsHistory() {
		// TODO Auto-generated method stub
		
	}

	private void initializeTextField() {
		// TODO pass in string to parser?
		commandsField = new TextField();
		commandsField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				if (t.getCode() == KeyCode.ENTER){
					// TODO: check error
					// TODO: if error check is good, pass string to parser
					//prevCommands.set
					commandsField.clear();
					
				}
			}
		});
		myView.setBottom(commandsField);
	}

	private void initializeView() {
		// TODO Auto-generated method stub
		
	}
	
	private void colorPicker(){
		
	}

	private void penClicked(MouseEvent e) {
		
	}
}
