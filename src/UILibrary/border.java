package UILibrary;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class border {

	public static Border  blackline = BorderFactory.createLineBorder(java.awt.Color.black);
	public static Border  raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	public static Border  loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	public static Border  raisedbevel = BorderFactory.createRaisedBevelBorder();
	public static Border  loweredbevel = BorderFactory.createLoweredBevelBorder();
	public static Border  empty = BorderFactory.createEmptyBorder();
	
	public static Border color(Color chosencolor) {
		return BorderFactory.createLineBorder(chosencolor);
	}
	
	
}
