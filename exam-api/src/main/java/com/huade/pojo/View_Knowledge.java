package com.huade.pojo;

public class View_Knowledge {

    private String Id;
    private String cou_Id;
    private String cou_Name;
    private String kwl_Level;
    private int chapter_Num;
    private int section_Num;
    private String kwl_Name;
    private String parent_Id;

    @Override
    public String toString() {
        return "View_Knowledge{" +
                "Id='" + Id + '\'' +
                ", cou_Id='" + cou_Id + '\'' +
                ", cou_Name='" + cou_Name + '\'' +
                ", kwl_Level='" + kwl_Level + '\'' +
                ", chapter_Num='" + chapter_Num + '\'' +
                ", section_Num='" + section_Num + '\'' +
                ", kwl_Name='" + kwl_Name + '\'' +
                ", parent_Id='" + parent_Id + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCou_Id() {
        return cou_Id;
    }

    public void setCou_Id(String cou_Id) {
        this.cou_Id = cou_Id;
    }

    public String getCou_Name() {
        return cou_Name;
    }

    public void setCou_Name(String cou_Name) {
        this.cou_Name = cou_Name;
    }

    public String getKwl_Level() {
        return kwl_Level;
    }

    public void setKwl_Level(String kwl_Level) {
        this.kwl_Level = kwl_Level;
    }

    public int getChapter_Num() {
        return chapter_Num;
    }

    public void setChapter_Num(String chapter_Num) {
        this.chapter_Num = Integer.parseInt(chapter_Num);
    }

    public int getSection_Num() {
        return section_Num;
    }

    public void setSection_Num(String section_Num) {
        this.section_Num = Integer.parseInt(section_Num);
    }

    public String getKwl_Name() {
        return kwl_Name;
    }

    public void setKwl_Name(String kwl_Name) {
        this.kwl_Name = kwl_Name;
    }

    public String getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(String parent_Id) {
        this.parent_Id = parent_Id;
    }

    public View_Knowledge(String id, String cou_Id, String cou_Name, String kwl_Level, String chapter_Num, String section_Num, String kwl_Name, String parent_Id) {
        Id = id;
        this.cou_Id = cou_Id;
        this.cou_Name = cou_Name;
        this.kwl_Level = kwl_Level;
        this.chapter_Num = Integer.parseInt(chapter_Num);
        this.section_Num = Integer.parseInt(section_Num);
        this.kwl_Name = kwl_Name;
        this.parent_Id = parent_Id;
    }
}
