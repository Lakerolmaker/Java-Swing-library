# Java Swing library

This is a simple and easy to use Java - Swing library i made.

It´s uses coordinates to position the elements inside the frame.


The framework is dependent on one simple file,
[UI.java](https://github.com/Lakerolmaker/Java-Swing-library/blob/master/src/UILibrary/UI.java)
.

Simply add the file to your project and then add the reference "import UILibrary.UI;" ,
in the top of the import field.


## Example

* ### Creating the main window

#### Using X & Y coordinates to place the window on the screen :

UI frameName = new UI( ID , WindowTitle , X , Y , Width , Height , FullscreenToogle , mMainWindowToogle);


#### Without coordinates ( places the window in the center of the screen) :

UI frameName = new UI( ID , WindowTitle , Width , Height , FullscreenToogle , mainWindowToogle);


#### Note :
• FullscreenToogle : If the program should be maximized from the start.

• MainWindowToogle : If the window should quit the program if closed



* ### Adding components

#### Button

frameName.addButton( ID,  x ,  y , width , height , ()->CallbackFunction);

#### Textfield

framename.addTextField( ID,  deafualtInput,  x , y , width , height);

deafualtInput = If something should be added to the text field when created

#### Textfield

framename.addTextField( ID,  deafualtInput,  x , y , width , height);


## Customize Items


* ### Label

### setborder : Sets the border of the label , using the border class

frameName.lable.setborder( ID ,  border.borderkind );

borderkind can be changed to the chosen border.


### setFontFamliy : Sets the border of the label , using the border class

frameName.lable.setFontFamliy( ID ,  FontFamily );

FontFamily can be a standard font FontFamily , From the class Font
