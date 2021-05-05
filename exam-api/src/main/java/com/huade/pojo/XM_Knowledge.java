package com.huade.pojo;

import java.util.ArrayList;

public class XM_Knowledge {

    private String name;
    private String value;
    private boolean disable;
    private boolean selected;
    private ArrayList<XM_Knowledge> children;

    @Override
    public String toString() {
        return "XM_Knowledge{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", disable=" + disable +
                ", selected=" + selected +
                ", children=" + children +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ArrayList<XM_Knowledge> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<XM_Knowledge> children) {
        this.children = children;
    }
}
