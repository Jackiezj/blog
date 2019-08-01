package com.jackiezz.blog.domain;

public class Field {
    private int id;
    private String fname;
    private int uid;

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", uid=" + uid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Field() {
    }
}
