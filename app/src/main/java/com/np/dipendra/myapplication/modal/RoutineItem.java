package com.np.dipendra.myapplication.modal;

import android.widget.ScrollView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoutineItem {
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("lecture")
    @Expose
    private String lecture;
    @SerializedName("lecturer")
    @Expose
    private String lecturer;

    public RoutineItem(String time, String lecture, String lecturer) {

        this.time = time;
        this.lecture = lecture;
        this.lecturer = lecturer;
    }

    public RoutineItem() {
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
}
