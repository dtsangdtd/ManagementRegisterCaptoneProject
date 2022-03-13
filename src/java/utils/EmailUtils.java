/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import request.RequestDTO;

/**
 *
 * @author mac
 */
public class EmailUtils {

    private static final String USERNAME = "kiennhse150691@fpt.edu.vn";
    private static final String PASSWORD = "HieuKien123";

    public static boolean send(String email) {
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.ssl.trust", "*");
            
//            Properties prop = new Properties();
//            prop.put("smtp.office365.com", "587");
//            prop.put("mail.smtp.auth", true);
//            prop.put("mail.smtp.starttls.enable", true);
//            prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//            prop.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("kiennhse150691@fpt.edu.vn"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Request to Group");
            message.setText("ID: " + email + "\n"
                    + " have a request to your Capstone Group" + "\n"
                    + " Please check your request!");

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
