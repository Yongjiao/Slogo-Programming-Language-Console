package application;

import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
	private ColorPicker penColor = new ColorPicker();
	private ColorPicker backgroundColor = new ColorPicker();
	
	private TurtleHandler handler; // TODO: TO BE REMOVED - FIX DESIGN
	
	// Initializes GUI
	public GUI(){
		myLabels = ResourceBundle.getBundle("buttons");
		myButtonNames = new String[] {"pencolor", 
				"backcolor", "commands", "turtleimage", "openfile"};
		myButtons = new Button[NUM_BUTTONS];
		myView = new BorderPane();
		
		// Creates HBox for button alignment
		mainHBox = new HBox();
		mainHBox.setSpacing(HBOX_SPACING);
		mainHBox.setAlignment(Pos.CENTER);
		
		myView.setTop(mainHBox);
		
		penColor.setValue(Color.BLACK);
		backgroundColor.setValue(Color.WHITE);
		
		mainHBox.getChildren().addAll(penColor, backgroundColor);
		
		initializeButtons();
	}
	
	public Scene initialize(Stage s){
		myScene = new Scene(myView, STAGE_WIDTH, STAGE_HEIGHT);
		return myScene;
	}
	
	
	private void initializeButtons(){
		for (int i = 0; i < NUM_BUTTONS; i++){
			myButtons[i] = new Button(myLabels.getString(myButtonNames[i]));
		}
		// Cannot pass in method, so event handlers have to be outside loop
		myButtons[PEN_COLOR_BUTTON].setOnMouseClicked(e -> changePenColor());
		myButtons[BACK_COLOR_BUTTON].setOnMouseClicked(e -> changeBackgroundColor());
		
	}
	
	private void changePenColor(){
		this.penColor.setOnAction(e -> handler.setPenColor(penColor.getValue()));	
	}
	
	private void changeBackgroundColor(){
		this.backgroundColor.setOnAction(e -> handler.setPenColor(backgroundColor.getValue()));	
	}

	
}
