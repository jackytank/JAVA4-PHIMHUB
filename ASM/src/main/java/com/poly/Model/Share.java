package com.poly.Model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Share")

public class Share {
    @Id
    @Column(name = "ID")
    String id;
    @ManyToOne
    @JoinColumn(name = "Users")
    private Users userId;
    @ManyToOne
    @JoinColumn(name = "Video")
    private Video videoId;
    String emails;
    @Temporal(value = TemporalType.DATE)
    Date shareDate = new Date();

    public Share() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Video getVideoId() {
        return videoId;
    }

    public void setVideoId(Video videoId) {
        this.videoId = videoId;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }

    public Share(String id, Users userId, Video videoId, String emails, Date shareDate) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.emails = emails;
        this.shareDate = shareDate;
    }
}

