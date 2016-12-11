package org.asastudio;
import org.asastudio.form.Enumerations.*;

public class LocationPair<String, LocationType> 
{	
	//Constructor
	public LocationPair(String location, LocationType type)
	{
		this.location = location;
		this.type = type;
	}
	
	//Public Methods
	public String getLocation()
	{
		return location;
	}
	
	public LocationType getType()
	{
		return type;
	}
	
	
	//Private Member Variables
	private String location;
	private LocationType type;
}
