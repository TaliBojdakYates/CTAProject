/*Naftali Bojdak-Yates 12/10/2021
 *This class is the application class. It has all the code to handle user input and the program to do what the user wants to do depending on the menu option they choose
 */

package project;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CTAApp {
	
	public static void main(String[] args) {
		ArrayList<Stop> stops = readStops(); // creates an arraylist of all the stops. Gets values form the readStops function
		ArrayList<Line> lines = createLine(stops);//creates an arraylist of all the lines. Gets value from createline function
		Scanner input = new Scanner(System.in); //makes new scanner
		
		boolean quit = false; //variable to exit program
				
			do {
				
				menu();
				String choice = input.nextLine().toLowerCase(); // string of what the user enters as menu option. Set to lower case
				System.out.println();
				switch(choice) {
					case "1": 
					case "add a new station":
					case "add":{
						Stop addedStop = createStop();
						lines = addStop(stops,addedStop ,lines); //sets stops to arraylist returned from add stop method
						break;
					}
					
					case "2":
					case "modify an existing station on the CTA":
					case "modify":{
						stops = modifyStop(stops); //sets stops to arraylist returned from modifystop method
						lines = createLine(stops);
						break;
					}
					case "3": 
					case "remove a station form the CTA":
					case "remove station":{
						stops = removeStop(stops); //sts stops to arraylist returned from removestop method
						lines = createLine(stops);
						break;
					}
	
					case "4":
					case "search by name":{
						ArrayList<Stop> matching = searchStopName(stops); //creates arraylist of names searched from searchstopname method
						for(int i = 0; i<matching.size();i++) {
							System.out.println(matching.get(i).toString());
						}
						break;
					}
					
					case "5":
					case "search stop by details":{
						mainSearch(stops,lines); //search for a stop method
						break;
					}
					
					case "6":
					case"find nearest station":{
						try {
							System.out.println(closestStop(stops).toString()); //prints out the closest stop calling closeststop method
						}catch(Exception e) {
						}
						break;
					}
					
					case "7":
					case "create trip":
					case "create a trip between two stations": {
						createTrip(lines,stops); //creates a trip between two stops calling the createtrip method
						break;
					}
					case "exit":
					case "8":{
						quit = true;
						break;
					}
				}
			
			}while(quit == false);
			
		saveData(lines); // saves data
		System.out.println("Bye");
	
	}

	
	public static void menu() { //method of what the menu is for the user to pick from
		System.out.println();
		System.out.println("1. Add a new station");
		System.out.println("2. Modify an existing station on the CTA");
		System.out.println("3. Remove a station from the CTA");
		System.out.println("4. Search stop by name");
		System.out.println("5. Search stop by details");
		System.out.println("6. Find the nearest station");
		System.out.println("7. Create a trip between two stations");
		System.out.println("8. Exit");
		System.out.println();
		
	}

	public static ArrayList<Stop> sortRed(ArrayList<Stop> redLine) { //sorts the red line data by what stop it is on the red line
		boolean done = false;
		do {
			done = true;
			for(int j=0;j<redLine.size()-1;j++) {
				if(redLine.get(j+1).getRedLine() < redLine.get(j).getRedLine()) {
					
					Collections.swap(redLine,j+1, j);
					
					done =false;
				}
			}
		}while(!done);
		
		return redLine;
			
	}
	public static ArrayList<Stop> sortGreen(ArrayList<Stop> greenLine) { //sorts the green line data by what stop it is on the green line
		boolean done = false;
		do {
			done = true;
			for(int j=0;j<greenLine.size()-1;j++) {
				if(greenLine.get(j+1).getGreenLine() < greenLine.get(j).getGreenLine()) {
					
					Collections.swap(greenLine,j+1, j);
					
					done =false;
				}
			}
		}while(!done);
		
		return greenLine;
		
		
	}
	public static ArrayList<Stop> sortBlue(ArrayList<Stop> blueLine) { //sorts the blue line data by what stop it is on the blue line
		boolean done = false;
		do {
			done = true;
			for(int j=0;j<blueLine.size()-1;j++) {
				if(blueLine.get(j+1).getBlueLine() < blueLine.get(j).getBlueLine()) {
					
					Collections.swap(blueLine,j+1, j);
					
					done =false;
				}
			}
		}while(!done);
		
		return blueLine;
		
		
	}
	public static ArrayList<Stop> sortPurple(ArrayList<Stop> purpleLine) {//sorts the purple line data by what stop it is on the purple line
		boolean done = false;
		do {
			done = true;
			for(int j=0;j<purpleLine.size()-1;j++) {
				if(purpleLine.get(j+1).getPurpleLine() < purpleLine.get(j).getPurpleLine()) {
					
					Collections.swap(purpleLine,j+1, j);
					
					done =false;
				}
			}
		}while(!done);
		
		return purpleLine;
	}
	
	public static ArrayList<Stop> sortPink(ArrayList<Stop> pinkLine) {//sorts the pink line data by what stop it is on the pink line
		boolean done = false;
		do {
			done = true;
			for(int j=0;j<pinkLine.size()-1;j++) {
				if(pinkLine.get(j+1).getPinkLine() < pinkLine.get(j).getPinkLine()) {
					
					Collections.swap(pinkLine,j+1, j);
					
					done =false;
				}
			}
		}while(!done);
		
		return pinkLine;
		
	}
	public static ArrayList<Stop> sortOrange(ArrayList<Stop> orangeLine) {//sorts the orange line data by what stop it is on the orange line
		boolean done = false;
		do {
			done = true;
			for(int j=0;j<orangeLine.size()-1;j++) {
				if(orangeLine.get(j+1).getOrangeLine() < orangeLine.get(j).getOrangeLine()) {
					
					Collections.swap(orangeLine,j+1, j);
					
					done =false;
				}
			}
		}while(!done);
		
		return orangeLine;
		
		
	}
	public static ArrayList<Stop> sortBrown(ArrayList<Stop> brownLine) {//sorts the brown line data by what stop it is on the brown line
		boolean done = false;
		do {
			done = true;
			for(int j=0;j<brownLine.size()-1;j++) {
				if(brownLine.get(j+1).getBrownLine() < brownLine.get(j).getBrownLine()) {
					
					Collections.swap(brownLine,j+1, j);
					
					done =false;
				}
			}
		}while(!done);
		
		return brownLine;
		
		
	}
	public static ArrayList<Stop> readStops(){ //reads  in the csv file and creates an arraylist of all the stops
		ArrayList<Stop> stops = new ArrayList<>(); //makes an arraylist of stops

		try {
			File in = new File("src/project/CTAStops.csv");
			Scanner input = new Scanner(in); //scanner reads the csv file
			
			if(input.hasNextLine()) {
				input.nextLine();
			}
			
			
			while(input.hasNextLine()) {
				
				try {
					String textLine = input.nextLine(); //string of entire line with commas
					String[] values = textLine.split(","); //array with values separated by the commas
					Stop i = null;
					int[] lineStops = new int[7]; // array of what lines go through a stop
					
					for(int j =5; j<values.length;j++) {
						lineStops[j-5] = Integer.parseInt(values[j]);
					}
					
					i = new Stop(values[0],Double.parseDouble(values[1]),Double.parseDouble(values[2]),values[3],Boolean.parseBoolean(values[4]),lineStops);
	
					if(i != null) {
						stops = addStop(stops, i);
					}
					
					
					
				}catch(Exception e) {
					System.out.println("Error reading next line");
				}

			}
			input.close();	
		}catch(Exception e) {
			System.out.println("Error reading file");
		}
	
		return stops;	
	}
	
	public static void saveData(ArrayList<Line> lines){ //saves the data to the csv file
		//fix number at header for how many stops per line
		try {
			ArrayList<Stop> stops = new ArrayList<>();
			FileWriter out = new FileWriter("src/project/CTAStops.csv"); // filewriter from csv file
			//string for header of csv file
			String header = "Name,Latitude,Longitude,Description,Wheelchair,Red:" + lines.get(0).getStops().size() + ",Green:" +lines.get(1).getStops().size()+ ",Blue:" + lines.get(2).getStops().size() + ",Brown:" + lines.get(3).getStops().size() + ",Purple:" + lines.get(4).getStops().size() + ",Pink:" + lines.get(5).getStops().size() + ",Orange:" + lines.get(6).getStops().size() +  "\n";
			out.write(header);
			out.flush();
			for (int i=0; i<lines.size(); i++) {
				for(int j=0;j<lines.get(i).getStops().size();j++) {
					if(!(stops.contains(lines.get(i).getStopIndex(j)))) {
						stops.add(lines.get(i).getStopIndex(j));
					}
				}
			}
			
			for(int i=0;i<stops.size();i++) {
					if(i != stops.size()-1) {
						out.write(stops.get(i).toString() + "\n");
						out.flush();
					}else {
						out.write(stops.get(i).toString());
						out.flush();
					}
			}
			out.close();
			
		}catch (Exception e) {
			System.out.println("Error saving data to file");
		}
	
	}
	
	public static ArrayList<Line> createLine(ArrayList<Stop> stops) { // this method creates lines based off the stops array. It then calls the short methods to sort the stops of the lines.
		ArrayList<Line> lines = new ArrayList<>(); //array list of lines is made
		ArrayList<Stop> redStops = new ArrayList<>(); // array list of red line stops
		ArrayList<Stop> greenStops = new ArrayList<>();// array list of green line stops
		ArrayList<Stop> blueStops = new ArrayList<>();// array list of blue line stops
		ArrayList<Stop> brownStops = new ArrayList<>();// array list of brown line stops
		ArrayList<Stop> purpleStops = new ArrayList<>();// array list of purple line stops
		ArrayList<Stop> pinkStops = new ArrayList<>();// array list of pink line stops
		ArrayList<Stop> orangeStops = new ArrayList<>();// array list of orange line stops
		
		for(int i=0;i<stops.size();i++) {
			if(stops.get(i).getRedLine() != -1) {
				redStops.add(stops.get(i));
			}

			if(stops.get(i).getGreenLine() != -1) {
				greenStops.add(stops.get(i));
			}
		
			if(stops.get(i).getBlueLine() != -1) {
				blueStops.add(stops.get(i));
			}
	
			if(stops.get(i).getBrownLine() != -1) {
				brownStops.add(stops.get(i));
			}

			if(stops.get(i).getPurpleLine() != -1) {
				purpleStops.add(stops.get(i));
			}

			if(stops.get(i).getPinkLine() != -1) {
				pinkStops.add(stops.get(i));
			}
	
			if(stops.get(i).getOrangeLine() != -1) {
				orangeStops.add(stops.get(i));
			}	
		}
		
		redStops = sortRed(redStops); //sorts red line stops
		greenStops = sortGreen(greenStops);//sorts green line stops
		blueStops = sortBlue(blueStops);//sorts red blue stops
		brownStops = sortBrown(brownStops);//sorts brown line stops
		purpleStops = sortPurple(purpleStops);//sorts purple line stops
		pinkStops = sortPink(pinkStops);//sorts pink line stops
		orangeStops = sortOrange(orangeStops);//sorts orange line stops
		
		Line redLine = new Line("Red Line",redStops); //create the red line
		Line greenLine = new Line("Green Line",greenStops);//create the green line
		Line blueLine = new Line("Blue Line",blueStops);//create the blue line
		Line brownLine = new Line("Brown Line",brownStops);//create the brown line
		Line purpleLine = new Line("Purple Line",purpleStops);//create the purple line
		Line pinkLine = new Line("Pink Line",pinkStops);//create the pink line
		Line orangeLine = new Line("Orange Line",orangeStops);//create the orange line
		
		lines.add(redLine);
		lines.add(greenLine);
		lines.add(blueLine);
		lines.add(brownLine);
		lines.add(purpleLine);
		lines.add(pinkLine);
		lines.add(orangeLine);
		
		return lines;
	}
	
	public static Stop createStop() { //creates a stop based on what the user enters. 
		Scanner input = new Scanner(System.in); //creates scanner
		Stop newStop = null;
		boolean incorrectStopInfo = false;
		int counter = 0;
	
		do {
			
			incorrectStopInfo = false;
			if(counter > 0) {
				System.out.println("Data entered does not meet the requirements needed for the sections. Please try again");
			}
			try {
				System.out.println("Enter stop name");
				String stopName = input.nextLine(); //saves stop name from user input
				
				System.out.println("Enter latitude");
				
				double stopLatitude = Double.parseDouble(input.nextLine()); //saves lat from user input
				if(!((stopLatitude >= -90) && (stopLatitude <=90))){
					System.out.println("Incorrect number for latitude");
					incorrectStopInfo = true;
				}
				
				System.out.println("Enter longitiude");
				double stopLongitude = Double.parseDouble(input.nextLine()); //saves long from user input
				if(!((stopLongitude >= -180) && (stopLongitude <= 180))){
					System.out.println("Incorrect number for longitude");
					incorrectStopInfo = true;
				}
				
				System.out.println("Enter stop description");
				String stopDescription = input.nextLine(); //saves description from user input
				
				System.out.println("Enter wheelchair access");
				String wheelChairString = input.nextLine();
				boolean stopWheelchair = Boolean.parseBoolean(wheelChairString); //saves wheelchair access from user input
		
				if(!(wheelChairString.equalsIgnoreCase("true") || wheelChairString.equalsIgnoreCase("false"))) {
					throw new InputMismatchException();
				}
				
				System.out.println("Enter what stop it is on the Red line and -1 if not on the Red line");
				int redStop = Integer.parseInt(input.nextLine()); //saves if it is on the red line from user input
				
				System.out.println("Enter what stop it is on the Green line and -1 if not on the Green line");
				int greenStop = Integer.parseInt(input.nextLine());//saves if it is on the green line from user input
				
				System.out.println("Enter what stop it is on the Blue line and -1 if not on the Blue line");
				int blueStop = Integer.parseInt(input.nextLine());//saves if it is on the blue line from user input
				
				System.out.println("Enter what stop it is on the Brown line and -1 if not on the Brown line");
				int brownStop = Integer.parseInt(input.nextLine());//saves if it is on the brown line from user input
				
				System.out.println("Enter what stop it is on the Purple line and -1 if not on the Purple line");
				int purpleStop = Integer.parseInt(input.nextLine());//saves if it is on the purple line from user input
				
				System.out.println("Enter what stop it is on the Pink line and -1 if not on the Pink line");
				int pinkStop = Integer.parseInt(input.nextLine());//saves if it is on the pink line from user input
				
				System.out.println("Enter what stop it is on the Orange line and -1 if not on the Orange line");
				int orangeStop = Integer.parseInt(input.nextLine());//saves if it is on the orange line from user input
				
				if((redStop < 0) || (greenStop<0) || (blueStop<0) || (brownStop<0) || (purpleStop<0) || (pinkStop<0) || (orangeStop < 0)) {
					if((redStop != -1) || (greenStop!= -1) || (blueStop!= -1) || (brownStop!= -1) || (purpleStop!= -1) || (pinkStop!= -1) || (orangeStop != -1)) {
						System.out.println("Where the stop is on the line must be greater than 0 or -1 if not on the station");
						incorrectStopInfo = true;
					}
				}
				int[] lineStops = {redStop,greenStop,blueStop,brownStop,purpleStop,pinkStop,orangeStop}; //saves all stops to array 
				
				newStop = new Stop(stopName, stopLatitude, stopLongitude, stopDescription, stopWheelchair,lineStops); //creates new stop
				counter ++;
			}catch(Exception e) {
				System.out.println("Incorrect input for stop info please try again");
				incorrectStopInfo = true;
			}
		}while(incorrectStopInfo == true);
		
	
		return newStop;
	}
	
	public static ArrayList<Stop> addStop(ArrayList<Stop> stopList, Stop stop){ //adds a stop the the arraylist of stops
		stopList.add(stop);
		return stopList;
	}
	
	public static ArrayList<Line> addStop(ArrayList<Stop> stopList, Stop stop,ArrayList<Line> lines){ //adds a stop the the arraylist of stops
		Scanner input = new Scanner(System.in);
		ArrayList<Line> orginizedLines = new ArrayList<>();
		ArrayList<Stop> redStops = lines.get(0).getStops();
		ArrayList<Stop> greenStops = lines.get(1).getStops();
		ArrayList<Stop> blueStops = lines.get(2).getStops();
		ArrayList<Stop> brownStops = lines.get(3).getStops();
		ArrayList<Stop> purpleStops = lines.get(4).getStops();
		ArrayList<Stop> pinkStops = lines.get(5).getStops();
		ArrayList<Stop> orangeStops = lines.get(6).getStops();
	try {
 		if(stop.getRedLine() != -1) {
			for(int i=0;i<redStops.size();i++) {
				if(redStops.get(i).getRedLine() == stop.getRedLine()) {
					System.out.println("A stop is already the " + i + " stop on the red line. Enter if new stop should go '1. Before' or '2.After' this stop:");
					
					System.out.println(redStops.get(i-1));
					String place = input.nextLine();
					if(i != 0) {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							redStops.add(i-1,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							redStops.add(i,stop);
						}
						break;
					}else {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							redStops.add(0,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							redStops.add(1,stop);
						}
						break;
					}
				}
			}
			for(int j=0;j<redStops.size();j++) {
				redStops.get(j).setRedLine(j);
			}
 		}
		if(stop.getGreenLine() != -1) {
			for(int i=0;i<greenStops.size();i++) {
				if(greenStops.get(i).getGreenLine() == stop.getGreenLine()) {
					System.out.println("A stop is already stop number " + i + " on the green line. Enter if new stop should go '1. Before' or '2.After' this stop:");
					System.out.println(greenStops.get(i-1));
					String place = input.nextLine();
					if(i != 0) {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							greenStops.add(i-1,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							greenStops.add(i,stop);
						}
					}else {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							greenStops.add(0,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							greenStops.add(1,stop);
						}	
					}
					break;
				}
				
			}
			for(int j=0;j<greenStops.size();j++) {
				greenStops.get(j).setGreenLine(j);
			}
		}
		if(stop.getBlueLine() != -1) {
			for(int i=0;i<blueStops.size();i++) {
				if(blueStops.get(i).getBlueLine() == stop.getBlueLine()) {
					System.out.println("A stop is already stop number " + i + " on the blue line. Enter if new stop should go '1. Before' or '2.After' this stop:");
					System.out.println(blueStops.get(i-1));
					String place = input.nextLine();
					if(i != 0) {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							blueStops.add(i-1,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							blueStops.add(i,stop);
						}
					}else {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							blueStops.add(0,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							blueStops.add(1,stop);
						}
					}
					break;
				}
			}
			for(int j=0;j<blueStops.size();j++) {
				blueStops.get(j).setBlueLine(j);
			}
		}if(stop.getBrownLine() != -1) {
			for(int i=0;i<brownStops.size();i++) {
				if(brownStops.get(i).getRedLine() == stop.getBrownLine()) {
					System.out.println("A stop is already stop number " + i + " on the brown line. Enter if new stop should go '1. Before' or '2.After' this stop:");
					System.out.println(brownStops.get(i-1));
					String place = input.nextLine();
					if(i != -1) {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							brownStops.add(i-1,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							brownStops.add(i,stop);
						}
					else {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							brownStops.add(0,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							brownStops.add(1,stop);
						}
					}
					break;
				}
			}
			for(int j=0;j<brownStops.size();j++) {
				brownStops.get(j).setBrownLine(j);
			}
			}
		}
		if(stop.getPurpleLine() != -1) {
			for(int i=0;i<purpleStops.size();i++) {
				if(purpleStops.get(i).getPurpleLine() == stop.getPurpleLine()) {
					System.out.println("A stop is already stop number " + i + " on the purple line. Enter if new stop should go '1. Before' or '2.After' this stop:");
					System.out.println(purpleStops.get(i-1));
					String place = input.nextLine();
					if(i != -1) {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							purpleStops.add(i-1,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							purpleStops.add(i,stop);
						}
					}else {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							purpleStops.add(0,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							purpleStops.add(1,stop);
						}
					}
					break;
				}
			}
			for(int j=0;j<purpleStops.size();j++) {
				purpleStops.get(j).setPurpleLine(j);
			}
		}if(stop.getPinkLine() != -1) {
			for(int i=0;i<pinkStops.size();i++) {
				if(pinkStops.get(i).getPinkLine() == stop.getPinkLine()) {
					System.out.println("A stop is already stop number " + i + " on the pink line. Enter if new stop should go '1. Before' or '2.After' this stop:");
					System.out.println(pinkStops.get(i-1));
					String place = input.nextLine();
					if(i != -1) {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							pinkStops.add(i-1,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							pinkStops.add(i,stop);
						}
					}else {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							pinkStops.add(0,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							pinkStops.add(1,stop);
						}
					}
					break;
				}
			}
			for(int j=0;j<pinkStops.size();j++) {
				pinkStops.get(j).setPinkLine(j);
			}
		}
		if(stop.getOrangeLine() != -1) {
			for(int i=0;i<orangeStops.size();i++) {
				if(orangeStops.get(i).getOrangeLine() == stop.getOrangeLine()) {
					System.out.println("A stop is already stop number " + i + " on the orange line. Enter if new stop should go '1. Before' or '2.After' this stop:");
					System.out.println(orangeStops.get(i-1));
					String place = input.nextLine();
					if(i != -1) {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							orangeStops.add(i-1,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							orangeStops.add(i,stop);
						}
					}else {
						if(place.equalsIgnoreCase("before") || place.equalsIgnoreCase("1")) {
							orangeStops.add(0,stop);
						}else if(place.equalsIgnoreCase("after") || place.equalsIgnoreCase("2")) {
							orangeStops.add(1,stop);
						}
					}
					break;
				}
			}
			for(int j=0;j<orangeStops.size();j++) {
				orangeStops.get(j).setOrangeLine(j);
			}
		}
		Line redLine = new Line("Red Line",redStops); //create the red line
		Line greenLine = new Line("Green Line",greenStops);//create the green line
		Line blueLine = new Line("Blue Line",blueStops);//create the blue line
		Line brownLine = new Line("Brown Line",brownStops);//create the brown line
		Line purpleLine = new Line("Purple Line",purpleStops);//create the purple line
		Line pinkLine = new Line("Pink Line",pinkStops);//create the pink line
		Line orangeLine = new Line("Orange Line",orangeStops);//create the orange line
		
		orginizedLines.add(redLine);
		orginizedLines.add(greenLine);
		orginizedLines.add(blueLine);
		orginizedLines.add(brownLine);
		orginizedLines.add(purpleLine);
		orginizedLines.add(pinkLine);
		orginizedLines.add(orangeLine);
			
	}catch(Exception e) {
		System.out.println("Error adding stop");
	}
	return orginizedLines;
	
	}
	
	public static ArrayList<Stop> modifyStop(ArrayList<Stop> stopList){ //Modifies a stop by first finding the stop that the user enters and then 
		Scanner input = new Scanner(System.in);
		ArrayList<Stop> matchingStop = new ArrayList<Stop>(); //makes arraylist of matching stops in case there are multiple stops with peramiters user enters
		ArrayList<Integer> matchingStopIndex = new ArrayList<>(); //arraylist of the index the matching stop is at
		
		try {
			System.out.println("Enter stop name to modify");
			String name = input.nextLine(); //saves name to modify from the user
			for(int i=0;i<stopList.size();i++) {
				if(stopList.get(i).getName().equalsIgnoreCase(name)){
					matchingStop.add(stopList.get(i));
					matchingStopIndex.add(i);
				}
			}
			
		}catch(Exception e){
			System.out.println("Name is incorrect. Please try again");	
		}

		
		try {
			if(matchingStop.size() == 0) {
				System.out.println("No stop with that name");
			}else if(matchingStop.size() == 1) {
				System.out.println();
				System.out.println("Modifiying " + matchingStop.get(0).toString());
				System.out.println("Enter details for the stop:");
				Stop modifiedStop = createStop(); //creates the modifed stop by calling the create stop method
				System.out.println("Modified stop "  + modifiedStop.toString());
				stopList.set(matchingStopIndex.get(0), modifiedStop); // sets the index of the original stop to the modfied one
			}else {
				System.out.println();
				System.out.println("Enter the number for the stop you want to modify");
			
				for(int i=0;i<matchingStop.size();i++) {
					System.out.println(i+1 + ". " + matchingStop.get(i).toString());
				}
				int modifyStop = Integer.parseInt(input.nextLine()); // gets the number at which the matching stop is at
				Stop stop = matchingStop.get(modifyStop - 1); //gets stop from arraylist of matching stops based of number user entered
				
				System.out.println();
				System.out.println("Modifying " + stop.toString());
				System.out.println("Enter details for the stop:");
				Stop modifiedStop = createStop(); //calls create stop to make a new stop with changed stop info
				System.out.println("Modified stop "  + modifiedStop.toString());
				stopList.set(modifyStop - 1, modifiedStop); //sets old stop to the new stop

			}
		}catch(Exception e) {
			System.out.println("Incorrect number for stop to modify. Please try again");
			
		}
			
		return stopList;	
	}
	
	public static ArrayList<Stop> removeStop(ArrayList<Stop> stopList){ // this method removes a stop by asking a name of the stop to remove. If there are multiple stops with the same name a menu is printed and the user picks which one to delete
		Scanner input = new Scanner(System.in); // new scanner for user input
		ArrayList<Stop> matchingStop = new ArrayList<Stop>(); //arraylist of matching stops
		
		try {
			System.out.println("Enter stop name to delete");
			String name = input.nextLine(); //saves the name of the stop to delete
			
			for(int i=0;i<stopList.size();i++) {
				if(stopList.get(i).getName().equalsIgnoreCase(name)){
					matchingStop.add(stopList.get(i));
				}
			}
			
		}catch(Exception e){
			System.out.println("Error please write a correct name");
		}

		if(matchingStop.size() == 0) {
			System.out.println("No stop with that name");
		}else if(matchingStop.size() == 1) {
			System.out.println("Removing " + matchingStop.get(0).toString());
			stopList.remove(0);
		}else {
			try {
				System.out.println("Enter the number for the stop you want to remove");
				for(int i=0;i<matchingStop.size();i++) {
					System.out.println(i+1 + ". " + matchingStop.get(i).toString());
				}
				int removeStop = Integer.parseInt(input.nextLine()); //saves the number from the list of what stop to remove
				
				Stop stopToRemove = matchingStop.get(removeStop - 1);
				System.out.println("Removing " + stopToRemove.toString());
				stopList.remove(stopToRemove);
			}catch(Exception e) {
				System.out.println("Incorrect input. Not a number from the list of options");
			}
				
		}
		
		return stopList;
	}
	
	public static ArrayList<Stop> mainSearch(ArrayList<Stop> stopList,ArrayList<Line> stopLine){
		ArrayList<Stop> matching = new ArrayList<Stop>(); //makes araylist of matching stops
		Scanner input = new Scanner(System.in); //creates a new scanner
		System.out.println("Pick what you want to search by:");
		System.out.println("1. Name");
		System.out.println("2. Latitude");
		System.out.println("3. Longitude");
		System.out.println("4. Description");
		System.out.println("5. Wheelchair access");
		System.out.println("6. On certain line");	
		
		String choice = input.nextLine().toLowerCase(); //saves the user input for what option the user wants to search by
		switch(choice) {
			case "1":
			case "name":{
				matching = searchStopName(stopList); //calls the search my name method
				for(int i = 0; i<matching.size();i++) {
					System.out.println(matching.get(i).toString());
				}
				break;
			}
			
			case "2":
			case "latitude":{
				matching = searchLatitude(stopList); //calls the search by lat method
				for(int i = 0; i<matching.size();i++) {
					System.out.println(matching.get(i).toString());
				}
				break;
			}
			
			case "3":
			case "longitude":{
				matching = searchLongitude(stopList); //calls the search by long method
				for(int i = 0; i<matching.size();i++) {
					System.out.println(matching.get(i).toString());
				}
				break;
			}
			case "4":
			case "description":{
				matching = searchDescription(stopList); //calls the search  by description method
				for(int i = 0; i<matching.size();i++) {
					System.out.println(matching.get(i).toString());
				}
				break;
			}
			case "5":
			case "wheelchair access":{
				matching = searchWheelchair(stopList); //calls the search by wheelchair access method
				for(int i = 0; i<matching.size();i++) {
					System.out.println(matching.get(i).toString());
				}
				break;
			}
			
			case "6":
			case "on certain line":{
				matching = searchLine(stopLine); // calls the search by line method
				for(int i = 0; i<matching.size();i++) {
					System.out.println(i+1 + ". " + matching.get(i).toString());
				}
				break;
			}
			default:
				System.out.println("Incorrect input. Not on menu");
				break;	
		}
		return matching;
	}
	
	public static ArrayList<Stop> searchStopName(ArrayList<Stop> stopList) { //creates a method for search by name. User enters name and returns list of stops that have the same name
	
		ArrayList<Stop> matchingStop = new ArrayList<Stop>(); //arraylist of matching stops
		try {
			Scanner input = new Scanner(System.in); //creates scanner
			System.out.println("Enter stop name");
			String name = input.nextLine(); //saves name from user input 
			
			for(int i=0;i<stopList.size();i++) {
				if(stopList.get(i).getName().equalsIgnoreCase(name)){
					matchingStop.add(stopList.get(i));
				}
			}
			
		}catch(Exception e){
			System.out.println("Error please write a correct name");
		}
		if(matchingStop.size() == 0) {
			System.out.println("No stops matching that name");
		}
		
		return matchingStop;
	}
	
	
	public static ArrayList<Stop> searchLatitude(ArrayList<Stop> stopList) { //makes search method to search by lat. Returns arraylist of stops with matching lat
		
		ArrayList<Stop> matchingStop = new ArrayList<Stop>(); //arraylist of matching stops
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter stop latitude");
			double latitude = Double.parseDouble(input.nextLine()); //saves the lat form user input
			if(!((latitude >= -90) && (latitude <=90))) {
				System.out.println("Incorrect latitude must be between -90 and 90");
			}
			
			for(int i=0;i<stopList.size();i++) {
				if(stopList.get(i).getLatitude() == latitude){
					matchingStop.add(stopList.get(i));
				}
			}
			
		}catch(Exception e){
			System.out.println("Error please write a correct latitude");
		}
		if(matchingStop.size() == 0) {
			System.out.println("No stops matching that latitude");
		}
		return matchingStop;
	}
	
	public static ArrayList<Stop> searchLongitude(ArrayList<Stop> stopList) {//makes search method to search by long. Returns arraylist of stops with matching long
			
			ArrayList<Stop> matchingStop = new ArrayList<Stop>(); //create arraylist of matching stops
			try {
				Scanner input = new Scanner(System.in); //creates scanner
				System.out.println("Enter stop longitude");
				double longitude = Double.parseDouble(input.nextLine()); //saves the long value user enters
				if(!((longitude >= -180) && (longitude <= 180))){
					System.out.println("Incorrect longitude must be between -180 and 180");
				}
				for(int i=0;i<stopList.size();i++) {
					if(stopList.get(i).getLongitude() == longitude){
						matchingStop.add(stopList.get(i));
					}
				}
			}catch(Exception e){
				System.out.println("Error please write a correct longitude");
			}
			if(matchingStop.size() == 0) {
				System.out.println("No stops matching that longitude");
			}
			
			return matchingStop;
		}
	
	public static ArrayList<Stop> searchDescription(ArrayList<Stop> stopList) { //creates search method by description. User enters description
		
		ArrayList<Stop> matchingStop = new ArrayList<Stop>(); //makes arraylist of matching stops
		try {
			Scanner input = new Scanner(System.in); //creates scanner
			System.out.println("Enter stop description");
			String description = input.nextLine(); //saves description value
			
			for(int i=0;i<stopList.size();i++) {
				if(stopList.get(i).getDescription().equalsIgnoreCase(description)){
					matchingStop.add(stopList.get(i));
				}
			}
			
		}catch(Exception e){
			System.out.println("Error please write a correct description");
		}
		if(matchingStop.size() == 0) {
			System.out.println("No stops matching that description");
		}
		return matchingStop;
	}
	
	public static ArrayList<Stop> searchWheelchair(ArrayList<Stop> stopList) { //makes the search by wheelchair access. Loops through arraylist of stops and finds ones that have or don't have wheelchair access.
		
		ArrayList<Stop> matchingStop = new ArrayList<Stop>(); //array list of matching stops
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter stop wheelchair access");
			String wheelchairString = input.nextLine(); //saves  wheelchair access from user input

			if(!((wheelchairString.equalsIgnoreCase("true")) ||(wheelchairString.equalsIgnoreCase("false")))){ //boolean.parseboolean will pass false if not true is not found so if neither true or false is imputed throw error
				throw new InputMismatchException();
			}
			boolean wheelchair = Boolean.parseBoolean(wheelchairString);
			
			for(int i=0;i<stopList.size();i++) {
				if(stopList.get(i).hasWheelchair() == wheelchair){
					matchingStop.add(stopList.get(i));
				}
			}
			
		}catch(Exception e){
			System.out.println("Error please write a correct wheelchair access. True or False");
		}
		if(matchingStop.size() == 0) {
			System.out.println("No stops matching that wheelchair access");
		}
		return matchingStop;
	}
	
