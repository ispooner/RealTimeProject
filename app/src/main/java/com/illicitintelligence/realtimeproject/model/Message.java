package com.illicitintelligence.realtimeproject.model;

public class Message {

    private String messageTitle;
    private String messageDate;
    private String username;
    private String messageContent;

    public Message() {

    }

    public Message(String messageTitle, String messageDate, String username, String messageContent) {
        this.messageTitle = messageTitle;
        this.messageDate = messageDate;
        this.username = username;
        this.messageContent = messageContent;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
