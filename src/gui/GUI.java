package gui;

import java.io.IOException;
import java.util.ResourceBundle;

import commands.UserMadeUtilities;
import configuration.BasicParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
	private static final int TURTLE_INFO_BUTTON = 2;
	
	private static final int HBOX_SPACING = 20;

	private static final int VIEW_HEIGHT = 600;
	private static final int VIEW_WIDTH = 900;
	
	private static final String HELP_PAGE = 
			"http://www.cs.duke.edu/courses/compsci308/spring15/assign/03_slogo/commands.php";
	private static final String BUTTON_STYLE = 
			"-fx-font: 14 georgia; -fx-text-fill: black;  "
			+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); "
			+ "-fx-border-width: 2 2 2 2; -fx-border-color: #006652; -fx-background-color: white;";
	
	private static final Color DEFAULT_PEN_COLOR = Color.BLACK;
	private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
	
	private ObservableList<String> myCommandsList = FXCollections.observableArrayList();

	private BorderPane myBorders;
	private LineView myLineView;
	private TurtleView myTurtleView;
	private BackgroundView myBackgroundView;
	private Button[] myButtons;
	private String[] myButtonNames;
	private ResourceBundle myLabels;
	private HBox mainHBox;
	private BasicParser myParser;
	private UserMadeUtilities myUtils = new UserMadeUtilities();
	
	
	public GUI() throws IOException{
		myLabels = ResourceBundle.getBundle("buttons");		
		myButtonNames = new String[] {"help", "turtleimage", "turtleinfo"};
		myButtons = new Button[NUM_BUTTONS];
		myBorders = new BorderPane();
		myParser = new BasicParser();
	}
	
	/**
	 * Initializes the GUI and returns a scene to the Main method.
	 * @param s
	 * @return myBorders
	 */
	public BorderPane initialize(){
		initializeView();
		initializeTextField();
		initializeCommandsHistory();
		initializeButtons();
		//Scene myScene = new Scene(myBorders, STAGE_WIDTH, STAGE_HEIGHT);
		return myBorders;
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

	/**
	 * Launches turtle image chooser
	 * @author Andrew and Anika
	 */
	private void launchTurtleImageChooser() {
		TurtleImageChooser turtleButton = new TurtleImageChooser(myTurtleView);
		try {
			turtleButton.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes color picker buttons
	 */
	private void createColorPickerButtons() {
		// Creates ColorPicker buttons; could not put setOnAction within class because Java requires the 
		// class to be instantiated before allowing creation of setOnAction method.
		ColorPickerButton penColorPicker = new ColorPickerButton(BUTTON_STYLE, DEFAULT_PEN_COLOR);
		penColorPicker.setOnAction(e -> myLineView.setColor(penColorPicker.getValue()));
		ColorPickerButton backgroundColorPicker = new ColorPickerButton(BUTTON_STYLE, DEFAULT_BACKGROUND_COLOR);
		backgroundColorPicker.setOnAction(e -> myBackgroundView.setBackgroundColor(backgroundColorPicker.getValue()));
		mainHBox.getChildren().addAll(penColorPicker, backgroundColorPicker);
	}

	/**
	 * Creates normal "on click buttons" that are passed events for what they need to do when clicked
	 */
	private void createNormalButtons() {
		// Creates normal buttons
		for (int i = 0; i < NUM_BUTTONS; i++){
			NormalButton b = new NormalButton(myLabels.getString(myButtonNames[i]), BUTTON_STYLE);
			myButtons[i] = b;
			mainHBox.getChildren().add(b);
		}	
		myButtons[HELP_BUTTON].setOnMouseClicked(e -> launchHelpPage());
		myButtons[TURTLE_BUTTON].setOnMouseClicked(e -> launchTurtleImageChooser());
		myButtons[TURTLE_INFO_BUTTON].setOnMouseClicked(e -> launchTurtleInfo());
	}

	/**
	 * Displays turtle information
	 */
	private void launchTurtleInfo() {
		Stage s = new Stage();
		VBox v = new VBox(20);
		v.getChildren().add(new Text(myTurtleView.getTurtleInfo()));
		Scene scene = new Scene(v, 200, 200);
		s.setScene(scene);
		s.show();
	}

	/**
	 * Creates the language buttons
	 */
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
		VBox infoVBox = new VBox();
		infoVBox.setSpacing(10);
		infoVBox.getChildren().addAll(new InformationList(myCommandsList, "Commands History"),
				new InformationList(myUtils.getAllVars(), "Currently Available Variables"),
				new InformationList(myUtils.getUDCommands(), "Currently Defined Commands"));
		myUtils.checkUDCommands();
		myUtils.checkVars();
		myBorders.setRight(infoVBox);
	}



	/**
	 * Initializes text field for user to enter commands
	 */
	private void initializeTextField() {
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		TextField errors = new TextField();
		errors.setEditable(false);
		vbox.getChildren().addAll(errors, new UserInputBox(myParser, myCommandsList, myUtils, errors));
		myBorders.setBottom(vbox);
	}
	
	
	/*
	 * Grabs all the views
	 */
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
