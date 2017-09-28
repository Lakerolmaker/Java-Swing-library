package JackeLibrary;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

import com.sun.management.OperatingSystemMXBean; 

public class Input {
	
private static String choice;
private static String userString;
private static int userInt;

//: The users input
public static String userChoice;
//: The string that has the time.
public static String timeString;

public static void print(Object o) {
    System.out.print(o);
   
}

public static void cls() {
   for(int i = 0;  i < 100; i++) {
	   print("\n");
   }  
}

public static void clear() {
	   for(int i = 0;  i < 100; i++) {
		   print("\n");
	   }  
}

public static void getUser(String choice){
	choice = choice;
	Scanner reader = new Scanner(System.in);  
	if(choice == "text") {
		
	System.out.println("Enter text : ");
    userString = reader.nextLine();
    
	}else if(choice == "int") {
		
	System.out.println("Enter a number: ");
	userInt = reader.nextInt();
		
	}
    reader.close();
}

public static void printUser(){
	if(choice == "text") {
		System.out.println("You enterd : " + userString);
	}else if(choice == "int") {
		System.out.println("You enterd : " + userInt);
	}
}

public static int randomNumber(int min , int max) {
	Random rand = new Random(); 
	int random = rand.nextInt((max - min) + 1) + min;
	 return random;
}

public static void sleep(int time){
	try        
	{
	    Thread.sleep(time);
	} 
	catch(InterruptedException ex) 
	{
	    Thread.currentThread().interrupt();
	}
}

public static void time(){
	long totalMilliseconds = System.currentTimeMillis();
	
	long totalSeconds = totalMilliseconds / 1000;
	
	long currentSecond = totalSeconds % 60;
	
	long totalMinutes = totalSeconds / 60;

	long currentMinute = totalMinutes % 60;
	
	long currentHour = totalMinutes % 24;
	
	timeString =  (currentHour + ":" + currentMinute + ":" + currentSecond);
	
	System.out.println(timeString);
}

public static void course(){

	String one = "|----------------|";
	String two = "| Code   |course |";
  String three = "|----------------|";
   String four = "| DIT042 | 001   |";
   String five = "|----------------|";
	String six = "| Dit022 | MFSE  |";
  String seven = "|----------------|";


	
	System.out.println(one);
	System.out.println(two);
	System.out.println(three);
	System.out.println(four);
	System.out.println(five);
	System.out.println(six);
	System.out.println(seven);
	
}

public static void printArray( Object[] theArray) {
	String res = Arrays.toString(theArray);
	System.out.println(res);
	
}

public static void popup(String title , String message) { 
	JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
}

public static String popupInput(String message , String inputValue) {
	
	String answer = JOptionPane.showInputDialog(null, message, inputValue ,JOptionPane.PLAIN_MESSAGE);

	userChoice = answer;
	
	return userChoice;
}

public static void popupDrowdown(String title , String message) {
	
	Object[] possibilities = {"ham", "spam", "yam"};
	String answer = (String)JOptionPane.showInputDialog( null, message , title, JOptionPane.PLAIN_MESSAGE,  null, possibilities, "ham");
	
	userChoice = answer;
}

public static void popupConfirm(String Opt1 , String Opt2 , String title , String message) {
	
Object[] options = {Opt1, Opt2};
	
	int answer = JOptionPane.showOptionDialog(null,
		message,
		title,
		JOptionPane.YES_NO_OPTION,
		JOptionPane.PLAIN_MESSAGE,
		null,     //do not use a custom Icon
		options,  //the titles of buttons
		options[0]); //default button title
	
	String parsedInt = Integer.toString(answer);
	
	userChoice = parsedInt ;
	
}

//: Function form Eugene Yokota.
private static void Usage() {
	  OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
	    method.setAccessible(true);
	    if (method.getName().startsWith("get")
	        && Modifier.isPublic(method.getModifiers())) {
	            Object value;
	        try {
	            value = method.invoke(operatingSystemMXBean);
	        } catch (Exception e) {
	            value = e;
	        } // try
	        System.out.println(method.getName() + " = " + value);
	    } // if
	  } // for
	}


}
