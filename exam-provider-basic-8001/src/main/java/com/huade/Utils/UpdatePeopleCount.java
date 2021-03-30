package com.huade.Utils;

public class UpdatePeopleCount {
    private String count;
    private String class_Id;

    @Override
    public String toString() {
        return "UpdatePeopleCount{" +
                "count='" + count + '\'' +
                ", class_Id='" + class_Id + '\'' +
                '}';
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(String class_Id) {
        this.class_Id = class_Id;
    }

    public UpdatePeopleCount(String count, String class_Id) {
        this.count = count;
        this.class_Id = class_Id;
    }
}
