package application;
	
import configuration.Parser;
import javafx.application.Application;
import javafx.geometry.Point2D;
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
			myHandler.moveTurtle(10);
			myHandler.rotateTurtle(30);
			myHandler.moveTurtle(10);
			myHandler.rotateTurtle(30);
			myHandler.moveTurtle(10);
			myHandler.rotateTurtle(30);
			System.out.println("move 10");
			myHandler.moveTurtle(10);
			myHandler.rotateTurtle(30);
			
			System.out.println("change to  100 100");
			Point2D loc = new Point2D(100, 100);
			myHandler.changeLocationOfTurtle(loc);
			System.out.println("showing");
			myHandler.showTurtle(1);
			System.out.println("setting pen status");
		//	myHandler.setPenStatus(0); // FIX
			System.out.println("move 200");
			myHandler.moveTurtle(200);
			System.out.println("move 900");
			myHandler.moveTurtle(900);
			myHandler.clearScreen();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
