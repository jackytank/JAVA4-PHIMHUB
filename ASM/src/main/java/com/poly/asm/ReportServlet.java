package com.poly.asm;

import com.poly.DAO.FavoriteDAO;
import com.poly.DAO.VideoDAO;
import com.poly.Main.FavoriteReport;
import com.poly.Main.FavoriteUserReport;
import com.poly.Model.Video;
import com.poly.Utils.PageInfo;
import com.poly.Utils.PageType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet("/ReportManagementServlet")
public class ReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reportFavoritesByVideos(request, response);
        reportFavoriteUsersByVideo(request, response);
        PageInfo.prepareAndForward(request, response, PageType.REPORT_MANAGEMENT_PAGE);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void reportFavoriteUsersByVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String videoUserId = req.getParameter("videoUserId");

            VideoDAO vdao = new VideoDAO();
            List<Video> vList = vdao.findAll();

            if(videoUserId == null && vList.size()>0) {
                videoUserId = vList.get(0).getId();
            }
            FavoriteDAO dao = new FavoriteDAO();


            List<FavoriteUserReport> list = dao.reportFavoriteUsersByVideo(videoUserId);

            req.setAttribute("videoUserId", videoUserId);
            req.setAttribute("vidList", vList);
            req.setAttribute("favUsers", list);
        } catch (Exception e) {
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    protected void reportFavoritesByVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            FavoriteDAO dao = new FavoriteDAO();
            List<FavoriteReport> list = dao.reportFavoritesByVideos();

            req.setAttribute("favList", list);
        } catch (Exception e) {
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

}
