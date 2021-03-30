package com.huade.pojo;

public class View_CourseInfo {

    private String Id;
    private String cou_Name;
    private String spe_Id;
    private String spe_Name;
    private String col_Id;
    private String col_Name;

    @Override
    public String toString() {
        return "View_CourseInfo{" +
                "Id='" + Id + '\'' +
                ", cou_Name='" + cou_Name + '\'' +
                ", spe_Id='" + spe_Id + '\'' +
                ", spe_Name='" + spe_Name + '\'' +
                ", col_Id='" + col_Id + '\'' +
                ", col_Name='" + col_Name + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCou_Name() {
        return cou_Name;
    }

    public void setCou_Name(String cou_Name) {
        this.cou_Name = cou_Name;
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

    public View_CourseInfo(String id, String cou_Name, String spe_Id, String spe_Name, String col_Id, String col_Name) {
        Id = id;
        this.cou_Name = cou_Name;
        this.spe_Id = spe_Id;
        this.spe_Name = spe_Name;
        this.col_Id = col_Id;
        this.col_Name = col_Name;
    }
}
