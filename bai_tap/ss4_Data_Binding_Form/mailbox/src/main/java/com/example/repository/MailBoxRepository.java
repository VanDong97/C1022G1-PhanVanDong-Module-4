package com.example.repository;

import com.example.model.MailBox;
import com.example.repository.impl.IMailBoxRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MailBoxRepository implements IMailBoxRepository {

    private static MailBox mailBox;
    static {
        mailBox = new MailBox("English","25",true,"Thor, King, Asgard");
    }
    @Override
    public MailBox mailBox() {
        return mailBox;
    }

    @Override
    public void updateMail(MailBox mailBox) {
        mailBox.setLanguages(mailBox.getLanguages());
        mailBox.setPageSize(mailBox.getPageSize());
        mailBox.setSpamsFilter(mailBox().isSpamsFilter());
        mailBox.setSignature(mailBox.getSignature());
    }
}
