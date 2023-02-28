package com.example.service.impl;

import com.example.model.MailBox;

public interface IMailBoxService {

    MailBox mailBox();

    void updateEmail(MailBox mailBox);
}
