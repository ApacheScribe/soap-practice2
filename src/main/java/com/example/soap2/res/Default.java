package com.example.soap2.res;

import com.example.soap2.client.CalcClient;
import com.example.soap2.wsdl.Add;
import com.example.soap2.wsdl.AddResponse;
import com.example.soap2.wsdl.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Default {

    @Autowired
    CalcClient client;

    String url = "http://www.dneonline.com/calculator.asmx";
//    String url = "http://microsoft.com/webservices/";

    @GetMapping("/")
    String index(){
        return "hello world";
    }

    @GetMapping("/calc/addDemo")
    int addDemo(){
        ObjectFactory objectFactory = new ObjectFactory();
        Add a = objectFactory.createAdd();
        a.setIntA(1);
        a.setIntB(2);
        int response = client.add(url, a);
        return response;
    }
}
