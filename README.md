# SLOGO
A development environment that helps users write SLogo programs.

  Note on 02/25

  - when parsing If and Ifelse, only constructing IfCond class. 
  - Tobeadded: mutiple commands in command list[ ];

CompSci 308 Spring 2015

Team: Anika Radiya-Dixit, Andrew Sun, Yongjiao Yu, Richard Wang

Date started: 02/13/15

Date finished: 

Hours worked: 40+

Resources used:
* http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
* http://docs.oracle.com/javase/tutorial/essential/regex/matcher.html
* http://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
* http://docs.oracle.com/javafx/2/ui_controls/button.htm
* http://docs.oracle.com/javase/7/docs/api/java/lang/Math.html
* http://docs.oracle.com/javafx/2/ui_controls/color-picker.htm
* http://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html
* http://fxexperience.com/2011/12/styling-fx-buttons-with-css/

Main class file: Main.java



NOTE: error checking

```java

ERROR CHECKING CLASS
- allows leading and trailling spaces for a line of command
- alows exactly only one space within a command: ___fw_50___

private Map<String command, String regix> collectionOfCommands...


public boolean validateInput(String input)
{
  AL input2 = input.split(" ");
  if (input2 of size 2)
  {
    return checkSingleCommand(input2);
  }
  if (input2 starts with loop/doTimes/repeat)
  {
   // call another method
  }
  ...
  
}

public boolean checkSingleCommand(AL input)
{
 // make sure first element is a valid command
 // make sure remaining  elements are integers satisfying required number according to hashmap
}

...

```





