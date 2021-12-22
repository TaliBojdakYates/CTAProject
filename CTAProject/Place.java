/*Naftali Bojdak-Yates 12/10/2021
 * This class is the base class of a place. Every place has a name latitude and longitude
 * It is the parent class of stop
 */

package project;


public class Place {
	private double longitude; //variable for the longitude
	private double latitude;//variable for the latitude
	private String name;//variable for the name
	
	
	public Place() { //default constructor setting lat and long to 0 and name to unknown
		this.longitude = 0;
		this.latitude = 0;
		this.name = "Unknown Place";
	}
	
	public Place(String name,double latitude,double longitude){ // constructor that can set the lat long and name
		if((latitude >= -90) && (latitude <=90)) {
			this.latitude = latitude;
		}
		if((longitude >= -180) && (longitude <= 180)){
			this.longitude = longitude;
		}
		this.name = name;
	}
	
	public String getName() { //name getter
		return name;
	}
	public double getLatitude() { // lat getter
		return latitude;
	}
	public double getLongitude() { // long getter
		return longitude;
	}
	
	public void setName(String name) { // name setter
		this.name = name;
	}
	
	public void setLatitude(double latitude) { // lat setter. The lat must be between -90 and 90
		if((latitude >= -90) && (latitude <=90)) {
			this.latitude = latitude;
		}
	}
	 
	public void setLongitude(double longitude) { // long setter. The long must be between -180 and 180
		if((longitude >= -180) && (longitude <= 180)){
			this.longitude = longitude;
		}
	}
	
	public String toString() { // to string method
		return name + " is at longitude: " + this.longitude + " and latitude: " + this.latitude;
	}
	
	public boolean equals(Object obj) { // equals method to see if places will equal 
		if(!(obj instanceof Place)) {
			return false;
		}
		Place place = (Place) obj;
		if(place.getName() != this.name) {
			return false;
		}else if(place.getLatitude() != this.latitude) {
			return false;
		}else if(place.getLongitude() != this.longitude) {
			return false;
		}else {
			return true;
		}
	}
	
}
