package org.asastudio.form;

import java.util.ArrayList;

public class InputController 
{
	private String rawLocation;
	private String location;
	private String[] foodArgs;
	
	public enum FoodOption{
		HEALTHY, FASTFOOD
	}
	
	public enum LocationType{
		ZIPCODE, ADDRESS
	}
	
	public InputController(String location, String[] foodArgs)
	{
		rawLocation = location;
		this.foodArgs = foodArgs;
	}
	
	public String parseLocation(String rawLoc)
	{
		String trimmedLoc = rawLoc.trim();							//Removes trailing and preceding spaces
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
		}
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
}
