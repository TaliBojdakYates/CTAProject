/*Naftali Bojdak-Yates 12/10/2021
 * This class define swhat a stop is. A stop has a description wheelchair access and an arraylist of what lines go through it
 * The arraylist has a value -1 of not on the line and a number depending on what stop on the line it is
 * A line is made up of an arraylist of stops. This is used for checking matching stops and every function in this project
 */

package project;

public class Stop extends Place  {
	
	private String description; //string variable for description
	private boolean wheelchair;//boolean variable for wheelchair access 
	private int[] lines;//int array containing the number of what stop the stop is on each line
	
	public Stop() { //default constructor setting the default value for a stop 
		super();
		description = "Elevated";
		wheelchair = true;
		lines = new int[7];
		
	}
	
	public Stop(String name,double latitude,double longitude,String description, boolean wheelchair, int[] lines) { // constructor to sets value of stop
		super(name, latitude, longitude);
		this.description = description;
		this.wheelchair = wheelchair;
		this.lines = lines;
		
	}
	
	public String getDescription() { // description getter
		return description;
	}
	
	public int[] getLines() { //getter for the entire array of liens
		return lines;
	}
	
	public int getLinesIndex(int index) { //getter for a value in the lines array at an index
		return lines[index];
	}
	public int getRedLine() { //gets zero index of int array which corresponds with what stop it is on the red line
		return lines[0];
	}
	public int getGreenLine() { //gets first index of int array which corresponds with what stop it is on the green line
		return lines[1];
	}
	public int getBlueLine() { //gets second index of int array which corresponds with what stop it is on the blue line
		return lines[2];
	}
	public int getBrownLine() { //gets third index of int array which corresponds with what stop it is on the brown line
		return lines[3];
	}
	public int getPurpleLine() { //gets fourth index of int array which corresponds with what stop it is on the purple line
		return lines[4];
	}
	public int getPinkLine() { //gets fifth index of int array which corresponds with what stop it is on the pink line
		return lines[5];
	}
	public int getOrangeLine() { //gets sixth index of int array which corresponds with what stop it is on the orange line
		return lines[6];
	}
	
	public void setRedLine(int i) {
		lines[0] = i;
	}
	public void setGreenLine(int i) {
		lines[1] = i;
	}
	public void setBlueLine(int i) {
		lines[2] = i;
	}
	public void setBrownLine(int i) {
		lines[3] = i;
	}
	
	public void setPurpleLine(int i) {
		lines[4] = i;
	}
	
	public void setPinkLine(int i) {
		lines[5] = i;
	}
	public void setOrangeLine(int i) {
		lines[6] = i;
	}
	public boolean hasWheelchair() { //getter for if it has wheelchair access
		return wheelchair;
	}
	public void setDescription(String description) { //description setter
		this.description = description;
	}
	
	public void setWheelchair(boolean wheelchair) { //has wheelchair setter
		this.wheelchair = wheelchair;
	}

	public void setLines(int[] lines) { //sets what lines the stop has
		this.lines = lines;
	}
	
	public String linesToString(){ //puts the int array of stops into an string separated by commas to read and right to csv file
		String stopString = "";
		for(int i =0; i<lines.length;i++) {
			stopString = stopString.concat(lines[i] + ",");
		}
		return stopString.substring(0,stopString.length()-1);
		
	}
	public String toString() { // to string for stop
		return this.getName() +"," + this.getLatitude() + "," + this.getLongitude() + "," + this.getDescription() +"," +  this.hasWheelchair() +"," + linesToString(); 
	}
	
	
	public boolean equals(Object obj) { // equals method to check if stops are equals
		if(!(obj instanceof Stop)) {
			return false;
		}
		Stop stop = (Stop) obj;
		
		if(!(description.equalsIgnoreCase(stop.getDescription()))) {
			return false;
			
		}else if(wheelchair != stop.hasWheelchair()) {
			return false;
		}else if(lines != stop.getLines()) {
			return false;
		}
		
		return true;
	}	
}
