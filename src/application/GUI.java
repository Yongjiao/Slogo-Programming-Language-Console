package application;

import java.io.File;
import java.io.InputStream;
import java.util.ResourceBundle;
import configuration.Parser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Creates the GUI
 * @author Andrew Sun
 *
 */

public class GUI {
	
	private static final int NUM_BUTTONS = 3;
	private static final int HELP_BUTTON = 0;
	private static final int TURTLE_BUTTON = 1;
	//private static final int OPEN_FILE_BUTTON = 2;
	
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
	private ResourceBundle myLabels, myCurrentBundle;
	private HBox mainHBox;
	private Parser myParser;
	private File myTurtleFilePath;
	
	private final ColorPicker penColor = new ColorPicker();
	private final ColorPicker backgroundColor = new ColorPicker();
	
	public GUI(){
		myLabels = ResourceBundle.getBundle("buttons");		
		myButtonNames = new String[] {"help", "turtleimage", "openfile"};
		myLanguageNames.addAll(new String[] {"English", "Chinese", "French", "German", "Italian", "Japanese", 
				"Korean", "Portuguese", "Russian", "Spanish"});
		myButtons = new Button[NUM_BUTTONS];
		myBorders = new BorderPane();
		myParser = new Parser();
		
		// default values
		penColor.setValue(Color.BLACK);
		backgroundColor.setValue(Color.WHITE);
	}
	
	/**
	 * Initializes the GUI and returns a scene to the Main method.
	 * @param s
	 * @return Scene
	 */
	public Scene initialize(Stage s){
		System.out.println(" gui initialize");
		initializeView();
		initializeTextField();
		initializeCommandsHistory();
		initializeButtons();
		myScene = new Scene(myBorders, STAGE_WIDTH, STAGE_HEIGHT);
		
		return myScene;
	}
	
	/**
	 * Creates the Color Buttons, normal buttons, and language selection buttons
	 */
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
		myButtons[TURTLE_BUTTON].setOnMouseClicked(e -> chooseTurtleImage());
		myButtons[HELP_BUTTON].setOnMouseClicked(e -> launchHelpPage());
		
		// Creates languages buttons
		ComboBox<String> langBox = new ComboBox<String>();
		langBox.setItems(myLanguageNames);
		langBox.setStyle(buttonStyle);
		langBox.setValue("English");
		// TODO: set on changed properties
		langBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue<? extends String> ov, String t, String t1) { 
            	myCurrentBundle = ResourceBundle.getBundle("resources.languages." + t1);
            	myParser.changeLanguage(myCurrentBundle);
            }    
        });
		mainHBox.getChildren().add(langBox);
		myBorders.setTop(mainHBox);
	}
	
	/**
	 * Launches a help page to go to SLogo Help Page
	 */
	private void launchHelpPage() {
		WebPopUp helpPage = new WebPopUp();
		try {
			helpPage.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prompts user to choose an image file.
	 */
	private void chooseTurtleImage() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(jpgFilter, pngFilter);
		myTurtleFilePath = fileChooser.showOpenDialog(null);
		myView.updateTurtleImage(myTurtleFilePath);
	}

	/**
	 * Initializes view
	 */
	private void initializeView() {
		System.out.println(" gui initialize view");
		myView = new View(VIEW_WIDTH, VIEW_HEIGHT);	
		myBorders.setCenter(myView);
	}
	
	/**
	 * Initializes commands history
	 */
	private void initializeCommandsHistory() {
		System.out.println(" gui initialize ch");

		prevCommands = new ListView<String>(myCommandsList);
		myBorders.setRight(prevCommands);
	}

	/**
	 * Initializes text field for user to enter commands
	 */
	private void initializeTextField() {
		System.out.println(" gui initialize tf");

		// TODO pass in string to parser
		commandsField = new TextField();
		commandsField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				if (t.getCode() == KeyCode.ENTER){
					// TODO: check error
					myParser.parse(commandsField.getText());
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
		b.setStyle("-fx-font: 14 georgia; -fx-text-fill: #CC0000;  -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) ,.5, 0.0 , 0 , 1 ); -fx-border-width: 2 2 2 2; -fx-border-color: white; -fx-background-color: black;");
	}
	
	private void mouseUp(Button b)
	{
		b.setStyle("-fx-font: 14 georgia; -fx-text-fill: black;  -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-border-width: 2 2 2 2; -fx-border-color: #006652; -fx-background-color: white;");
	}
	
	public View getView(){
		return myView;
	}
	
}
