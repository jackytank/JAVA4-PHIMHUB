package user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.Email;
import model.User;
import utils.EmailUtils;

@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/forgotpassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sendWithSendGrid(req, resp);
		req.getRequestDispatcher("/views/user/forgotpassword.jsp").forward(req, resp);
	}

	protected void sendWithMailAPI(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String emailAddress = req.getParameter("email");
			String userId = req.getParameter("userId");
			UserDAO userDAO = new UserDAO();
			User user = userDAO.findByUserIdAndEmail(userId, emailAddress);

			if (user == null) {
				req.setAttribute("error", "Username or email address is incorrect!!");
			} else {
				Email email = new Email();
				email.setFrom(System.getenv("GMAIL_ACCOUNT"));
				email.setFromPassword(System.getenv("GMAIL_PASSWORD"));
				email.setTo(emailAddress);
				email.setSubject("Forgot Password | JAVA 4");

				email.setContent("Your password is: " + user.getPassword());
//				EmailUtils.send(email);

				req.setAttribute("message", "Recovery email is successfully sent, please check your email inbox!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}

	}

	protected void sendWithSendGrid(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String emailAddress = req.getParameter("email");
			String userId = req.getParameter("userId");
			UserDAO userDAO = new UserDAO();
			User user = userDAO.findByUserIdAndEmail(userId, emailAddress);

			if (user == null) {
				req.setAttribute("error", "Username or email address is incorrect!!");
			} else {
				// fromAddress is the email address you Authenticated at Sendgrid.com, after that create an environment variable for better security
				String fromAddress = System.getenv("PROTONMAIL_ACCOUNT");
				String subject = "Forgot Password Recovery | Java 4";
				String content = "Your password is: " + user.getPassword();
				// api_key is the key you created at Sendgrid.com, after that create an environment variable for better security
				String api_key = System.getenv("SENDGRID_API_KEY");
				EmailUtils.sendWithSendGridAPI(fromAddress, emailAddress, subject, content, api_key);

				req.setAttribute("message", "Recovery email is successfully sent, please check your email inbox!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.setAttribute("message", "Recovery email is successfully sent, please check your email inbox!");
	}
}
