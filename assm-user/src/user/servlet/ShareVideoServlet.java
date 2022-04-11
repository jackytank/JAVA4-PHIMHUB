package user.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShareDAO;
import model.Share;
import model.User;
import model.Video;
import utils.EmailUtils;
import utils.SessionUtils;

@WebServlet("/ShareVideo")
public class ShareVideoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!SessionUtils.isLogin(req)) {
			resp.sendRedirect("Login");
			return;
		}
		
		String videoId = req.getParameter("videoId");

		if (videoId == null) {
			resp.sendRedirect("Home");
			return;
		}
		req.setAttribute("videoId", videoId);
		req.getRequestDispatcher("/views/user/share.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sendWithSendGrid(req, resp);
		req.getRequestDispatcher("/views/user/share.jsp").forward(req, resp);
	}

	protected void sendWithSendGrid(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String emailAddress = req.getParameter("email");
			String videoId = req.getParameter("videoId");

			if (videoId == null) {
				req.setAttribute("error", "VideoId is not found!!");
			} else {
				// fromAddress is the email address you Authenticated at Sendgrid.com, after
				// that create an environment variable for better security
				String fromAddress = System.getenv("PROTONMAIL_ACCOUNT");
				String subject = "SHARE VIDEO NÈ BRO | Java 4";
				String content = "Link: " + videoId;
				// api_key is the key you created at Sendgrid.com, after that create an
				// environment variable for better security
				String api_key = System.getenv("SENDGRID_API_KEY");
				EmailUtils.sendWithSendGridAPI(fromAddress, emailAddress, subject, content, api_key);

				ShareDAO shareDAO = new ShareDAO();
				Share share = new Share();
//				share.setShareId((10000 + new Random().nextInt(90000)));
				share.setEmails(emailAddress);
				share.setShareDate(new Date());

				String userId = SessionUtils.getLoginUsername(req);
				User user = new User();
				user.setUserId(userId);
				share.setUser(user);
				
				Video video = new Video();
				video.setVideoId(videoId);
				share.setVideo(video);
				
				shareDAO.insert(share);
				req.setAttribute("message", "Video link had been sent!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
	}
}
