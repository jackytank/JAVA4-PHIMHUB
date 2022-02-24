package com.poly.Utils;

import org.apache.commons.collections.map.HashedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class PageInfo {
    public static Map<PageType, PageInfo> pageRoute = new HashedMap();

    static {
        pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management", "/admin/users/users.jsp", null ));
        pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Reports Management", "/admin/reports/reports.jsp", null ));
        pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video Management", "/admin/videos/videos.jsp", null ));
        pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home Page", "/sites/home/home.jsp", null ));
        pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login", "/sites/users/login.jsp", null ));
        pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("Registration", "/sites/users/registration.jsp", null ));
        pageRoute.put(PageType.SITE_CHANG_PASSWORD_PAGE, new PageInfo("Change Password", "/sites/users/change-password.jsp", null ));
        pageRoute.put(PageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("Edit Profile", "/sites/users/edit-profile.jsp", null ));
        pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot Password", "/sites/users/forgot-password.jsp", null ));
        pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("Favorite", "/sites/videos/favorite.jsp", null ));
        pageRoute.put(PageType.SITE_VIDEO_DETAIL_PAGE, new PageInfo("Video Detail", "/sites/videos/detail.jsp", null ));
        pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("Shares", "/sites/videos/share.jsp", null ));
    }

    public static void prepareAndForward(HttpServletRequest req, HttpServletResponse resp, PageType pageType) throws ServletException, IOException {
        PageInfo page = pageRoute.get(pageType);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/admin/layout.jsp").forward(req, resp);
    }
    public static void prepareAndForwardSite(HttpServletRequest req,HttpServletResponse resp,  PageType pageType) throws ServletException, IOException {
        PageInfo page = pageRoute.get(pageType);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/sites/layout.jsp").forward(req, resp);
    }
    private String title;
    private String contentUrl;
    private String scriptUrl;



    public PageInfo(String title, String contentUrl, String scriptUrl) {
        super();
        this.title = title;
        this.contentUrl = contentUrl;
        this.scriptUrl = scriptUrl;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContentUrl() {
        return contentUrl;
    }
    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
    public String getScriptUrl() {
        return scriptUrl;
    }
    public void setScriptUrl(String scriptUrl) {
        this.scriptUrl = scriptUrl;
    }

}
