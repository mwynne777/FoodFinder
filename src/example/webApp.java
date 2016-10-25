package example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class webApp extends HttpServlet{

	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().println("TESTING.... TOMCAT...");
		//super.doGet(req, resp);
	}*/
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
    {
		// Set response content type
		response.setContentType("text/html");

		// New location to be redirected
		String site = new String("http://www.photofuntoos.com");

		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);    
    }

}
