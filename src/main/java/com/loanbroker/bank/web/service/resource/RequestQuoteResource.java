package com.loanbroker.bank.web.service.resource;

import com.loanbroker.bank.web.service.ConnectionFactoryBuilder;
import com.loanbroker.bank.web.service.model.QuoteRequest;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("quote")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RequestQuoteResource {

    @Autowired
    RabbitTemplate template;

    @PostMapping
    public Response getQuote(@Valid QuoteRequest quoteRequest) {
        // Do something with the quote here. Map it to a QuoteResponse object.

        // Replace uri in the create call with uri from quoteRequest
        // This piece of code sets the factory of the template to the url specified from the request
        ConnectionFactory factory = ConnectionFactoryBuilder.create("amqp://guest:guest@localhost:5672/");
        template.setConnectionFactory(factory);

        return Response.ok().build();
    }

}
