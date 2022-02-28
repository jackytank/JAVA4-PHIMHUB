package model;

public class ChangePasswordForm {
	private String userId;
	private String password;
	private String currentPassword;
	private String confirmPassword;

	public ChangePasswordForm() {

	}

	public ChangePasswordForm(String userId, String password, String currentPassword, String confirmPassword) {
		super();
		this.userId = userId;
		this.password = password;
		this.currentPassword = currentPassword;
		this.confirmPassword = confirmPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
