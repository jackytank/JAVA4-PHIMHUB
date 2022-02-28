package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PageInfo {

	public static Map<PageType, PageInfo> pageRoute = new HashMap<PageType, PageInfo>();

	static {
        pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management", "/admin/users/users.jsp", null ));
        pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Reports Management", "/admin/reports/reports.jsp", null ));
        pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video Management", "/admin/videos/videos.jsp", null ));
        pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home Page", "/sites/home/home.jsp", null ));
        pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login", "/sites/users/login.jsp", null ));
        pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("Registration", "/sites/users/registration.jsp", null ));
        pageRoute.put(PageType.SITE_CHANGE_PASSWORD_PAGE, new PageInfo("Change Password", "/sites/users/change-password.jsp", null ));
        pageRoute.put(PageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("Edit Profile", "/sites/users/edit-profile.jsp", null ));
        pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot Password", "/sites/users/forgot-password.jsp", null ));
        pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("Favorite", "/sites/videos/favorite.jsp", null ));
        pageRoute.put(PageType.SITE_VIDEO_DETAIL_PAGE, new PageInfo("Video Detail", "/sites/videos/detail.jsp", null ));
        pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("Shares", "/sites/videos/share.jsp", null ));
	}

	public static void prepareAndForwardSite(HttpServletRequest req, HttpServletResponse res, PageType pageType)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		req.getRequestDispatcher(null).forward(req, res);
	}

	private String title;
	private String contentURL;
	private String scriptURL;

	public PageInfo(String title, String contentURL, String scriptURL) {
		super();
		this.title = title;
		this.contentURL = contentURL;
		this.scriptURL = scriptURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public String getScriptURL() {
		return scriptURL;
	}

	public void setScriptURL(String scriptURL) {
		this.scriptURL = scriptURL;
	}

}
