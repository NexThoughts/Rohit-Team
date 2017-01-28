package com.nexthoughts.tracker.classes;

import com.nexthoughts.tracker.classes.Enums.Enums;
import com.nexthoughts.tracker.model.User;
import com.nexthoughts.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class MailCommand {

//    @Autowired
//    private UserService userService;

    Enums.MailType mailType;
    String to;
    String subject;
    String content;

    String verificationToken;

    public Enums.MailType getMailType() {
        return mailType;
    }

    public void setMailType(Enums.MailType mailType) {
        this.mailType = mailType;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    String uuid = UUID.randomUUID().toString();


    public MailCommand() {
    }

    public MailCommand(String to, Enums.MailType mailType, String verificationToken) {
        this.to = to;
        this.mailType = mailType;
        this.verificationToken = verificationToken;
    }


    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMailContentAndSubject() {

        int code = this.mailType.getCode();

        switch (code) {
            case 1:
                System.out.println("---------------- SENDING USER REGISTRATION MAIL ------------------" + this.to);
                System.out.println("---------------- SENDING USER REGISTRATION MAIL ------------------" + this.to);
                this.setSubject("WELCOME");


                String link = "http://localhost:8070/register/verification?uuid=" + this.verificationToken;
                this.setContent("Hello User <br/> Welcome, Click on following link to Activate :" + link);
                break; // optional

            case 2:
                // Statements
                break; // optional
            case 3:
                // Statements
                break; // optional
            case 4:
                // Statements
                break; // optional

            // You can have any number of case statements.
            default: // Optional
                // Statements
        }

    }


}
