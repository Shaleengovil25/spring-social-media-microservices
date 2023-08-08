package com.microservicedemo.usersservice.model;

public class Users {

    private int userId;
    private String userName;
    private String userContact;
    public Users(int userId, String userName, String userContact, Posts post, Notifications notifications) {
        this.userId = userId;
        this.userName = userName;
        this.userContact = userContact;
        this.post = post;
        this.notifications = notifications;
    }
    private Posts post;
    private Notifications notifications;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserContact() {
        return userContact;
    }
    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }
    public Posts getPost() {
        return post;
    }
    public void setPost(Posts post) {
        this.post = post;
    }
    public Notifications getNotifications() {
        return notifications;
    }
    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    
   


}
