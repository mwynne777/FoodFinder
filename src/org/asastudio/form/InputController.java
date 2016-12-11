package org.asastudio;

import java.util.ArrayList;

import org.asastudio.form.Enumerations.*;

public class InputController 
{
	
	//Constructor
	public InputController(String location, String[] foodArgs)
	{
		rawLocation = location;
		this.foodArgs = foodArgs;
	}
	
	
	//Public Methods
	public LocationPair<String, LocationType> parseLocation(String rawLoc)
	{
		String trimmedLoc = rawLoc.trim();							//Removes trailing and preceding spaces
		String retVal = "";
		boolean isZipcode = true;
		
		if (trimmedLoc.length() == 5)
		{
			for (int i = 0; i < 5; i++)
			{
				if (!(trimmedLoc.charAt(i) >= '0' && trimmedLoc.charAt(i) <= '9'))
				{
					isZipcode = false;
				}
			}
			retVal = trimmedLoc;
		}
		else
		{
			isZipcode = false;
			retVal = trimmedLoc;
		}
		
		return isZipcode ? new LocationPair<String, LocationType>(retVal, LocationType.ZIPCODE) : new LocationPair<String, LocationType>(retVal, LocationType.ADDRESS);
	}
	
	public ArrayList<FoodOption> parseOptions(String[] args)
	{
		ArrayList<FoodOption> options = new ArrayList<FoodOption>();
		
		for(String option : args)
		{
			if (option.toLowerCase().contains("healthy"))
			{
				options.add(FoodOption.HEALTHY);
			}
			if (option.toLowerCase().contains("fast"))
			{
				options.add(FoodOption.FASTFOOD);
			}
		}
		return options;
	}
	
	public void loadDataIntoModel()
	{
		System.out.println("Location: " + parseLocation(rawLocation).getLocation());
		System.out.println("Food Options: ");
		for (FoodOption option : parseOptions(foodArgs))
		{
			System.out.println("\t" + option.toString());
		}
		InputModel.getInputModel().setLocationPair(parseLocation(rawLocation));
		InputModel.getInputModel().setFoodOptions(parseOptions(foodArgs));
	}
	
	//Private Member Variables
	private String rawLocation;
	private String[] foodArgs;
}
