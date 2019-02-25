package com.np.dipendra.myapplication.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Announcements {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("announcement")
    @Expose
    private String announcement;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("image")
    @Expose
    private String image;

    public Announcements(String announcement, String date, String department,String image) {
        this.announcement=announcement;
        this.date=date;
        this.department=department;
        this.image=image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}



