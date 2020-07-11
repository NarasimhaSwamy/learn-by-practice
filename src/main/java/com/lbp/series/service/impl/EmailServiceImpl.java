package com.lbp.series.service.impl;

import com.lbp.series.model.Email;
import com.lbp.series.service.EmailService;

public class EmailServiceImpl implements EmailService {
    @Override
    public void send(Email email) {

    }

    @Override
    public void sendPreview(Email email) {
        email.setTo(email.getFrom());
    }
}
