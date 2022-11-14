package com.robosoft.internmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
<<<<<<< HEAD
import org.springframework.jdbc.core.JdbcTemplate;
=======
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
<<<<<<< HEAD
public class EmailService
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public boolean sendEmail(String toEmail)
    {
=======
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    public boolean sendMail(String toEmail){
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93

        boolean flag = false;

        String host = "smtp.gmail.com";
        String subject = "OTP from Intern Management";

        Random random = new Random();
        int otp;

<<<<<<< HEAD
        do
        {
            otp = random.nextInt(9999);
        }
        while(String.valueOf(otp).length() < 3);
=======
        do {
            otp = random.nextInt(9999);
        } while(String.valueOf(otp).length() < 3);
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93


        String message = "Please use OTP " + otp + " for your account password reset request";

<<<<<<< HEAD
        try
        {
=======
        try {
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(toEmail);
            mailMessage.setSubject(subject);
            mailMessage.setText(message);

            javaMailSender.send(mailMessage);
<<<<<<< HEAD
            String OTP=String.valueOf(otp);
            try
            {
                jdbcTemplate.queryForObject("select otp from user where emailId=?", String.class,toEmail);
                jdbcTemplate.update("update user set otp=?,expireTime=? where emailId=?",OTP,(System.currentTimeMillis()/1000)+120,toEmail);
            }
            catch (Exception e)
            {
                insert(toEmail,OTP);
            }
            flag = true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
=======

            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally{
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
            return flag;
        }

    }

<<<<<<< HEAD
    public void insert(String emailId,String code)
    {
        jdbcTemplate.update("insert into forgotPassword values (?,?,?,?)",emailId,null,code,(System.currentTimeMillis()/1000)+120);
    }


    public String verification(String emailId,String otp)
    {
        String verify=jdbcTemplate.queryForObject("select otp from forgotPassword where emailId=?", String.class,emailId);
        System.out.println(verify);
        System.out.println(otp);
        if(otp.equals(verify))
        {
            return "Done";
        }
        return "Invalid OTP";
    }
=======
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
}
