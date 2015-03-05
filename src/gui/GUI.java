package gui;

import java.io.File;
import java.util.ResourceBundle;

import configuration.Parser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
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
	
	private static final int NUM_BUTTONS = 2;
	private static final int HELP_BUTTON = 0;
	private static final int TURTLE_BUTTON = 1;
	
	private static final int HBOX_SPACING = 20;
	private static final int STAGE_HEIGHT = 800;
	private static final int STAGE_WIDTH = 1200;
	
	private static final int VIEW_HEIGHT = 700;
	private static final int VIEW_WIDTH = 900;
	
	private static final String HELP_PAGE = 
			"http://www.cs.duke.edu/courses/compsci308/spring15/assign/03_slogo/commands.php";
	private static final String BUTTON_STYLE = 
			"-fx-font: 14 georgia; -fx-text-fill: black;  "
			+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); "
			+ "-fx-border-width: 2 2 2 2; -fx-border-color: #006652; -fx-background-color: white;";
	
	private static final Color DEFAULT_PEN_COLOR = Color.BLACK;
	private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
	
	private static final ObservableList<String> myCommandsList = FXCollections.observableArrayList();
	private BorderPane myBorders;
	private LineView myLineView;
	private TurtleView myTurtleView;
	private BackgroundView myBackgroundView;
	private Button[] myButtons;
	private String[] myButtonNames;
	private ResourceBundle myLabels;
	private HBox mainHBox;
	private Parser myParser;
	
	
	public GUI(){
		myLabels = ResourceBundle.getBundle("buttons");		
		myButtonNames = new String[] {"help", "turtleimage"};
		myButtons = new Button[NUM_BUTTONS];
		myBorders = new BorderPane();
		myParser = new Parser();
	}
	
	/**
	 * Initializes the GUI and returns a scene to the Main method.
	 * @param s
	 * @return Scene
	 */
	public Scene initialize(Stage s){
		initializeView();
		initializeTextField();
		initializeCommandsHistory();
		initializeButtons();
		Scene myScene = new Scene(myBorders, STAGE_WIDTH, STAGE_HEIGHT);
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
			
		createColorPickerButtons();	
		createNormalButtons();		
		createLanguageButtons();
		myBorders.setTop(mainHBox);
	}

	private void createColorPickerButtons() {
		// Creates ColorPicker buttons; could not put setOnAction within class because Java requires the 
		// class to be instantiated before allowing creation of setOnAction method.
		ColorPickerButton penColorPicker = new ColorPickerButton(BUTTON_STYLE, DEFAULT_PEN_COLOR);
		penColorPicker.setOnAction(e -> myLineView.setColor(penColorPicker.getValue()));
		ColorPickerButton backgroundColorPicker = new ColorPickerButton(BUTTON_STYLE, DEFAULT_BACKGROUND_COLOR);
		backgroundColorPicker.setOnAction(e -> myBackgroundView.setBackgroundColor(backgroundColorPicker.getValue()));
		mainHBox.getChildren().addAll(penColorPicker, backgroundColorPicker);
	}

	private void createNormalButtons() {
		// Creates normal buttons
		for (int i = 0; i < NUM_BUTTONS; i++){
			NormalButton b = new NormalButton(myLabels.getString(myButtonNames[i]), BUTTON_STYLE);
			myButtons[i] = b;
			mainHBox.getChildren().add(b);
		}	
		myButtons[TURTLE_BUTTON].setOnMouseClicked(e -> chooseTurtleImage());
		myButtons[HELP_BUTTON].setOnMouseClicked(e -> launchHelpPage());
	}

	private void createLanguageButtons() {
		mainHBox.getChildren().add(new LanguageButton(myParser, BUTTON_STYLE));
	}
	
	/**
	 * Launches a help page to go to SLogo Help Page
	 */
	private void launchHelpPage() {
		WebPopUp helpPage = new WebPopUp(HELP_PAGE);
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
		File myTurtleFilePath = fileChooser.showOpenDialog(null);
		myTurtleView.updateTurtleImage(myTurtleFilePath);
	}

	/**
	 * Initializes view
	 */
	private void initializeView() {
		System.out.println(" gui initialize view");
		StackPane viewStack = new StackPane();
		myBackgroundView = new BackgroundView(VIEW_WIDTH, VIEW_HEIGHT);
		myLineView = new LineView(VIEW_WIDTH, VIEW_HEIGHT);
		myTurtleView = new TurtleView(VIEW_WIDTH, VIEW_HEIGHT);
		viewStack.getChildren().addAll(myBackgroundView, myLineView, myTurtleView);
		myBorders.setCenter(viewStack);
	}
	
	/**
	 * Initializes commands history
	 */
	private void initializeCommandsHistory() {
		myBorders.setRight(new CommandsHistory(myCommandsList));
	}

	/**
	 * Initializes text field for user to enter commands
	 */
	private void initializeTextField() {
		myBorders.setBottom(new UserInputBox(myParser, myCommandsList));
	}
	
	public BackgroundView getBackgroundView(){
		return myBackgroundView;
	}
	
	public LineView getLineView(){
		return myLineView;
	}
	
	public TurtleView getTurtleView(){
		return myTurtleView;
	}
	
}
