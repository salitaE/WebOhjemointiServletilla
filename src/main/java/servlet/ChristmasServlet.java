package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.time.temporal.ChronoUnit.DAYS;

@WebServlet("/christmas")
public class ChristmasServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		LocalDate today = LocalDate.now();
		LocalDate christmas = LocalDate.of(today.getYear(), 12, 24);
		long between = DAYS.between(today, christmas);
		req.setAttribute("days", between);
		
		//Välitetään tieto christmas formille
		req.getRequestDispatcher("/WEB-INF/christmas.jsp").forward(req, resp);
		
	
	}
	

}

