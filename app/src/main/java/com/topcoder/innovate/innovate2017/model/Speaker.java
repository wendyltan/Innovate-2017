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
        this.picture = picture;
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
