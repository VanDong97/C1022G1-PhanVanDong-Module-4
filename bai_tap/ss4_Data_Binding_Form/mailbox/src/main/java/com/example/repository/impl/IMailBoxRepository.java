package com.example.repository.impl;

import com.example.model.MailBox;

public interface IMailBoxRepository {

    MailBox mailBox ();

    void updateMail(MailBox mailBox);
}
