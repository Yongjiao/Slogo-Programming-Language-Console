package gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Creates the background of the View.
 * @author Andrew
 *
 */
public class BackgroundView extends View {

	private static final Color DEFAULT_COLOR = Color.WHITE;
	private GraphicsContext backgroundContext;
	
	public BackgroundView(int x, int y) {
		super(x, y);
		// default background
		//backgroundContext = super.getGC();
		backgroundContext = this.getGraphicsContext2D();
		backgroundContext.setFill(DEFAULT_COLOR);
		backgroundContext.fillRect(0, 0, x, y);
	}

	public void setBackgroundColor(Color c){
		backgroundContext.setFill(c);
		backgroundContext.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
