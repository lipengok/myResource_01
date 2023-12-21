package com.lp.mail_demo.mail.real;

import com.lp.mail_demo.mail.MailFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 发送网页正文邮件
 * @Author lipeng
 * @Date 2023/7/4 9:44
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnexAssemblyMail implements MailFactory {

    @Autowired
    private JavaMailSender javaMailSender;

    //发送人和配置文件中一致
    private String from;
    //接收人
    private String to;
    //标题
    private String subject;
    //正文
    private String context;

    public void sendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            //此处设置支持附件
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context);

            //添加附件
            File f1 = new File("springboot_mail-0.0.1-SNAPSHOT.jar");
            File f2 = new File("resources\\logo.png");

            helper.addAttachment(f1.getName(),f1);
            helper.addAttachment("陈老老老板",f2);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
