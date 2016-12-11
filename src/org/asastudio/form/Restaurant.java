package org.asastudio;

public class Restaurant 
{	
	//Constructor
	public Restaurant(String name, String streetAddress, String city, String zipcode, String state)
	{
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
	}
	
	//Public Methods
	public String getName()
	{
		return name;
	}
	public String getStreetAddress()
	{
		return streetAddress;
	}
	public String getCity()
	{
		return city;
	}
	public String getZipcode()
	{
		return zipcode;
	}
	public String getState()
	{
		return state;
	}
	
	public String toString()
	{
		return name + " | Address: " + streetAddress + " City: " + city + " State: " + state + " Zipcode: " + zipcode;
	}
	//Private Member Variables
	private String name;
	private String streetAddress;
	private String city;
	private String zipcode;
	private String state;
}
