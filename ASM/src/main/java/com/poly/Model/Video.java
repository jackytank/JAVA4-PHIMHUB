package com.poly.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name="Video")

public class Video {
    @Id
    @Column(name="ID")
    String id;
    String titile;
    String poster;
    String viewss;
    String descriptionn;
    Boolean active = true;

    @OneToMany(mappedBy="videoId")
    List<Favorite> favorites;

    public Video() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getViewss() {
        return viewss;
    }

    public void setViewss(String viewss) {
        this.viewss = viewss;
    }

    public String getDescriptionn() {
        return descriptionn;
    }

    public void setDescriptionn(String descriptionn) {
        this.descriptionn = descriptionn;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Video(String id, String titile, String poster, String viewss, String descriptionn, Boolean active) {
        super();
        this.id = id;
        this.titile = titile;
        this.poster = poster;
        this.viewss = viewss;
        this.descriptionn = descriptionn;
        this.active = active;
    }
}