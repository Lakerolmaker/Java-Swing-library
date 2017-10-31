# Java Swing library

This is a simple and easy to use Java - Swing library i made.

It´s uses coordinates to position the elements inside the frame.


The framework is dependent on one simple file,
[UI.java](https://github.com/Lakerolmaker/Java-Swing-library/blob/master/src/UILibrary/UI.java)
.

Simply add the file to your project and then add the reference "import UILibrary.UI;" ,
in the top of the import field.


## Example

* Creating the main window

Using X & Y coordinates to place the window on the screen : 
UI frameName = new UI( ID , WindowTitle , X , Y , Width , Height , FullscreenToogle , mainWindowToogle);

Without coordinates ( places the window in the center of the screen) :
UI frameName = new UI( ID , WindowTitle , Width , Height , FullscreenToogle , mainWindowToogle);
