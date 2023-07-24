package registerclass;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		List list = new List(uname, password, email);
		RegisterDAO dao = new RegisterDAO();
		dao.insert(list);
		response.sendRedirect("LoginPage.jsp");

	}
}
