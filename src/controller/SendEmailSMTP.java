package controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import view.CreateAccount;

import java.util.Properties;

public class SendEmailSMTP {

    public static void sendOTP(String emailTo, String otp) {
    	String username = "vie24082005@gmail.com";
        String password = "ranksssfhpzaihci";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            message.setSubject("Mã xác thực email từ Admin!\n");
            message.setText("Mã xác nhận của bạn là: " + otp);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}