package com.music.school.utils;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class EmailSender {

    private String host = "smtp.sendgrid.net";
    private String user = "apikey";
    private String password = "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";

    private Properties setupMailServerProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        return properties;
    }

//    public void sendEmail(List<String> recipients, String subject, String body) {
//        Properties properties = setupMailServerProperties();
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(user, password);
//            }
//        });
//
//        try {
//            for (String recipient : recipients) {
//                MimeMessage message = new MimeMessage(session);
//                message.setFrom(new InternetAddress(user));
//                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//                message.setSubject(subject);
//                message.setText(body);
//                Transport.send(message);
//                System.out.println("Sent message successfully to " + recipient);
//            }
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }

    public void sendEmail(List<String> recipients, String subject, String body) throws IOException {
        Email from = new Email("snandhakumar96@gmail.com");
//        for (String recipient : recipients) {
//            Email to = new Email(recipient);
//            Content content = new Content("text/plain", body);
//            Mail mail = new Mail(from, subject, to, content);
//        }
        Email to = new Email("snandhakumar96@gmail.com");
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }

    }

}
