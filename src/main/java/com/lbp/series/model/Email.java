package com.lbp.series.model;

import com.lbp.series.service.EmailService;
import com.lbp.series.service.impl.EmailServiceImpl;

import java.util.Map;

public class Email {
    private String to;
    private String from;
    private String body;
    private String subject;
    private Map<String, String> headers;

    private Email() {}

    public static class EmailBuilder{
        private String from_;
        private String to_;
        private Map<String, String> headers_;

        public EmailBuilder addFrom(String from){
            this.from_ = from;
            return this;
        }

        public EmailBuilder addTo(String to){
            this.to_ = to;
            return this;
        }

        public EmailBuilder addHeaders(Map<String,String> headers)
        {
            this.headers_ = headers;
            return this
                    ;
        }

        public Email build(){
            Email email = new Email();
            email.to = this.to_;
            email.from = this.from_;
            email.headers = this.headers_;
            return email;
        }




    }

}
