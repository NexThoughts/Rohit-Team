package com.nexthoughts.tracker.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.nexthoughts.tracker.classes.MailCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

    @Autowired
    JavaMailSender mailSender;

    public void send(MailCommand mailCommand) {
        System.out.println("_________________++++++++++++++++++++++++++++++---Done---");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
        try {
            mailMsg.setFrom("rohit@nexthoughts.com");
            mailMsg.setTo((mailCommand.getTo().length()>0) ? mailCommand.getTo() : "");
            mailMsg.setSubject((mailCommand.getSubject().length()>0) ? mailCommand.getSubject() : "");
            mailMsg.setText((mailCommand.getContent().length()>0) ? mailCommand.getContent() : "");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---Done---");
    }

}
