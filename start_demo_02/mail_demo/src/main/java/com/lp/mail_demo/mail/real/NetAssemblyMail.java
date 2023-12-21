package com.lp.mail_demo.mail.real;

import com.lp.mail_demo.mail.MailFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * 发送网页正文邮件
 * @Author lipeng
 * @Date 2023/7/4 9:44
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetAssemblyMail implements MailFactory {

    @Autowired
    private JavaMailSender javaMailSender;

    //发送人和配置文件中一致
    private String from;
    //接收人
    private String to;
    //标题
    private String subject;
    //正文
    // private String context = "<img src='ABC.JPG'/><a href='https://blog.csdn.net/weixin_47343544?type=blog'>跳转链接</a>";
    private String context;

    public void sendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            //此处设置正文支持html解析
            helper.setText(context,true);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
