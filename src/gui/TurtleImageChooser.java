package gui;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TurtleImageChooser extends Application {
	
	private static final int SCENE_WIDTH = 500;
	private static final int SCENE_HEIGHT = 500;
	private static final int BOTTOM_BUTTON_X = 200;
	private static final int BOTTOM_BUTTON_Y = 400;
	private static final int BUTTON_IMAGE_WIDTH = 35*3;
	private static final int BUTTON_IMAGE_HEIGHT = 40*3;

	
	private Group myGroup;
	private TurtleView myTurtleView;

	
	public TurtleImageChooser(TurtleView turtleview){
		myTurtleView = turtleview;
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
	
	@Override
	public void start(Stage stage) throws Exception {
		myGroup = new Group();
		Scene s = new Scene(myGroup, SCENE_WIDTH, SCENE_HEIGHT);
		stage.setScene(s);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.setTitle("Choose your turtle:");
		stage.show();
		initialize();
		
	}
	
	private void initialize(){
		Button btnFile = new Button("Choose from file");
		btnFile.setLayoutX(BOTTOM_BUTTON_X);
		btnFile.setLayoutY(BOTTOM_BUTTON_Y);
		
		Image image1 = new Image(getClass().getResourceAsStream("/resources/rsz_turtle.png"));
		Image image2 = new Image(getClass().getResourceAsStream("/resources/anotherTurtle.png"), BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT, false, false);
		Image image3 = new Image(getClass().getResourceAsStream("/resources/tribalTurtle.png"), BUTTON_IMAGE_WIDTH, BUTTON_IMAGE_HEIGHT, false, false);
		
		ImageButton buttonChoice1 = new ImageButton("The Hawaiian", 40, 40, image1, e -> myTurtleView.updateTurtleImage(image1));
		ImageButton buttonChoice2 = new ImageButton("The Undivided", 140, 40, image2,  e -> myTurtleView.updateTurtleImage(image2));
		ImageButton buttonChoice3 = new ImageButton("The Tattooed", 300, 40, image3,  e -> myTurtleView.updateTurtleImage(image3));
		
		btnFile.setOnAction(e -> this.chooseTurtleImage());

		myGroup.getChildren().addAll(btnFile, buttonChoice1, buttonChoice2, buttonChoice3);
	}
}
