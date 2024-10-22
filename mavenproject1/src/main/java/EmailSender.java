package com.mycompany.mavenproject1;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public static void main(String[] args) {

        String to = "raushan995511@gmail.com"; 

        // Sender's email ID
        String from = "raushanmansagar12345@gmail.com"; 
        final String username = from;
        final String password = "ppqv zdri rqjl ftjw"; // Use an app-specific password if needed

        // Using Gmail SMTP server
        String host = "smtp.gmail.com";

        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // For TLS

        // Get the Session object
        Session session = Session.getInstance(properties,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From header
            message.setFrom(new InternetAddress(from));

            // Set To header
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject
            message.setSubject("Test Subject");

            // Set email content with proper message
            message.setText("Hi, this is a test email!");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}