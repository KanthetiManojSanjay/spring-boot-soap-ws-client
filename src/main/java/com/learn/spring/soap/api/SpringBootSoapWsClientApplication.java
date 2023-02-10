package com.learn.spring.soap.api;

import com.learn.spring.soap.api.client.SoapClient;
import com.learn.spring.soap.api.loaneligibility.Acknowledgement;
import com.learn.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootSoapWsClientApplication {

    @Autowired
    private SoapClient soapClient;

    public static void main(String[] args) {
        SpringApplication.run(com.learn.spring.soap.api.SpringBootSoapWsClientApplication.class, args);
    }


    @PostMapping("/getLoanStatus")
    public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest customerRequest) {
        return soapClient.getLoanStatus(customerRequest);
    }


}
