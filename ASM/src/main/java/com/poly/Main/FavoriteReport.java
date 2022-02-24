package com.poly.Main;

import java.util.Date;

public class FavoriteReport {
    private String videoTitle;
    private Long favoriteCount;
    private Date newestDate;
    private Date oldestDate;


    public FavoriteReport() {
    }

    public FavoriteReport(String videoTitle, Long favoriteCount, Date newestDate, Date oldestDate) {
        super();
        this.videoTitle = videoTitle;
        this.favoriteCount = favoriteCount;
        this.newestDate = newestDate;
        this.oldestDate = oldestDate;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Date getNewestDate() {
        return newestDate;
    }

    public void setNewestDate(Date newestDate) {
        this.newestDate = newestDate;
    }

    public Date getOldestDate() {
        return oldestDate;
    }

    public void setOldestDate(Date oldestDate) {
        this.oldestDate = oldestDate;
    }

}