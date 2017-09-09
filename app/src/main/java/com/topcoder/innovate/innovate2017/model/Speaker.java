package com.topcoder.innovate.innovate2017.model;

/**
 * Created by Wendy on 2017/9/6.
 */

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Speaker implements Serializable {

    private String name;

    private String title;

    private String picture;

    private String details;

    private int picID;

    private List<String> sessionIds;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        String[] tmp = picture.split("\\.")[0].split("/");
        this.picture = tmp[tmp.length-1];
        if(this.picture.toString().charAt(0)>='0'&&this.picture.toString().charAt(0)<='9'){
            this.picture = "x"+this.picture;
        }
        this.picture = this.picture.replaceAll("-","_");
        this.picture = this.picture.toLowerCase();
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }

    public int getPicID() {
        return picID;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getSessionIds() {
        return this.sessionIds;
    }

    public void setSessionIds(List<String> sessionIds) {
        this.sessionIds = sessionIds;
    }
}
