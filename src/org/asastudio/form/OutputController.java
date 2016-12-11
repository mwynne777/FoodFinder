package org.asastudio;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;


public class OutputController 
{
	
	//Constructor
	public OutputController(HttpServletResponse resp, ArrayList<Restaurant> restaurants)
	{
		this.resp = resp;
		this.restaurants = restaurants;
	}
	
	//Public Methods
	public void printRestaurants()
	{
		for (Restaurant res : restaurants)
		{
			try 
			{
				resp.getWriter().println(res.toString());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	//Private Member Variables
	private HttpServletResponse resp;
	private ArrayList<Restaurant> restaurants;
}
