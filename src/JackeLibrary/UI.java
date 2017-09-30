package JackeLibrary;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;



public class UI {
	
	public  JFrame frame; 
	public String framename;
	public  ArrayList<JTextField> activeTextFields = new ArrayList<JTextField>(); 
	public  ArrayList<JButton> activebuttons = new ArrayList<JButton>(); 
	public  ArrayList<JLabel> activelabels = new ArrayList<JLabel>(); 
	public  ArrayList<JProgressBar> activeProgressBar = new ArrayList<JProgressBar>(); 
	public  ArrayList<JSlider> activeSliders = new ArrayList<JSlider>(); 
	public  ArrayList<JComboBox> activeDropdown = new ArrayList<JComboBox>(); 
	public  ArrayList<JPasswordField> activePasswordFields = new ArrayList<JPasswordField>(); 
	public  ArrayList<JSpinner> activeSpinners = new ArrayList<JSpinner>(); 

	
	public UI(String frameNameInput, String title , int width , int height ,  Boolean fullScreen ,  Boolean togglefullscreen) {
		
		framename = frameNameInput;
		
		//: Creates the frame object
		JFrame createdFrame = new JFrame(frameNameInput); 
		//: Sets the dimensions the the frame
		createdFrame.setSize(width, height);
		//: Defines that the window will close when the user presses the close button
		createdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//: Sets the name of frame so it canbe acced later
		createdFrame.setName(frameNameInput);
		
		//: Sets the title of the window
		createdFrame.setTitle(title);
		
		//: Defines fullscreen mode if it is specified
		if(fullScreen)
			createdFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//: Defines if you can resize the window
		createdFrame.setResizable(togglefullscreen);
		
	
		//: Get´s the dimension of the window
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int ScreenWidth = gd.getDisplayMode().getWidth();
		int ScreenHeight = gd.getDisplayMode().getHeight();
			
		//: Calculates the center of the screen and removes the the size of the frame.
		int x = ScreenWidth/2 - (int)createdFrame.getSize().getWidth()/2;
		int y = ScreenHeight/2 - (int)createdFrame.getSize().getHeight()/2;
		//: Sets the coordinates of the frame in the center of the screen
		createdFrame.setLocation(x,y);
				
		//: Shows the frame
		createdFrame.setLocationRelativeTo(null);
		
		createdFrame.setLayout(null);
		
			
		//:Adds the frame to a list so it can be acced
		frame = createdFrame;
		
	}

