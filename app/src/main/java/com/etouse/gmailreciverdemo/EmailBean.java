package com.etouse.gmailreciverdemo;

/**
 * Created by Administrator on 2017/6/7.
 */

public class EmailBean {
    private int icon;
    private String title;
    private String description;
    private String timer;
    private boolean isChoosed;

    public EmailBean(int icon, String title, String description, String timer, boolean isChoosed) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.timer = timer;
        this.isChoosed = isChoosed;
    }

    public EmailBean(int icon, String title, String description, String timer) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.timer = timer;
    }

    public void setChoosed(boolean choosed) {
        isChoosed = choosed;
    }

    public boolean isChoosed() {

        return isChoosed;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTimer() {
        return timer;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }
}
