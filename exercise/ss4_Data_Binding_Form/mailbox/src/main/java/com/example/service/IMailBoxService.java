package com.example.service;

import com.example.model.MailBox;

import java.util.List;

public interface IMailBoxService {

    List<String> listLanguages();

    List<String> listPageSize();

    MailBox mailBox();

    void updateEmail(MailBox mailBox);
}
