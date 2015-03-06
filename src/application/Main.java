package application;

import gui.GUI;
import java.util.ArrayList;

import commands.Backward;
import configuration.Parser;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	
	
	@Override
	public void start(Stage stage) {
		try {
			//Parser myParser = new Parser();
			GUI myGUI = new GUI();
			Scene scene = myGUI.initialize(stage);
			TurtleHandler myHandler = new TurtleHandler(myGUI.getLineView(), myGUI.getTurtleView());		
			CommandFactory c = new CommandFactory();
			c.setTurtleHandler(myHandler);
			
			ArrayList<Object> l = new ArrayList<Object>();
			l.add(50);
			Backward f = new Backward(l);
			f.execute();
			System.out.println("made new th");
			stage.setTitle("SLogo");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
//			
//			myHandler.moveTurtle(10);
//			myHandler.rotateTurtle(30);
//			myHandler.moveTurtle(10);
//			myHandler.rotateTurtle(30);
//			myHandler.moveTurtle(10);
//			myHandler.rotateTurtle(30);
//			System.out.println("move 10");
//			myHandler.moveTurtle(10);
//			myHandler.rotateTurtle(30);
//			
//			System.out.println("change to  100 100");
//			Point2D loc = new Point2D(100, 100);
//			myHandler.changeLocationOfTurtle(loc);
//			myHandler.showTurtle(1);
//			myHandler.setPenStatus(0); // FIXED :D
//			System.out.println("move 200");
//			myHandler.moveTurtle(200);
//			System.out.println("move 900");
//			myHandler.moveTurtle(900);
//			myHandler.clearScreen();
//			System.out.println("END END END");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
