package com.poly.asm;

import com.poly.DAO.VideoDAO;
import com.poly.Model.Video;
import com.poly.Utils.PageInfo;
import com.poly.Utils.PageType;
import com.poly.Utils.SessionUtils;
import com.poly.Utils.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet({"/Admin/VideosManagement", "/Admin/VideosManagement/create",
        "/Admin/VideosManagement/update", "/Admin/VideosManagement/delete",
        "/Admin/VideosManagement/reset", "/Admin/VideosManagement/edit", })
public class VideoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = SessionUtils.getLoginedUsername(request);
    if(username == null){
        request.setAttribute("isLogin", false);
    }else{
        request.setAttribute("isLogin", true);
    }
    String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        if(url.contains("edit")) {
            edit(request, response);
            return;
        }
        if(url.contains("delete")) {
            delete(request, response);
            return;
        }
        if(url.contains("reset")) {
            reset(request, response);
            return;
        }
        Video video = new Video();
        video.setPoster("image/6.jpg");

        findAll(request, response);
        request.setAttribute("video", video);

        PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        String username = SessionUtils.getLoginedUsername(request);
        if(username == null) {
            request.setAttribute("isLogin", false);
        }
        else {
            request.setAttribute("isLogin", true);
        }
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        if(url.contains("create")) {
            create(request, response);
            return;
        }
        if(url.contains("delete")) {
            delete(request, response);
            return;
        }
        if(url.contains("update")) {
            update(request, response);
            return;
        }
        if(url.contains("reset")) {
            reset(request, response);
            return;
        }
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("videoId");

        if (id == null) {
            req.setAttribute("error", "Video id is required!");
            PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
            return;
        }
        try {

            VideoDAO dao = new VideoDAO();
            Video video = dao.findById(id);

            if (video == null) {
                req.setAttribute("error", "Video id not found!");
                PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
                return;
            }

            dao.delete(id);
            req.setAttribute("message", "video is deleted!");

            req.setAttribute("video", new Video());
            findAll(req, resp);


        } catch (Exception e) {
            e.getStackTrace();

            req.setAttribute("error", "Error: "+ e.getMessage());
        }
        PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);

    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Video video = new Video();

        try {
            BeanUtils.populate(video, req.getParameterMap());

            VideoDAO dao = new VideoDAO();
            Video oldVideo = dao.findById(video.getId());

            if (req.getPart("cover").getSize()==0) {
                video.setPoster(oldVideo.getPoster());
            }else {
                video.setPoster("" +UploadUtils.processUploadField("cover", req,
                        "", video.getPoster()));
            }

            dao.update(video);

            req.setAttribute("video", video);
            req.setAttribute("message", "Video is update!");

            findAll(req, resp);
        } catch (Exception e) {
            e.getStackTrace();

            req.setAttribute("error", "Error: "+ e.getMessage());
        }
        PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) {

        try {

            VideoDAO dao = new VideoDAO();

            List<Video> list = dao.findAll();

            req.setAttribute("videos", list);
        } catch (Exception e) {
            e.getStackTrace();

            req.setAttribute("error", "Error: "+ e.getMessage());
        }

    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("videoId");

        if (id == null) {
            req.setAttribute("error", "Video id is required!");
            PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
            return;
        }
        try {

            VideoDAO dao = new VideoDAO();
            Video video = dao.findById(id);

            req.setAttribute("video", video);
            findAll(req, resp);


        } catch (Exception e) {
            e.getStackTrace();

            req.setAttribute("error", "Error: "+ e.getMessage());
        }
        PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);

    }

    private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Video video = new Video();
        video.setPoster("image/12.jpg");

        req.setAttribute("video", video);
        findAll(req, resp);
        PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);

    }


    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Video video = new Video();
        try {
            BeanUtils.populate(video, req.getParameterMap());

            video.setPoster("upload/" + UploadUtils.processUploadField("cover", req, "/uploads", video.getId()));

            VideoDAO dao = new VideoDAO();
            dao.create(video);

            req.setAttribute("video", video);
            req.setAttribute("message", "Video is inserted! " );

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
        findAll(req, resp);
        PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
    }
}
