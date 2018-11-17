package com.loanbroker.bank.web.service.resource;

import com.loanbroker.bank.web.service.BankWebServiceApplication;
import com.loanbroker.bank.web.service.model.QuoteRequest;
import com.loanbroker.bank.web.service.model.QuoteResponse;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Properties;


@RestController
@RequestMapping("quote")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RequestQuoteResource {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    MessageConverter messageConverter;

    @Autowired
    RabbitAdmin rabbitAdmin;

    @PostMapping
    public QuoteResponse getQuote(@RequestBody @Valid QuoteRequest quoteRequest) {
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
        Properties prop = rabbitAdmin.getQueueProperties(quoteRequest.getReplyTo());
        if (prop == null) {
            Queue queue = new Queue(quoteRequest.getReplyTo(), true, false, true);
            rabbitAdmin.declareQueue(queue);
            Binding binding = new Binding(quoteRequest.getReplyTo(), Binding.DestinationType.QUEUE, BankWebServiceApplication.exchange, quoteRequest.getReplyTo(), null);
            rabbitAdmin.declareBinding(binding);
        }
        MessageProperties properties = new MessageProperties();
        properties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        Message message = messageConverter.toMessage(quoteResponse, properties);
        template.setQueue(quoteRequest.getReplyTo());
        template.send(quoteRequest.getReplyTo(), message);
        return quoteResponse;
    }
}
