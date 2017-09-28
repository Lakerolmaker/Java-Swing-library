package JackeLibrary;

import static JackeLibrary.Input.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


public class $ {

		public static String postUrl;
		public static ArrayList<URLParamater> postParamaters = new ArrayList<URLParamater>(); 
		
		public static void NewPostParamter(String name , String value) {
			
			URLParamater okja = new URLParamater(name , value);
			
			postParamaters.add(okja);
			
		}
		
		// HTTP POST request
		public static void post() throws Exception {
			
			
			String url = null;
			//: The url , ( is set to a standard url if not spcified )	
			if(postUrl == null) { url = "http://api.lakerolmaker.com/main.php"; }
			//: Opens a web-handler
			URL wsURL = new URL(url);
			HttpURLConnection con = (HttpURLConnection) wsURL.openConnection();
			//Set´s the method of connecting
			con.setRequestMethod("POST");
			
			
			//: Adds the paramaters
			String urlParameters = "";
						
			for(int i = 0 ; i < postParamaters.size(); i++) {
				urlParameters += postParamaters.get(0).name + "=" + postParamaters.get(0).value + "&";

			}
						
			//: enables a resonse & sends the post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			
			//: Gets the code of the event
			int responseCode = con.getResponseCode();

			//: A function i got that translates the reponse into text
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			//: adds the lines from respons untill all lines are addeds
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());

		}

	
}

class URLParamater{
	
	String name;
	String value;
	
	URLParamater(String NameOfParmater, String NameOfvalue){
		this.name = NameOfParmater;
		this.value = NameOfvalue;
	}
	
}



