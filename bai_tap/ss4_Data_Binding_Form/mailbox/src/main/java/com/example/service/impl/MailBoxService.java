package com.example.service.impl;

import com.example.model.MailBox;
import com.example.repository.IMailBoxRepository;
import com.example.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxService implements IMailBoxService {

    @Autowired
    private IMailBoxRepository iMailBoxRepository;

    @Override
    public List<String> listLanguages() {
        return iMailBoxRepository.listLanguages();
    }

    @Override
    public List<String> listPageSize() {
        return iMailBoxRepository.listPageSize();
    }

    @Override
    public MailBox mailBox() {
        return iMailBoxRepository.mailBox();
    }

    @Override
    public void updateEmail(MailBox mailBox) {
        iMailBoxRepository.updateMail(mailBox);
    }
}
