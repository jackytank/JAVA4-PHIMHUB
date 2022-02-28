package model;

import java.sql.Date;

public class ShareReport {
	private String userId;
	private String senderEmail;
	private String receiveEmail;
	private Date sendDate;

	public ShareReport() {

	}

	public ShareReport(String userId, String senderEmail, String receiveEmail, Date sendDate) {
		super();
		this.userId = userId;
		this.senderEmail = senderEmail;
		this.receiveEmail = receiveEmail;
		this.sendDate = sendDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getReceiveEmail() {
		return receiveEmail;
	}

	public void setReceiveEmail(String receiveEmail) {
		this.receiveEmail = receiveEmail;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

}
