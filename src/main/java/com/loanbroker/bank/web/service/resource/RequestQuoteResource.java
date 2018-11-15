package com.loanbroker.bank.web.service.resource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.loanbroker.bank.web.service.ConnectionFactoryBuilder;
import com.loanbroker.bank.web.service.model.QuoteRequest;
import com.loanbroker.bank.web.service.model.QuoteResponse;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;


@RestController
@RequestMapping("quote")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RequestQuoteResource {

    @Autowired
    private RabbitTemplate template;


    @PostMapping
    public QuoteResponse getQuote(@RequestBody QuoteRequest quoteRequest) {
        // Do something with the quote here. Map it to a QuoteResponse object.
       QuoteRequest q= quoteRequest;
    int ssn = q.getSsn();
    System.out.print("HER IS :  "+ssn +"\n");
    int creditScore = q.getCreditScore();
    double loanAmount = q.getLoanAmount();
    int loanDurationMount = q.getLoanDurationMount();
        System.out.print("HER ISss :  "+loanDurationMount);
    double interstRate ;
    double x = (Math.random() * (10.0));
    double y = (Math.random() * (50.0));
    if (creditScore < 600 && loanAmount < 360) {
        interstRate = 7.5;
    } else if (creditScore >= 600 && loanAmount > 360) {
        interstRate = x;
    } else if (creditScore >= 600 && loanAmount < 360) {
        interstRate = y;
    } else {
        interstRate = 10.0;
    }
        QuoteResponse quoteResponse = new QuoteResponse(interstRate,ssn);
        // Replace uri in the create call with uri from quoteRequest
        // This piece of code sets the factory of the template to the url specified from the request
       ConnectionFactory factory = ConnectionFactoryBuilder.create("amqp://guest:guest@localhost:5672/");
        /*template.setConnectionFactory(factory);
        template.convertAndSend(quoteResponse);*/
        return quoteResponse;
    }



}
