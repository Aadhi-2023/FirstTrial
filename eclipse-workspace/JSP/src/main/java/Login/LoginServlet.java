package Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ToDoForm")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("pass");

		LoginDAO user = new LoginDAO();

		if (user.check(email, password)) 
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("Activity.jsp");
		} else {
			response.sendRedirect("LoginPage.jsp");
		}
	}
}