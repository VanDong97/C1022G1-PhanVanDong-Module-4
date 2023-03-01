package com.example.repository;

import com.example.model.MailBox;

import java.util.List;

public interface IMailBoxRepository {

    List<String> listLanguages();

    List<String> listPageSize();

    MailBox mailBox ();

    void updateMail(MailBox mailBox);
}
