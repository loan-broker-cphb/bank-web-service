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
import java.util.List;
import java.util.Random;
import org.springframework.amqp.core.Queue;
import org.springframework.scheduling.annotation.Scheduled;


@RestController
@RequestMapping("quote")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RequestQuoteResource {

    @Bean
    public Queue hello() {
        return new Queue("JsonBank");
    }

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;
    @PostMapping
    public QuoteResponse getQuote(@RequestBody QuoteRequest quoteRequest) {
        // Do s mething with the quote here. Map it to a QuoteResponse object.

    int ssn = quoteRequest.getSsn();
    int creditScore = quoteRequest.getCreditScore();
    double loanAmount = quoteRequest.getLoanAmount();
    int loanDurationMount = quoteRequest.getLoanDuration();
    double interstRate ;

    double x = (Math.random() * (4.0))+2;
    double y = (Math.random() * (2.0));

    if (creditScore < 500 && loanAmount < 360) {
        interstRate = 2.5;
    } else if (creditScore >= 500 && loanAmount < 360) {
        interstRate = x;
    } else if (creditScore >= 500 && loanAmount > 360) {
        interstRate = y;
    } else {
        interstRate = 3.5;
    }
        QuoteResponse quoteResponse = new QuoteResponse(interstRate,ssn);
        // Replace uri in the create call with uri from quoteRequest
        // This piece of code sets the factory of the template to the url specified from the request
        ConnectionFactory factory = ConnectionFactoryBuilder.create("amqp://guest:guest@localhost:5672/");
        template.setConnectionFactory(factory);
        template.convertAndSend(queue.getActualName(),quoteResponse);
        return quoteResponse;
    }
}
