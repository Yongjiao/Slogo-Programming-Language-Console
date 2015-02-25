package application;
	
import configuration.Parser;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	
	
	@Override
	public void start(Stage stage) {
		try {
			Parser myParser = new Parser();
			GUI myGUI = new GUI();
			Scene scene = myGUI.initialize(stage);
			TurtleHandler myHandler = new TurtleHandler(myGUI.getView());
			
			stage.setTitle("SLogo");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			myHandler.moveTurtle(-200);
			myHandler.rotateTurtle(90);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
