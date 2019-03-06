package com.np.dipendra.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Modal {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("sname")
    @Expose
    private String sname;
    @SerializedName("spass")
    @Expose
    private String spass;
    @SerializedName("sfaculty")
    @Expose
    private String sfaculty;
    @SerializedName("semai")
    @Expose
    private String semail;

    public Modal(int id, String sid, String sname, String spass, String sfaculty, String semail) {
    }

    public Modal(String sid) {
    }

    public Modal(String sid, String semail) {
    }

    public Modal(String sid, String sname, String sfaculty) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass;
    }

    public String getSfaculty() {
        return sfaculty;
    }

    public void setSfaculty(String sfaculty) {
        this.sfaculty = sfaculty;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }
}
