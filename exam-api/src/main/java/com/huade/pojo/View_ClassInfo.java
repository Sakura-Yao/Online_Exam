package com.huade.pojo;

public class View_ClassInfo {

    private String Id;
    private String class_Id;
    private String people_Num;
    private String col_Id;
    private String col_Name;
    private String spe_Id;
    private String spe_Name;

    @Override
    public String toString() {
        return "View_ClassInfo{" +
                "Id='" + Id + '\'' +
                ", class_Id='" + class_Id + '\'' +
                ", people_Num='" + people_Num + '\'' +
                ", col_Id='" + col_Id + '\'' +
                ", col_Name='" + col_Name + '\'' +
                ", spe_Id='" + spe_Id + '\'' +
                ", spe_Name='" + spe_Name + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(String class_Id) {
        this.class_Id = class_Id;
    }

    public String getPeople_Num() {
        return people_Num;
    }

    public void setPeople_Num(String people_Num) {
        this.people_Num = people_Num;
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

    public View_ClassInfo(String id, String class_Id, String people_Num, String col_Id, String col_Name, String spe_Id, String spe_Name) {
        Id = id;
        this.class_Id = class_Id;
        this.people_Num = people_Num;
        this.col_Id = col_Id;
        this.col_Name = col_Name;
        this.spe_Id = spe_Id;
        this.spe_Name = spe_Name;
    }
}
