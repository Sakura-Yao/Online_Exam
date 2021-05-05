package com.huade.pojo;

import java.util.ArrayList;

public class KnowCourseBean {

    private String id;
    private String title;
    private boolean checked;
    private boolean spread;
    private ArrayList<Children> children;

    public boolean getSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    @Override
    public String toString() {
        return "KnowCourseBean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", checked=" + checked +
                ", spread=" + spread +
                ", children=" + children +
                '}';
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }
}
