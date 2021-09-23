package com.example.soap2.client;

import com.example.soap2.wsdl.Add;
import com.example.soap2.wsdl.AddResponse;
import com.example.soap2.wsdl.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;

public class CalcClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CalcClient.class);
    private String url = "http://www.dneonline.com/calculator.asmx";

    public int add(String url, Object request){

        AddResponse res = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback("http://tempuri.org/Add"));
        return res.getAddResult();
    }
}
