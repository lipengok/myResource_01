package com.lp.mail_demo.mail.real;

import com.lp.mail_demo.mail.MailFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 发送简单的邮件
 *
 * @Author lipeng
 * @Date 2023/7/4 9:23
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleMail implements MailFactory {


    @Autowired
    private JavaMailSender javaMailSender;

    private SimpleMailMessage message = new SimpleMailMessage();

    //发送人(和配置文件中一致)
    private String from;
    //接收人
    private String to;
    //标题
    private String subject;
    //正文
    private String context;

    @Override
    public void sendMail() {
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }

}
