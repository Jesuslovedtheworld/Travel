package com.baidu.traveleverywhere.bean;

public class SaveUserName {
    private String userName;
    private String userId;
    private String iconurl;//头像

    @Override
    public String toString() {
        return "SaveUserName{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", iconurl='" + iconurl + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public SaveUserName() {
    }

    public SaveUserName(String userName, String userId, String iconurl) {
        this.userName = userName;
        this.userId = userId;
        this.iconurl = iconurl;
    }
}
