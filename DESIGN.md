
## SLogo Design Group 16

####Written by: Andrew Sun, Anika Radiya-Dixit, Yongjiao Yu
* Note: Richard did not work on this document or meet with the team because he had "a paper to write". We can see now which class his priorities are now...


### **Introduction**
The project is to create a basic and agile framework for a simplified Slogo game. The goal is to design the framework so that the program is adaptive to changes when additional turtle commands and GUI components are added in the future. We wish to make our code as reusable as possible, and to keep as much of the components closed as we could. By dividing the project by teams of front-end and back-end, the communication will be solely based on the API that both parties both agreed upon. Our API specifies the separation of front end and back end clearly by passing commands to parser in back-end from UI, and list of line information (coordinates) and orientation to be drawn in UI from back-end. Parsers will be divided into Mathparser and Commandparser, intermediate results will also be passed around for more complex commands. Those parameters remain open within either classes in UI or classes in backend, while everything else should remain relatively closed. There may be situations where we need to pass different parameters within “small” classes with specific functionality, and those will also be open. We will have classes that define the basic behaviors like forward, backward, loops and math operations, but also classes for syntax error checking or handling user-defined behaviors. This way, the structures remain clear to allow for additional flexibility and clarity. 

### **User Interface**

The program’s UI will be laid out as shown below. There will be drop down menu for pen/background color selection,  language, turtle image, helper page on the top. A file chooser to take in files with commands to run or load previously saved points. Ideally, there will also be an option for saving the current progress of the game to a file, so that the user will be able to continue with where he or she left off. To the far right, there will be three sections for previous commands, variables and current user-defined commands. To the lower bottom, a Textfield for commands will take in correctly formatted commands users want to execute.

All these items will be designed through JavaFX SceneBuilder. Through SceneBuilder, we will obtain both the Controller and a .css file, as discussed in class. 

The language selection will utilize .properties files as discussed in class. The three sections for previous commands, variables and current user-defined commands will all be clickable to potentially display what the code does or just simply executes the code.

The Turtle and the drawn lines will be shown in a separate View class, which is simply mounted onto the GUI. The GUI does not actually manage this View class, but is positioned inside the GUI.

The TextField box is where all the magic happens. When the "Enter" button is clicked or "Enter" is pressed on the keyboard, the following will happen:

* First check the inputted commands for errors through an error checking class.
* If there are no errors, we will:
	* Add the command to the previous commands display list
	* Parse the input and call our Commands class to execute the command.

** Add pic here

### **Design Details**





### **API Example Code**

```
package application;

public class Forward extends Move{
	public Forward(){
	}
	public void execute(int i){
		super.forward(i);
	}
}

// continues to

package application;

public abstract class Move extends CommandFactory{

	public int forward(int dist){
		
		myTurtleHandler.moveTurtle(dist, 0);	
		return dist;
	}
	
	// TODO : implement other move methods
}


// continues to

package application;

public class CommandFactory {

	protected TurtleHandler myTurtleHandler;
	
	public CommandFactory(){
		
	}
	
	public void setTurtleHandler(TurtleHandler t){
		myTurtleHandler = t;
	}
	
	// TODO: implement CommandFactory methods
	
}

// Continues to

package application;

import java.awt.Point;

public class TurtleHandler {
	
	private View myView;
	private Turtle myTurtle;
	
	public TurtleHandler(View v, Turtle t){
		myView = v;
		myTurtle = t;
	}
	
	public void moveTurtle(int x, int y){ // Point p1, Point p2?
		int xorig = myTurtle.getX();
		int yorig = myTurtle.getY();
		
		Point p1 = new Point(xorig, yorig);
		Point p2 = new Point(xorig + x, yorig + y);
		
		myView.drawLine(p1, p2);
		myTurtle.setX(p1.x);
		myTurtle.setY(p2.y);
	}
	
	public void rotateTurtle(int deg){
		// TODO: Implement
	}
	
}

//continues to
package application;

import java.awt.Point;

import javafx.scene.canvas.Canvas;

public class View extends Canvas {
	
	private int myWidth, myHeight;
	
	public View(int x, int y){
		myWidth = x;
		myHeight = y;
		this.setWidth(myWidth);
		this.setHeight(myHeight);
		// TODO: implement other parameter, such as color, etc.
	}
	
	public void drawLine(Point p1, Point p2){
		// TODO: draw a line from point p1 to p2
	}
	
	public void changeTurtleImage(){
		// TODO: implement
	}
	
	public void clearScreen(){
		// TODO: implement
	}
}


```

### **Design Considerations**

We had many design considerations for this project.

1) Providing general classes for commands such as movements, rotations, etc. vs creating a class for each individual command. For example, should we create a move class that contains goForward, goBackward, goRight, goLeft, and somehow call these? Or should we create a Forward class, a Backward class, and so on.

* Pros of creating individual classes:
	* Very easy to assign each class to parsed data
	* Very low-level polymorphism, which means absolute elimination of type conditionals
* Cons of creating individual classses:
	* Potential for duplicated code because some of these classes do very similar things
* Pros of creating general classes:
	* Eliminates duplicated code
* Cons of creating general classes:
	* Harder to interpret parsed data without using conditionals

We decided to go with creating individual classes for each command. We determined that we were able to attempt to minimize duplicated code by utilizing another level of polymorphism. For example, we will have an abstract Move class with a Forward method. Forward and Backward sub-classes that extend Move will both call the Forward method in the super class. This doesn't completely solve the issue of duplicated code, but it is a step forward.

2) Maps vs. Reflection
Another design consideration we had for parsing was utilizing maps vs reflection.

* Pros of using maps
	* Much easier to maintain and keep track of
	* It is a familiar data structure that we could easily implement
* Cons of using maps 
	* The values of the map are not dynamic, so we can't put method calls directly into map
* Pros of using reflection
	* Self-evaluating code is always good to get rid of type conditionals
* Cons of using reflection
	* Has limitations in that our parsed strings much match the class name
	* We haven't formally learned about this in class yet

We decided to use maps because it seems to be easier to implement for our setup.

3) View class inside GUI class or inside Main method
Another design consideration we had was whether we wanted to initialize the View class inside the GUI class or inside the Main method. We considered putting the view class inside the GUI class because we felt that the canvas for which the turtle moves should be considered part of the GUI. However, we determined that the View class is more for visualization and viewing and less about user interaction. It would also be much easier to communicate to the View class through our main class than through our GUI. Therefore, we decided to initialize our View class inside the main class.

### **Team Responsibilities**
Anika: Turtle, TurtleHandler
Andrew: GUI, View
Yongjiao/Richard: Error Checking, Turtle Commands, Math Operations, Boolean Operations
Anika/Andrew: Creating own Commanding
