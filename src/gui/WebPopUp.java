package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebPopUp extends Application{
	
	private static final int PAGE_WIDTH = 800;
	private static final int PAGE_HEIGHT = 600;
	
	private String myWebPage;
		
	public WebPopUp(String webpage){
		myWebPage = webpage;
	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Scene scene = new Scene(new Browser(), PAGE_WIDTH, PAGE_HEIGHT, Color.web("#666970"));
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
	        webEngine.load(myWebPage);
	        getChildren().add(browser);
	 
	    }
	}
}
