package org.asastudio;

import java.util.ArrayList;

import org.asastudio.form.Enumerations.*;

//This class follows the Singleton design pattern
public class InputModel 
{	
	//Constructor
	private InputModel()
	{
		yelp = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
	}
	
	//Public Methods
	public void getResturaunts()
	{
		ArrayList<String> rawJSON = new ArrayList<String>();
		
		for (FoodOption option : options)
		{
			switch (option)
			{
				case HEALTHY:
					rawJSON.add(yelp.searchForBusinessesByLocation("healthy", pair.getLocation()));
					break;
				case FASTFOOD:
					rawJSON.add(yelp.searchForBusinessesByLocation("mcdonalds", pair.getLocation()));
					rawJSON.add(yelp.searchForBusinessesByLocation("wendys", pair.getLocation()));
					rawJSON.add(yelp.searchForBusinessesByLocation("burger king", pair.getLocation()));
					rawJSON.add(yelp.searchForBusinessesByLocation("pizza hut", pair.getLocation()));
					break;
				default:
					break;
			}
		}
		
		//Passes data to output model for processing
		OutputModel.getOutputModel().setJSON(rawJSON);
		OutputModel.getOutputModel().setLocation(pair);
		OutputModel.getOutputModel().buildRestaurants();
	}
	public void setLocationPair(LocationPair<String, LocationType> pair)
	{
		this.pair = pair;
	}
	public void setFoodOptions(ArrayList<FoodOption> options)
	{
		this.options = options;
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

	
	//Private Member Variables
	
	private static YelpAPI yelp;
	private static InputModel iM;
	
	//Keys for YelpAPI
	private static final String CONSUMER_KEY = "LMRszRj8TrhcJ3vCUFmylQ";
	private static final String CONSUMER_SECRET = "MKvr9zHKjJ9j6UwQ_VZ2d_2Z67M";
	private static final String TOKEN = "BKPwyN202k4vzBKsulE4feQljCrsQfAG";
	private static final String TOKEN_SECRET = "aMpA8Jp4650NxU7v_xEIgEOh9kc";
	
	//User Input
	private LocationPair<String, LocationType> pair;
	private ArrayList<FoodOption> options;
}
