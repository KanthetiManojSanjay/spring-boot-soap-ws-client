package com.learn.spring.soap.api.client;

import com.learn.spring.soap.api.loaneligibility.Acknowledgement;
import com.learn.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author kansanja on 10/02/23.
 */
@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public Acknowledgement getLoanStatus(CustomerRequest customerRequest) {
        template = new WebServiceTemplate(marshaller);
        Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws", customerRequest);
        return acknowledgement;
    }
}
