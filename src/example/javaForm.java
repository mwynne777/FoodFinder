package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class javaForm extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user_location = req.getParameter("userLocation");		
		String[] foodOptions = req.getParameterValues("foodOptions");
		
		if (user_location.equals(""))
		{
			resp.getWriter().println("Invalid Location!");
			return;
		}
		
		/*InputController inputController = new InputController(user_location, foodOptions);
		inputController.loadDataIntoModel();
		InputModel.getInputModel().getResturaunts();
		OutputController outputController = new OutputController(resp, OutputModel.getOutputModel().getFilteredRestaurants());
		outputController.printRestaurants();*/
	}
	
}
