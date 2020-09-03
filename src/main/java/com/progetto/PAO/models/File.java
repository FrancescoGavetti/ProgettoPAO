package com.progetto.PAO.models;

import java.util.Date;

public class File {
    private String tag;
    private String name;
    private String id;
    private Date clientModified;
    private Date serverModified;
    private String rev;
    private int size;
    private String path;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClientModified() {
        return clientModified;
    }

    public void setClientModified(Date clientModified) {
        this.clientModified = clientModified;
    }

    public Date getServerModified() {
        return serverModified;
    }

    public void setServerModified(Date serverModified) {
        this.serverModified = serverModified;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File(String tag, String name, String id, Date clientModified, Date serverModified, String rev, int size, String path) {
        this.tag = tag;
        this.name = name;
        this.id = id;
        this.clientModified = clientModified;
        this.serverModified = serverModified;
        this.rev = rev;
        this.size = size;
        this.path = path;
    }
}

