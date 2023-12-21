package com.lp.mail_demo.mail;


/**
 * @Author lipeng
 * @Date 2023/7/4 9:20
 * @Version 1.0
 */
public class MailContext {

    private MailFactory mailFactory;

    public MailContext(MailFactory mailFactory){
        this.mailFactory = mailFactory;
    }

    public MailFactory getMailFactory(){
        return this.mailFactory;
    }
}
