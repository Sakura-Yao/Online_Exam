package com.huade.pojo;

public class View_TeacherBasicInfo {

    private String user_Id;
    private String user_Name;
    private String user_Sex;
    private String user_Mobile;
    private String col_Id;
    private String col_Name;
    private String spe_Id;
    private String spe_Name;

    @Override
    public String toString() {
        return "View_TeacherBasicInfo{" +
                "user_Id='" + user_Id + '\'' +
                ", user_Name='" + user_Name + '\'' +
                ", user_Sex='" + user_Sex + '\'' +
                ", user_Mobile='" + user_Mobile + '\'' +
                ", col_Id='" + col_Id + '\'' +
                ", col_Name='" + col_Name + '\'' +
                ", spe_Id='" + spe_Id + '\'' +
                ", spe_Name='" + spe_Name + '\'' +
                '}';
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Sex() {
        return user_Sex;
    }

    public void setUser_Sex(String user_Sex) {
        this.user_Sex = user_Sex;
    }

    public String getUser_Mobile() {
        return user_Mobile;
    }

    public void setUser_Mobile(String user_Mobile) {
        this.user_Mobile = user_Mobile;
    }

    public String getCol_Id() {
        return col_Id;
    }

    public void setCol_Id(String col_Id) {
        this.col_Id = col_Id;
    }

    public String getCol_Name() {
        return col_Name;
    }

    public void setCol_Name(String col_Name) {
        this.col_Name = col_Name;
    }

    public String getSpe_Id() {
        return spe_Id;
    }

    public void setSpe_Id(String spe_Id) {
        this.spe_Id = spe_Id;
    }

    public String getSpe_Name() {
        return spe_Name;
    }

    public void setSpe_Name(String spe_Name) {
        this.spe_Name = spe_Name;
    }

    public View_TeacherBasicInfo(String user_Id, String user_Name, String user_Sex, String user_Mobile, String col_Id, String col_Name, String spe_Id, String spe_Name) {
        this.user_Id = user_Id;
        this.user_Name = user_Name;
        this.user_Sex = user_Sex;
        this.user_Mobile = user_Mobile;
        this.col_Id = col_Id;
        this.col_Name = col_Name;
        this.spe_Id = spe_Id;
        this.spe_Name = spe_Name;
    }
}
