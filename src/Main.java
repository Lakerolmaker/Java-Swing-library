import JackeLibrary.UI;

import javax.swing.ImageIcon;

public class Main {

	//: Holds the object
	public static UI temperatureConveter;
	public static UI frame1;
	
	
	//: For the tempeture conveter
	public static String conversionMethod = "";
	
	public static void main(String[] args) {
			
		teperatureConverter();
		
		frame1 = new UI("Frame" , "Test frame", 400 , 400 ,false , false);

	    String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

	    frame1.addDropdown("mydropdown", 100, 100, 100, 30, choices);
	   
	    frame1.addButton("Print" ,  250 , 100 , 100 ,30 , ()-> printslidervalue() );   

	    frame1.addPasswordField("password", 10, 10, 100, 30);
	    
	    frame1.addPogressbar("hello", 30, 200, 100, false, 0, 100);
	    
	    frame1.addTextField("texte", "hello", 40, 300, 100, 30);
	    
	    frame1.addSlider("slider", 150, 10, 200, 40, 0, 50, 25, true);
	    
	    frame1.addLabel("yoo", "yes", 10, 100, 50, 50);
	    
	    frame1.addSpinner("hello", 250, 200, 100, 20, false, choices);
	    
	    frame1.frame.setIconImage(new ImageIcon("icon.png").getImage());

		frame1.show();
		
		
	} 
	
	private static void printslidervalue() {
		
		System.out.println(frame1.getDropdownItem("mydropdown"));		
		
	}
	
	//: initialize the teperature conveters
	private static void teperatureConverter() {
		
		temperatureConveter = new UI("MyFrame" , "Temperature Converter", 230 , 145 , false , false);
		
		temperatureConveter.addButton("Convert" ,  60 , 84 , 100 ,30 , ()-> buttoncallback("convert") );   
		temperatureConveter.addButton("°C" ,  120 , 20 , 44 ,33 , ()-> buttoncallback("C") ); 
		temperatureConveter.addButton("°F" ,  165 , 20 , 44 ,33 , ()-> buttoncallback("F") );   
		temperatureConveter.addLabel("output", "Select unit", 30, 20, 100, 30);
		temperatureConveter.addTextField("InputField",  null, 10, 57, 200, 30);	  
		temperatureConveter.show();
	}
	
	//: The call back function.
	private static void buttoncallback(String buttonName) {
		//:If the convert buton was pressed
		if((buttonName == "convert") && (conversionMethod != "")){
			//: Calls the calculation function
			calculateTemperature();
			
			
		//:If the Celcius button was pressed
		}else if(buttonName == "C") {
			//: If the button hasn´t been pressen before, the user is promted to input a number
			if(conversionMethod == "") {
				conversionMethod = "C";	
				temperatureConveter.updateLabel("output" , "Input number" );
				
			//: if a conversion method has been inputed before the number if converted directly
			}else {
				conversionMethod = "C";	
				calculateTemperature();
			}
		
		//:If the farenheight button was pressed	
		}else if(buttonName == "F") {
			//: If the button hasn´t been pressen before, the user is promted to input a number
			if(conversionMethod == "") {
				conversionMethod = "F";	
				temperatureConveter.updateLabel("output" , "Input number" );
				
			//: if a conversion method has been inputed before the number if converted directly	
			}else {
				conversionMethod = "F";	
				calculateTemperature();
			}
		}
		
		
		
	}
	
	//: The function that calculated the temperature
	private static void calculateTemperature() {
		//: Gets the input from the user
		String input = temperatureConveter.GetTextFieldText("InputField");
		
		//: Checks if the user has inputed a number
		try {
			
		//: converts it into a double
		double parsedInput = Double.parseDouble(input);
		
		//: Defines the output
		double output = 0;
		
		//: Checks which method should be used
		if(conversionMethod == "C") {
			//: Calculates the Temperature
			output = ( parsedInput * 1.8) + 32;
			//: Rounds the value to 2 decimals
			output = Math.round(output * 100.0) / 100.0;
			
			 //: Prints the result
			temperatureConveter.updateLabel("output" , Double.toString(output) + " °F");
			
		}else if(conversionMethod == "F") {
			//: Calculates the Temperature
			output = ( parsedInput - 32) / 1.8;
			//: Rounds the value to 2 decimals
			output = Math.round(output * 100.0) / 100.0;
			
			 //: Prints the result
			temperatureConveter.updateLabel("output" , Double.toString(output) + " °C");
		}
		
		
		//: Prints a error to the user if they have inuted something other than a number
		}catch(Exception e) {
			temperatureConveter.updateLabel("output" , "Not a number" );
		}
		
	}// end calculateTemperature()
	
	

}


