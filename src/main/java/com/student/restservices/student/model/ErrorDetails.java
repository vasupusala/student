package com.student.restservices.student.model;

import java.util.Date;

public class ErrorDetails {
    private Date timeStamp;
    private String messages;
    private String details;

    public ErrorDetails(Date timeStamp, String messages, String details) {
        this.timeStamp = timeStamp;
        this.messages = messages;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessages() {
        return messages;
    }

    public String getDetails() {
        return details;
    }
}
