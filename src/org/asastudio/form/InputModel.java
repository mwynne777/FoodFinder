package org.asastudio.form;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException; 

public class InputModel 
{
	private static final String CONSUMER_KEY = "LMRszRj8TrhcJ3vCUFmylQ";
	private static final String CONSUMER_SECRET = "MKvr9zHKjJ9j6UwQ_VZ2d_2Z67M";
	private static final String TOKEN = "BKPwyN202k4vzBKsulE4feQljCrsQfAG";
	private static final String TOKEN_SECRET = "aMpA8Jp4650NxU7v_xEIgEOh9kc";
	
	private InputModel()
	{
		yelp = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
	}
	
	public void getResturaunts(String type, String location)
	{
		String returnedInfo = InputModel.getInputModel().getYelpAPI().searchForBusinessesByLocation(type, location);
		System.out.println(returnedInfo);
		JSONParser parser = new JSONParser();
		
		try
		{
			Object rawJSON = parser.parse(returnedInfo);
			JSONObject jsonObject = (JSONObject)rawJSON;
			
			JSONArray rawResturaunts = (JSONArray) jsonObject.get("businesses");
			Iterator<JSONObject> resturauntIter = rawResturaunts.iterator();
			while (resturauntIter.hasNext())
			{
				String name = (String) resturauntIter.next().get("name");
				System.out.println(name);
			}
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static InputModel getInputModel()
	{
		if (iM == null)
		{
			iM = new InputModel();
		}
		return iM;
	}
	
	public static YelpAPI getYelpAPI()
	{
		return yelp;
	}
	
	private static YelpAPI yelp;
	private static InputModel iM;
}