	public void addButton(String ButtonLabel, int x , int y , int width , int height , Runnable function) {

		JPanel panel = new JPanel();
		   
		panel.setLayout(null);
	   	panel.setSize(new Dimension(width, height));
	   	panel.setBounds(x, y, width, height);
	  

	   	JButton button = new JButton(ButtonLabel);
	   	button.setName(ButtonLabel);
	   	button.setBounds(0, 0, width, height);
		panel.add(button);
		
		frame.add(panel);
		
		activebuttons.add(button);
		
		button.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  function.run();
		  }
		});


	}
	
	public void addLabel(String Labelname , String LabelText,  int x , int y , int width , int height) {
				
		JPanel panel = new JPanel();
		   
		panel.setLayout(null);
	   	panel.setSize(new Dimension(width, height));
	   	panel.setBounds(x, y, width, height);
	  
	   	JLabel label = new JLabel(Labelname);
	   	label.setName(Labelname);
	   	label.setBounds(0, 0, width, height);
		panel.add(label);
		
		frame.add(panel);
	
	}
	
	public void updateLabel(String labelname ,String text) {
		JLabel selectedLabel = null;

		for(int i = 0 ; i < activelabels.size(); i++) {
			if(activelabels.get(i).getName() == labelname )
				selectedLabel = activelabels.get(i);
		}
		
		selectedLabel.setText(text);
		
		
	}
	
	public void addTextField(String fieldName,  String deafualtInput, int x , int y , int width , int height) {

		JPanel panel = new JPanel();
		   
		panel.setLayout(null);
	   	panel.setSize(new Dimension(width, height));
	   	panel.setBounds(x, y, width, height);
	  

	   	JTextField input = new JTextField(deafualtInput);
	   	input.setName(fieldName);
	   	input.setBounds(0, 0, width, height);
		panel.add(input);
		
		frame.add(panel);
		
		activeTextFields.add(input);
		
	}
	
	public String GetTextFieldText(String fieldName) {
		
		String fieldValue = "";
		

		for(int i = 0 ; i < activeTextFields.size(); i++) {

			if(activeTextFields.get(i).getName() == fieldName )
				fieldValue = activeTextFields.get(i).getText();
			}	
		
		return fieldValue;
					
	}
	
	public void addPogressbar( String progressBarName  , int x , int y , int width , boolean showNumber , int min , int max) {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
	   	panel.setSize(new Dimension(width, 15));
	   	panel.setBounds(x, y, width, 15);
	  

	   	JProgressBar progressBar = new JProgressBar(min, max);
	   	progressBar.setName(progressBarName);
	   	progressBar.setBounds(0, 0, width, 15);
		panel.add(progressBar);
		progressBar.setValue(10);
		progressBar.setStringPainted(showNumber);
		panel.add(progressBar);
		
		frame.add(panel);
		
		activeProgressBar.add(progressBar);
		
	}
	
	public void updateProgressbar( String progressBarName , int procentage){
		
		JProgressBar progressBar = null;

		for(int i = 0 ; i < activeProgressBar.size(); i++) {

			if(activeProgressBar.get(i).getName() == progressBarName )
				progressBar = activeProgressBar.get(i);
		}
		
		
		progressBar.setValue(procentage);
	}

	public void addSlider(String sliderName, int x , int y , int width , int height, int min, int max,int startingPoint , boolean horizontal){
		
		JPanel panel = new JPanel();
		 
		panel.setLayout(null);
	   	panel.setSize(new Dimension(width, height));
	   	panel.setBounds(x, y, width, height);
	  
	    JSlider slider = null;
		
			if(horizontal == true) 
				 slider = new JSlider(JSlider.HORIZONTAL, min, max, startingPoint);
			else
				 slider = new JSlider(JSlider.VERTICAL,  min, max , startingPoint);

		slider.setName(sliderName);
		slider.setBounds(0, 0, width, height);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels(10));
		panel.add(slider);
		
		frame.add(panel);
		activeSliders.add(slider);
		    
	    
	    
	    		
	}
	
	public void removeUI(String FrameName) {
		
		frame.setVisible(true); 
		frame.dispose(); 		
	}
	 
	public int getSliderValue(String sliderName){
		
		int Slidervalue = 0;
		

		for(int i = 0 ; i < activeSliders.size(); i++) {

			if(activeSliders.get(i).getName() == sliderName )
				Slidervalue = activeSliders.get(i).getValue();
			}	
		
		
		return Slidervalue;
		
	}
	
	public void addDropdown(String dropdownName, int x , int y , int width , int height , String[]Choices ) {
        
        JPanel panel = new JPanel();
 	   
		panel.setLayout(null);
	   	panel.setSize(new Dimension(width, height));
	   	panel.setBounds(x, y, width, height);
	  

        JComboBox<String> dropdown = new JComboBox<String>(Choices);
        dropdown.setName(dropdownName);
        dropdown.setBounds(0, 0, width, height);
		panel.add(dropdown);
		
		frame.add(panel);
		
		activeDropdown.add(dropdown);

		} 
	
	public String getDropdownItem(String dropdownName) {
		
		String dropdownItem = "";
	
		for(int i = 0 ; i < activeDropdown.size(); i++) {
			if(activeDropdown.get(i).getName() == dropdownName )
				dropdownItem = activeDropdown.get(i).getSelectedItem().toString();
			}	
		
		return dropdownItem;
	
	}
	
	public void addPasswordField(String fieldName, int x , int y , int width , int height) {
		
		JPanel panel = new JPanel();
	   
		panel.setLayout(null);
	   	panel.setSize(new Dimension(width, height));
	   	panel.setBounds(x, y, width, height);
	  

		JPasswordField passwordField = new JPasswordField(10);
		passwordField.setName(fieldName);
		passwordField.setBounds(0, 0, width, height);
		panel.add(passwordField);
		
		frame.add(panel);
		
	   
	}
	
	public void addSpinner(String dropdownName, int x , int y , int width , int height , boolean editable , String[]Choices ) {

		 	JPanel panel = new JPanel();
	 	   
			panel.setLayout(null);
		   	panel.setSize(new Dimension(width, height));
		   	panel.setBounds(x, y, width, height);
		  
		   	JSpinner spinner = new JSpinner();
		  
		   	
		   	SpinnerModel model = new SpinnerListModel(Arrays.asList(Choices));
		   	
		    spinner.setModel(model);
		    
		    if(editable)
		    		spinner.setEditor(new JSpinner.DefaultEditor(spinner));
		    
	        spinner.setBounds(0, 0, width, height);
			panel.add(spinner);
			
			frame.add(panel);
			
			activeSpinners.add(spinner);
	}
	
	
	public void show() {
		
		frame.setVisible(true);
	}
	
	public void hide() {
		
		frame.setVisible(false);
	}
	
	public void close() {
		
		frame.dispose();
	}
	
	
}
