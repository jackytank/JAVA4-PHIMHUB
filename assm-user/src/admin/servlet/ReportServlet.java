package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoriteDAO;
import dao.VideoDAO;
import model.FavoriteReport;
import model.FavoriteUserReport;
import model.ShareReport;
import model.Video;

@WebServlet("/Report")
public class ReportServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reportSharedFriend(req, resp);
		reportFavoriteUserByVideos(req, resp);
		reportFavoritesByVideos(req, resp);
		req.getRequestDispatcher("/views/admin/reports.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void reportSharedFriend(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String videoShareId = req.getParameter("videoShareId");
			List<Video> videoShareList = new VideoDAO().findAll();

			if (videoShareId == null && videoShareList.size() > 0) {
				videoShareId = videoShareList.get(0).getVideoId();
			}
			List<ShareReport> shareReportsList = new FavoriteDAO().reportShare(videoShareId);

			req.setAttribute("videoShareId", videoShareId);
			req.setAttribute("videoShareList", videoShareList);
			req.setAttribute("shareReportsList", shareReportsList);
		} catch (Exception e) {
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void reportFavoriteUserByVideos(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String videoUserId = req.getParameter("videoUserId");
			List<Video> videoList = new VideoDAO().findAll();

			if (videoUserId == null && videoList.size() > 0) {
				videoUserId = videoList.get(0).getVideoId();
			}
			List<FavoriteUserReport> favUserList = new FavoriteDAO().reportFavoriteUsersByVideos(videoUserId);

			req.setAttribute("videoUserId", videoUserId);
			req.setAttribute("videoList", videoList);
			req.setAttribute("favUserList", favUserList);
		} catch (Exception e) {
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void reportFavoritesByVideos(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			FavoriteDAO dao = new FavoriteDAO();
			List<FavoriteReport> list = dao.reportFavoritesByVideos();
			req.setAttribute("favList", list);
		} catch (Exception e) {
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
