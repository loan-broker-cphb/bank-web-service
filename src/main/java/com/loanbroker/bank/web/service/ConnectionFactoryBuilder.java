package com.loanbroker.bank.web.service;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import java.net.URISyntaxException;

public class ConnectionFactoryBuilder {
    public static ConnectionFactory create(String uri) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUri(uri);
        return connectionFactory;
    }
}
