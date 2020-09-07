package com.progetto.PAO.models;

import org.json.JSONException;
import org.json.JSONObject;


public class File {
    private String tag;
    private String name;
    private String id;
    private String clientModified;
    private String serverModified;
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

    public String getClientModified() {
        return clientModified;
    }

    public void setClientModified(String clientModified) {
        this.clientModified = clientModified;
    }

    public String getServerModified() {
        return serverModified;
    }

    public void setServerModified(String serverModified) {
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

    public File(String tag, String name, String id, String clientModified, String serverModified, String rev, int size, String path) {
        this.tag = tag;
        this.name = name;
        this.id = id;
        this.clientModified = clientModified;
        this.serverModified = serverModified;
        this.rev = rev;
        this.size = size;
        this.path = path;
    }

    public File(JSONObject obj) {
        try {
            this.tag = obj.getString(".tag");
            this.name = obj.getString("name");
            this.id = obj.getString("id");
            if(!this.tag.equals("folder")){
                this.clientModified = obj.getString("client_modified");
                this.serverModified = obj.getString("name");
                this.rev = obj.getString("rev");
                this.size = obj.getInt("size");
            }else{
                this.clientModified = "None";
                this.serverModified = "None";
                this.rev = "None";
                this.size = -1;
            }

            this.path = obj.getString("path_lower");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "File{" +
                "tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", clientModified='" + clientModified + '\'' +
                ", serverModified='" + serverModified + '\'' +
                ", rev='" + rev + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                '}';
    }
}

