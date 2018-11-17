package com.loanbroker.bank.web.service;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.support.converter.*;



@SpringBootApplication
public class BankWebServiceApplication {

    public static final String exchange = "replyto.exch";
    public static void main(String[] args) {
        SpringApplication.run(BankWebServiceApplication.class, args);
    }

    @Bean
    DirectExchange exchange () {
        return new DirectExchange(exchange);
    }

    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory factory) {
        return new RabbitAdmin(factory);
    }

    @Bean
    MessageConverter messageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        return converter;
    }
}
