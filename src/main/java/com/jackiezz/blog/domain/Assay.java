package com.jackiezz.blog.domain;

public class Assay {
    private int id;
    private String aname;
    private String digest;
    private String content;
    private int cid;

    @Override
    public String toString() {
        return "Assay{" +
                "id=" + id +
                ", aname='" + aname + '\'' +
                ", digest='" + digest + '\'' +
                ", content='" + content + '\'' +
                ", cid=" + cid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Assay() {
    }
}
