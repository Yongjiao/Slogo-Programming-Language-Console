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
			//TurtleHandler myHandler = new TurtleHandler(myGUI.getView());
			Scene scene = myGUI.initialize(stage);
			stage.setTitle("SLogo");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
