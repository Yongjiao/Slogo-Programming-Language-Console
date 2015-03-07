package application;

import gui.GUI;






import java.util.ArrayList;

import commands.CommandCenter;
import commands.viewCommands.ViewCommands;
import commands.viewCommands.turtleCommands.Backward;
import commands.viewCommands.turtleCommands.TurtleCommands;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
	private static final int NUM_WORKSPACES = 3;

	private ArrayList<GUI> myGUIs = new ArrayList<>();
	
	@Override
	public void start(Stage stage) {
		System.out.println("hello");
		try {
			//Parser myParser = new Parser();
			// BELOW COULD BE REFACTORED INTO NEW WORKSPACE CLASS??
			TabPane myTabs = new TabPane();
			Pen myPen = new Pen();
			for (int i = 1; i <= NUM_WORKSPACES; i++){
				Tab tab = new Tab();
				tab.setText("Workspace " + i);
				
				GUI myGUI = new GUI();
				BorderPane myBorderPane = myGUI.initialize();
				myGUIs.add(myGUI);
				
				PenHandler myPenHandler = new PenHandler(myGUI.getLineView());
				ViewHandler myViewHandler = new ViewHandler(myGUI.getLineView(), myGUI.getTurtleView(), myGUI.getBackgroundView(), myPenHandler);
				ViewCommands viewCommands = new ViewCommands(myPenHandler);
				viewCommands.setPenHandler(myPenHandler);
				TurtleCommands turtleCommands = new TurtleCommands();
				turtleCommands.setViewHandler(myViewHandler);
				
				tab.setContent(myBorderPane);
				myTabs.getTabs().add(tab);
				
			}
			
			
			
			
			
			
//			myHBox = new HBox();
//			VBox myVBox = new VBox();
//			myVBox.setSpacing(200);
//			
//			for (int i = 0; i < NUM_WORKSPACES; i++){
//				GUI myGUI = new GUI();
//				BorderPane myBorderPane = myGUI.initialize();
//				RotatedButton b = new RotatedButton("Workspace " + i, BUTTON_STYLE, -90);
//				myCurrentWorkspace = i;
//				
//				b.setOnMouseClicked(e -> workspaceClicked(myBorderPane, myCurrentWorkspace));
//				myVBox.getChildren().add(b);
//				
//				TurtleHandler myHandler = new TurtleHandler(myGUI.getLineView(), myGUI.getTurtleView());
//				CommandFactory c = new CommandFactory();
//				c.setTurtleHandler(myHandler);
//				myGUIs.add(myBorderPane);
//			}
//			
////			myCurrentWorkspace = 0;
//			myHBox.getChildren().addAll(myVBox, myGUIs.get(0));
////			for (int i = NUM_WORKSPACES-1; i >=0; i--){
////				myHBox.getChildren().add(myGUIs.get(i));
////			}
			
			Scene scene = new Scene(myTabs, 1200, 800);

		
			
//			ArrayList<Object> l = new ArrayList<Object>();
//			l.add(50);
//			Backward f = new Backward(l);
//			f.execute();
//			System.out.println("made new th");
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
	
//	private void workspaceClicked(BorderPane bp, int i) {
//		myGUIs.get(myCurrentWorkspace).setVisible(false);
//		myHBox.getChildren().remove(myGUIs.get(myCurrentWorkspace));
//		if (!myHBox.getChildren().contains(myGUIs.get(i))){
//			myHBox.getChildren().add(myGUIs.get(i));
//		}
//		myGUIs.get(i).setVisible(true);
//		myCurrentWorkspace = i;
//		System.out.println("Currently in workspace " + i);
//	}

	public static void main(String[] args) {
		launch(args);
	}
}
