package com.nexthoughts.tracker.model;

import java.util.UUID;

public class NotificationQueue {

    private String emailTo;
    private String subject;
    private String content;
    private Boolean isRead;

    String uuid = UUID.randomUUID().toString();
}
