# Java Swing library

This is a simple and easy to use Java - Swing library i made.

It´s uses coordinates to position the elements inside the frame.


The framework is dependent on the files inside the UILibrary folder,
[UILibrary](https://github.com/Lakerolmaker/Java-Swing-library/tree/master/UILibrary)
.



## Installing

1. Add the UILibrary folder to your src folder inside the your project

2. Add the import signature "import UILibrary.UI;" at the import section


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

#### setborder : Sets the border , using the border class

frameName.lable.setborder( ID ,  border.borderkind );

borderkind can be changed to the chosen border.


#### setFontFamliy : Sets the font family using the Font class

frameName.lable.setFontFamliy( ID ,  FontFamily );

FontFamily can be a standard font FontFamily , Font the class Font


#### setFontSize : Sets the font size

frameName.lable.setFontSize( ID , size);


* ### progressbar

* ### event

#### AddeventFucntions : adds a callback function to the event

frameName.event.eventName( ()->callbackfunction  );

callbackfunction is the function that is going to be called when the event is triggerd
