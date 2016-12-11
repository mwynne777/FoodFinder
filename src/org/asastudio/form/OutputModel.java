package org.asastudio;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.asastudio.form.Enumerations.*;

//This class follows the Singleton design pattern
public class OutputModel 
{	
	//Constructor
	private OutputModel()
	{
		
	}
	
	//Public Methods
	public void buildRestaurants()
	{
		if (rawJSON.size() == 0)
		{
			System.out.println("There is no JSON to build a list of restaurants!");
			return;
		}
		
		System.out.println("rawJSON Size: " + rawJSON.size());
		
		JSONParser parser = new JSONParser();
		try
		{
			for (String returnedInfo : rawJSON)
			{
			Object rawJSON = parser.parse(returnedInfo);
			JSONObject jsonObject = (JSONObject)rawJSON;			
			JSONArray rawResturaunts = (JSONArray) jsonObject.get("businesses");
			@SuppressWarnings("unchecked") //Legacy API? Couldn't figure out how to type-safe the iterator
			Iterator<JSONObject> resturauntIter = rawResturaunts.iterator();
				while (resturauntIter.hasNext())
				{
					JSONObject restaurant = (JSONObject) resturauntIter.next();
					JSONObject location = (JSONObject) restaurant.get("location");
					
					String name = (String) restaurant.get("name");
					JSONArray addressArray = (JSONArray) location.get("address");
					String address = (String) addressArray.get(0);
					String city = (String) location.get("city");
					String zipcode = (String) location.get("postal_code");
					String state = (String) location.get("state_code");
					
					unfilteredRestaurants.add(new Restaurant(name, address, city, zipcode, state));
				}
			}
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void filterRestaurants()	//Filters our list of restaurants based on location type (ZIPCODE vs ADDRESS) and names of restaurants
	{
		switch (locationPair.getType())
		{
			case ZIPCODE:
				for (Restaurant res : unfilteredRestaurants)
				{
					if (res.getZipcode().equals(locationPair.getLocation()))
					{
						filteredRestaurants.add(res);
					}
				}
				break;
			case ADDRESS:
				
				break;
			default:
				break;
		}
	}

	public static OutputModel getOutputModel()
	{
		if (oM == null)
			oM = new OutputModel();
		return oM;
	}
	public ArrayList<Restaurant> getUnfilteredRestaurants()
	{
		return unfilteredRestaurants;
	}
	public ArrayList<Restaurant> getFilteredRestaurants()
	{
		return filteredRestaurants;
	}
	public void setJSON(ArrayList<String> rawJSON)
	{
		this.rawJSON = rawJSON;
	}
	public void setLocation(LocationPair<String, LocationType> pair)
	{
		locationPair = pair;
	}
	
	//Private Member Variables
	private static OutputModel oM;
	private ArrayList<Restaurant> unfilteredRestaurants = new ArrayList<Restaurant>();
	private ArrayList<Restaurant> filteredRestaurants = new ArrayList<Restaurant>();
	private ArrayList<String> rawJSON = new ArrayList<String>();
	private LocationPair<String, LocationType> locationPair;
	
}
