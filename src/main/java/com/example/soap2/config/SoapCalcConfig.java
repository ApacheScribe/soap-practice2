package com.example.soap2.config;

import com.example.soap2.client.CalcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapCalcConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.example.soap2.wsdl");
        return jaxb2Marshaller;
    }

    @Bean
    public CalcClient clientConnector(Jaxb2Marshaller jaxb2Marshaller) {
        CalcClient client = new CalcClient();
        client.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        client.setMarshaller(jaxb2Marshaller);
        client.setUnmarshaller(jaxb2Marshaller);
        return client;
    }
}
