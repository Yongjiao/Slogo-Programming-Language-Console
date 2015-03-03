package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebPopUp extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Scene scene = new Scene(new Browser(), 800, 600, Color.web("#666970"));
			stage.setTitle("Help Page");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	class Browser extends Region {
		 
	    final WebView browser = new WebView();
	    final WebEngine webEngine = browser.getEngine();
	    public Browser() {
	        getStyleClass().add("browser");
	        webEngine.load("http://www.cs.duke.edu/courses/compsci308/spring15/assign/03_slogo/commands.php");
	        getChildren().add(browser);
	 
	    }
	}
}
