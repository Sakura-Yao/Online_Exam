package com.huade.pojo;

public class XM_Classes {

    private String name;
    private String value;
    private boolean selected;

    @Override
    public String toString() {
        return "XM_Classes{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", selected=" + selected +
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
