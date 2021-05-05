package com.huade.pojo;

import java.util.ArrayList;

public class Children {

    private String id;
    private String title;
    private Boolean checked;
    private String kwl_level;
    private int chapter;
    private int section;
    private ArrayList<Children> children;

    @Override
    public String toString() {
        return "Children{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", checked=" + checked +
                ", chapter=" + chapter +
                ", section=" + section +
                ", children=" + children +
                '}';
    }

    public String getKwl_level() {
        return kwl_level;
    }

    public void setKwl_level(String kel_level) {
        this.kwl_level = kel_level;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }
}
