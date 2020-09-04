/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendEmail {


final String emailSMTPserver = "smtp.gmail.com";
final String emailServerPort = "465"; 

JFrame Frame ; 



JTextField email ;  
JPasswordField p ; 
String des ;  
JTextField sujet; 
JTextArea Body ; 
  public SendEmail(JFrame Frame,JTextField email,JPasswordField p,String des,JTextField sujet,JTextArea Body
  ){
   
  // Receiver Email Address 
  this.Frame=Frame;
  this.email=email; 
  // Subject
  this.sujet=sujet;
  // Body
  this.Body=Body; 
  this.des=des; 
  this.p=p ; 
  Properties props = new Properties();
  props.put("mail.smtp.user",email.getText());
  props.put("mail.smtp.host", emailSMTPserver);
  props.put("mail.smtp.port", emailServerPort);
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.socketFactory.port", emailServerPort);
  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.socketFactory.fallback", "false");
  SecurityManager security = System.getSecurityManager();
  try{  
  Authenticator auth = new SMTPAuthenticator();
  Session session = Session.getInstance(props, auth);
  MimeMessage msg = new MimeMessage(session);
  msg.setText(Body.getText());
  msg.setSubject(sujet.getText());
  msg.setFrom(new InternetAddress(email.getText()));
  msg.addRecipient(Message.RecipientType.TO,
  new InternetAddress(des));
  Transport.send(msg);
  JOptionPane.showMessageDialog(Frame,"le message a été envoyé avec succès"); }
  
  catch (Exception mex){
    mex.printStackTrace();  
     JOptionPane.showMessageDialog(Frame,mex.getMessage());
   
  } 
  
  
  
  }
  public class SMTPAuthenticator extends javax.mail.Authenticator
  {
  public PasswordAuthentication getPasswordAuthentication()
  {
  return new PasswordAuthentication(email.getText(),p.getText());
  }
  }
     }