public static ArrayList<Stop> searchLine(ArrayList<Line> lines) { //search by line method. User chooses which line they want to get the stops from and it returns all the stops on  that line
		
		ArrayList<Stop> matchingStop = new ArrayList<Stop>(); //creates arraylist of matching stops
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter what line you want the stop to be on");
			System.out.println("1. Red");
			System.out.println("2. Green");
			System.out.println("3. Blue");
			System.out.println("4. Brown");
			System.out.println("5. Purple");
			System.out.println("6. Pink");
			System.out.println("7. Orange");
			
			String userLine = input.nextLine().toLowerCase(); //gets the user input for what line to get the stops from
			
			switch(userLine) { //gets the stop on a line depending on which line the user entered
				case "1":
				case "red":{
					matchingStop = lines.get(0).getStops();
					break;
				}
				
				case "2":
				case "green":{
					matchingStop = lines.get(1).getStops();
					break;
				}
				
				case "3":
				case "blue":{
					matchingStop = lines.get(2).getStops();
					break;
				}
				
				case "4":
				case "brown":{
					matchingStop = lines.get(3).getStops();
					break;
					
				}
				
				case "5":
				case "purple":{
					matchingStop = lines.get(4).getStops();
					break;
					
				}
				
				case "6":
				case "pink":{
					matchingStop = lines.get(5).getStops();
					break;
					
				}
				
				case "7":
				case "orange":{
					matchingStop = lines.get(6).getStops();
					break;
					
				}
				default:{
					System.out.println("Incorrect line inputted");
				}
			
			}
		}catch(Exception e) {
			System.out.println("Enter a correct line");
		}
		if(matchingStop.size() == 0) {
			System.out.println("No stops on that line");
		}
		return matchingStop;
	}

	public static Stop closestStop(ArrayList<Stop> stops) { //finds the closest stop method. User enters the location and 
		Scanner input = new Scanner(System.in);
		double closest = 0;
		int index = -1;
		Stop closestStop = null;
		
		try {
			System.out.println("Enter latitude");
			double latPoint = input.nextDouble(); //saves that lat from the user input
			if(!((latPoint >= -90) && (latPoint <=90))) {
				System.out.println("Incorrect latitude must be between -90 and 90");
				throw new IllegalArgumentException();
			}
			System.out.println("Enter longitude");
			double longPoint = input.nextDouble(); //saves long from user input
			if(!((longPoint >= -180) && (longPoint <=180))) {
				System.out.println("Incorrect longitude must be between -180 and 180");
				throw new IllegalArgumentException();
			}
			double latPointRadians = Math.toRadians(latPoint); //turns the latitude into radians
			double longPoinRadians = Math.toRadians(longPoint);//turns the longitude into radians
			
			
			
			for(int i=0;i<stops.size();i++) {
				double latStop = Math.toRadians(stops.get(i).getLatitude()); //gets the lat for the stop at index i
				double longStop = Math.toRadians(stops.get(i).getLongitude());//gets the long for the stop at index i
				
				double differanceLong = longStop - longPoinRadians; //gets long the difference between the stop and the point
				double differanceLat = latStop - latPointRadians;//gets the lat difference between the stop and the point
				
				
				double a = Math.pow(Math.sin(differanceLat / 2), 2)+ Math.cos(latPointRadians) * Math.cos(latStop)* Math.pow(Math.sin(differanceLong / 2),2);
				
				double c = 2 * Math.asin(Math.sqrt(a));
				double earthRadiusMiles = 3956;

				double distanceMiles = c * earthRadiusMiles;
				
				if(index ==-1) {
					closest = distanceMiles;
					closestStop = stops.get(0);	
					index += 1;
				}else {
					if((distanceMiles < closest)) {
						closest = distanceMiles;
						closestStop = stops.get(i);
					}
				}
			}	
		}catch(Exception e) {
			System.out.println("Invalid latitude or longitude");
		}

		return closestStop;

	}
	
	public static void createTrip(ArrayList<Line> lines, ArrayList<Stop> stopList) { //create trip method. First prints out line to take if no line transfer is needed. If a transfer is needed matching lines method is called to find the matching lines to switch
		Scanner input = new Scanner(System.in);
		ArrayList<Stop> matchingStart = new ArrayList<Stop>(); //arraylist of the matching stops for the start
		ArrayList<Stop> matchingEnd = new ArrayList<Stop>(); //arraylist of the matching stops for the end
		Stop startStop = null; 
		Stop endStop = null;
		try {
			System.out.println("Starting Stop:");
			matchingStart =searchStopName(stopList); //matching start stop is result from searchStopName method
		
	
			if(matchingStart.size() == 1) {
				System.out.println("Start: " + matchingStart.get(0).toString());
				startStop = matchingStart.get(0); //startStop is set to first element in matching stop arraylist
			}else if(matchingStart.size() > 1) {
				try {
					System.out.println("Enter the number for the stop you want to start from");
					for(int i=0;i<matchingStart.size();i++) {
						System.out.println(i+1 + ". " + matchingStart.get(i).toString());
					}
					int startStopNumber = Integer.parseInt(input.nextLine());
					
					startStop = matchingStart.get(startStopNumber - 1);
					System.out.println("Start: " + startStop.toString());
				}catch(Exception e) {
					System.out.println("Incorrect number enterd for starting stop");
				}
			}
			
			System.out.println("End Stop:");
			matchingEnd =searchStopName(stopList); //matching end stop is result from searchStopName method
			
			if(matchingEnd.size() == 1) {
				System.out.println("End: " + matchingEnd.get(0).toString());
				endStop = matchingEnd.get(0); //sets the end stop to the one matching stop
			}else if(matchingEnd.size() > 1) { 
				try { // this section of code gets the ending stop if there are multiple stops with that name
					System.out.println("Enter the number for the stop you want to end at");
					for(int i=0;i<matchingEnd.size();i++) {
						System.out.println(i+1 + ". " + matchingEnd.get(i).toString());
					}
					int endStopNumber = Integer.parseInt(input.nextLine());
					
					endStop = matchingEnd.get(endStopNumber - 1);
					System.out.println("End: " + endStop.toString());
				}catch(Exception e) {
					System.out.println("Incorrect number enterd for ending stop");
				}
						
			}
			matchingLines(lines,startStop,endStop); //calls the matching lines method of creating a trip which also runs the switch lines method inside if it must switch lines
		}catch(Exception e) {
			System.out.println("Error when getting starting or ending stop");
		}
		
	}
	public static void matchingLines(ArrayList<Line> lines,Stop startStop, Stop endStop) { // this method creates a trip if the user does not have to switch lines and calls the method to switch lines if the ride does
			boolean switchLanes = true;
			for(int i=0;i<startStop.getLines().length;i++) {
				if((startStop.getLines()[i] != -1) && (endStop.getLines()[i] != -1)) {
					if(i==0) {
						System.out.println("You can take the red line from: " + "\n" + "Start: " + startStop.toString() + "	End: " + endStop.toString());
					}
					if(i==1) {
						System.out.println("You can take the green line" + "\n" + "Start: " + startStop.toString() + "	End: " + endStop.toString());
					}else if(i==2) {		
						System.out.println("You can take the blue line" + "\n" + "Start: " + startStop.toString() + "	End: " + endStop.toString());			
					}else if(i==3) {
						System.out.println("You can take the brown line" + "\n" + "Start: " + startStop.toString() + "	End: " + endStop.toString());
					}else if(i==4) {
						System.out.println("You can take the purple line" + "\n" + "Start: " + startStop.toString() + "	End: " + endStop.toString());
					}else if(i==5) {
						System.out.println("You can take the pink line" + "\n" + "Start: " + startStop.toString() + "	End: " + endStop.toString());
					}else if(i==6) {
						System.out.println("You can take the orange line" + "\n" + "Start: " + startStop.toString() + "	End: " + endStop.toString());
					}
				switchLanes = false;
			}
		}
		
		if(switchLanes){
			switchingLines(lines,startStop,endStop); //calls the switch lines method if you can not take one line 
		}
	}
	public static void switchingLines(ArrayList<Line> lines, Stop startStop, Stop endStop) {
		ArrayList<Line> startLines = new ArrayList<>(); //arraylist of all the lines that go through the starting stop
		ArrayList<Line> endLines = new ArrayList<>(); //arraylist of all the liens that go through the end stop
		try {
			for(int i=0;i<startStop.getLines().length;i++) {
				if((startStop.getLines()[i] != -1)) {
					
					if(i==0) { // start is on red line
						startLines.add(lines.get(0));
					}else if(i==1) { // start is on green line
						startLines.add(lines.get(1));
					}else if(i==2) {		//start is on blue line
						startLines.add(lines.get(2));
					}else if(i==3) {
						startLines.add(lines.get(3));
					}else if(i==4) {
						startLines.add(lines.get(4));
					}else if(i==5) {
						startLines.add(lines.get(5));
					}else {
						startLines.add(lines.get(6));
					}
				}
			}
			for(int i=0;i<endStop.getLines().length;i++) {
				if((endStop.getLines()[i] != -1)) {
					if(i==0) { // start is on red line
						endLines.add(lines.get(0));
					}else if(i==1) { // start is on green line
						endLines.add(lines.get(1));
					}else if(i==2) {		//start is on blue line
						endLines.add(lines.get(2));
					}else if(i==3) {
						endLines.add(lines.get(3));
					}else if(i==4) {
						endLines.add(lines.get(4));
					}else if(i==5) {
						endLines.add(lines.get(5));
					}else {
						endLines.add(lines.get(6));
					}
				}
			
			}
		
			for(int i =0;i<startLines.size();i++) {
				ArrayList<Stop> startTemp = startLines.get(i).getStops(); //all the stops on line i added to arraylist
				
				for(int j=0;j<endLines.size();j++) {
					ArrayList<Stop> endTemp = endLines.get(j).getStops(); //all the stops on line j added to arraylist
					
					if(startLines.get(i).getName().equalsIgnoreCase("red line")) { //if the starting line has the red line
						for(int m=0;m<endTemp.size();m++) { //loop through all the end stops 
							if(endTemp.get(m).getRedLine() != -1) { //if the end stops red line does not = -1 you can switch there
								System.out.println("You can switch from the " + startLines.get(i).getName() + " to the " + endLines.get(j).getName() + " at the following station:");
								System.out.println(endTemp.get(m));
								System.out.println();
							}
						}
					}else if(startLines.get(i).getName().equalsIgnoreCase("green line")) { //same idea as with red line
						System.out.println(endLines.get(j).getName());
							for(int m=0;m<endTemp.size();m++) {
								if(endTemp.get(m).getGreenLine() != -1) {
									System.out.println("You can switch from the " + startLines.get(i).getName() + " to the " + endLines.get(j).getName() + " at the following station:");
									System.out.println(endTemp.get(m));
									System.out.println();
								}
							}
						}
					else if(startLines.get(i).getName().equalsIgnoreCase("blue line")) {//same idea as with red line
						for(int m=0;m<endTemp.size();m++) {
							if(endTemp.get(m).getBlueLine() != -1) {
								System.out.println("You can switch from the " + startLines.get(i).getName() + " to the " + endLines.get(j).getName() + " at the following station:");
								System.out.println(endTemp.get(m));
								System.out.println();
							}
						}
					}else if(startLines.get(i).getName().equalsIgnoreCase("brown line")) {//same idea as with red line
						for(int m=0;m<endTemp.size();m++) {
							if(endTemp.get(m).getBrownLine() != -1) {
								System.out.println("You can switch from the " + startLines.get(i).getName() + " to the " + endLines.get(j).getName() + " at the following station:");
								System.out.println(endTemp.get(m));
								System.out.println();
							}
						}
					}
					else if(startLines.get(i).getName().equalsIgnoreCase("purple line")) {//same idea as with red line
						for(int m=0;m<endTemp.size();m++) {
							if(endTemp.get(m).getPurpleLine() != -1) {
								System.out.println("You can switch from the " + startLines.get(i).getName() + " to the " + endLines.get(j).getName() + " at the following station:");
								System.out.println(endTemp.get(m));
								System.out.println();
							}
						}
					}
					else if(startLines.get(i).getName().equalsIgnoreCase("pink line")) {//same idea as with red line
						for(int m=0;m<endTemp.size();m++) {
							if(endTemp.get(m).getPinkLine() != -1) {
								System.out.println("You can switch from the " + startLines.get(i).getName() + " to the " + endLines.get(j).getName() + " at the following station:");
								System.out.println(endTemp.get(m));
								System.out.println();
							}
						}
					}
					else if(startLines.get(i).getName().equalsIgnoreCase("orange line")) {//same idea as with red line
						for(int m=0;m<endTemp.size();m++) {
							if(endTemp.get(m).getOrangeLine() != -1) {
								System.out.println("You can switch from the " + startLines.get(i).getName() + " to the " + endLines.get(j).getName() + " at the following station:");
								System.out.println(endTemp.get(m));
								System.out.println();
							}
						}
					}
				}
			}
			
		}catch(Exception e) {
			System.out.println("Error switching lines");
		}
			}
	
}

	