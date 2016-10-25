package org.asastudio.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class javaForm extends HttpServlet {

	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().println("TESTING SUCCESS!!!");
		String user_location = req.getParameter("userLocation");
		String user_healthy = req.getParameter("userHealthy");
		resp.getWriter().println(user_location);
		resp.getWriter().println(user_healthy);
	}*/
	
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
    {
		// Set response content type
		response.setContentType("text/html");

		// New location to be redirected
		String site = new String("http://localhost:8080/FoodFinder/results.html");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);    
    }
}
