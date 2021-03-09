package JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;

import jsonObjects.Laureates;



public class ReadJSON {
	
	public static void main(String[] args) {
		String jsonURL = "http://api.nobelprize.org/v1/laureate.json";
		Gson gson = new Gson();
		String json = "";
		
		try {
			   URL url = new URL(jsonURL);
			   Scanner s = new Scanner(url.openStream());
			   while (s.hasNextLine()) {
				   json += s.nextLine();
			   }
			}
			catch(IOException ex) {
			   ex.printStackTrace();
			}
		
		//I had a compilation problem (Gson didn't know what to do with [[]])
		//so I changed it to declare name, city and country as null
		String replaceStr = "\\[{\"name\":null,\"city\":null,\"country\":null}\\]";

		Laureates laureates = gson.fromJson(json.replaceAll("\\[\\[\\]\\]", replaceStr), Laureates.class);
		
		//getting current date to create file
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		String strDate = dateFormat.format(date);  
		
		//creating file
		try {
		      File myObj = new File(strDate + ".txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        try {
		        	//writing to file
		            FileWriter myWriter = new FileWriter(strDate + ".txt");
		            myWriter.write("Number of Laureates: " + laureates.countPrizeWinners() + "\n" + 
		            "-------------------------------------------------------------\n\n" + 
		            "Economy Laureates:\n" + laureates.economyLaureates() + 
		            "-------------------------------------------------------------\n\n" +
		            "Laureates with more than one prize:\n" + laureates.laureatesWithMorePrizes());
		            
		            myWriter.close();
		            System.out.println("Successfully wrote to the file.");
		          } catch (IOException e) {
		            System.out.println("An error occurred.");
		            e.printStackTrace();
		          }
		      } 
		      else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

}
