/*Naftali Bojdak-Yates 12/10/2021
 * This class is the line object. A line has a name and an arraylist of stops
 * A set of lines must be made in this project for most of the functions like saving data and creating a trip and adding trip
 */
package project;

import java.util.ArrayList;

public class Line{
	private String name; // variable for the name of the stop
	private ArrayList<Stop> stops; // array list variable for all the stops on that line
	
	public Line() { //default constructor
		this.name = "No line";
		this.stops = new ArrayList<Stop>(); 
	}
	
	
	public Line(String name, ArrayList<Stop> stops) { // constructor user passes in both the name and the stops
		this.name= name;
		this.stops = stops;
		
	}

	public String getName() { // name getter
		return name;
	}
	
	public ArrayList<Stop> getStops() { //stop getter
		return stops;
	}
	public Stop getStopIndex(int index) { //stop getter
		return stops.get(index);
	}



	public void setName(String name) { //name setter
		this.name = name;
	}
	
	public void setStops(ArrayList<Stop> stops) { //setter of arraylist of stops
		this.stops = stops;
	}
	
	public String toString() { //to string method prints out all the stops on the line with line name
		String stopsString = "";
		for(int i=0;i<stops.size();i++) {
			stopsString = stopsString.concat(i+1 +". " + stops.get(i).toString() + "\n");
		}
		return "Red Line: \n" + stopsString;
	}
	
	public boolean equals(Object obj) { //equals method
		if(!(obj instanceof Line)) {
			return false;
		}
		
		Line line = (Line) obj;
		
		if(this.name != line.getName()) {
			return false;
		}else if(this.stops != line.getStops()) {
			return false;
		}
		return true;
	}
	

	
}
