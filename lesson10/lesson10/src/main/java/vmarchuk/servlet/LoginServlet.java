package vmarchuk.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import vmarchuk.domain.User;
import vmarchuk.dto.UserLogin;
import vmarchuk.service.UserService;
import vmarchuk.service.impl.UserServiceImpl;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public LoginServlet(){
		initializeUserService();
	}
	private void initializeUserService() {
        try {
            this.userService = UserServiceImpl.getUserService();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

		User user = userService.read(email);

		if (user != null && user.getPassword().equals(password)) {

			HttpSession session = request.getSession(true);
			session.setAttribute("user_id", user.getId());
			session.setAttribute("role", user.getRole().toString());

			UserLogin userLogin = new UserLogin();
			userLogin.destinationUrl = "cabinet.jsp";
			userLogin.userEmail = user.getEmail();

			String json = new Gson().toJson(userLogin);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		} else {

			String json = new Gson().toJson("noUser");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		User user = userService.read(email);
		if(user != null) {
			String json = new Gson().toJson("Success");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}
}
