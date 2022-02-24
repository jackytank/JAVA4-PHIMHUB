package com.poly.Model;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="Favorite", uniqueConstraints= {
        @UniqueConstraint(columnNames= {"Video","Users"})
})

public class Favorite {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private String id;
        @ManyToOne
        @JoinColumn(name = "Users")
        private Users users;
        @ManyToOne
        @JoinColumn(name = "Video")
        private Video videoId;
        @Temporal(TemporalType.DATE)
        Date likeDate = new Date();

    public Favorite() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Video getVideoId() {
        return videoId;
    }

    public void setVideoId(Video videoId) {
        this.videoId = videoId;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }

    public Favorite(String id, Users users, Video videoId, Date likeDate) {
        this.id = id;
        this.users = users;
        this.videoId = videoId;
        this.likeDate = likeDate;
    }
}

