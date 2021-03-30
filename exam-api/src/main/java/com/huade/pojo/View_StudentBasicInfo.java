package com.huade.pojo;

public class View_StudentBasicInfo {

    private String user_Id;
    private String user_Name;
    private String user_Sex;
    private String classes_Id;
    private String class_Id;
    private String col_Id;
    private String col_Name;
    private String spe_Id;
    private String spe_Name;
    private String user_Mobile;

    @Override
    public String toString() {
        return "View_StudentBasicInfo{" +
                "user_Id='" + user_Id + '\'' +
                ", user_Name='" + user_Name + '\'' +
                ", user_Sex='" + user_Sex + '\'' +
                ", classes_Id='" + classes_Id + '\'' +
                ", class_Id='" + class_Id + '\'' +
                ", col_Id='" + col_Id + '\'' +
                ", col_Name='" + col_Name + '\'' +
                ", spe_Id='" + spe_Id + '\'' +
                ", spe_Name='" + spe_Name + '\'' +
                ", user_Mobile='" + user_Mobile + '\'' +
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

    public String getClasses_Id() {
        return classes_Id;
    }

    public void setClasses_Id(String classes_Id) {
        this.classes_Id = classes_Id;
    }

    public String getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(String class_Id) {
        this.class_Id = class_Id;
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

    public String getUser_Mobile() {
        return user_Mobile;
    }

    public void setUser_Mobile(String user_Mobile) {
        this.user_Mobile = user_Mobile;
    }

    public View_StudentBasicInfo(String user_Id, String user_Name, String user_Sex, String classes_Id, String class_Id, String col_Id, String col_Name, String spe_Id, String spe_Name, String user_Mobile) {
        this.user_Id = user_Id;
        this.user_Name = user_Name;
        this.user_Sex = user_Sex;
        this.classes_Id = classes_Id;
        this.class_Id = class_Id;
        this.col_Id = col_Id;
        this.col_Name = col_Name;
        this.spe_Id = spe_Id;
        this.spe_Name = spe_Name;
        this.user_Mobile = user_Mobile;
    }
}
