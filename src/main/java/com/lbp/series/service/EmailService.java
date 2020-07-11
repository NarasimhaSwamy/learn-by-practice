package com.lbp.series.service;

import com.lbp.series.model.Email;

public interface EmailService {
    void send(Email email);

    void sendPreview(Email email);
}
