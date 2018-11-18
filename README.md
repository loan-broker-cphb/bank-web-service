# bank-web-service
Bank web service

To sending request to the bank and the bank send response to rabbit mq we shall do:

- Run program
- On the Loan broker project file you open gitbash: docker-compose up rabbitmq 
- On http://localhost:15672(username guest, pasword guest) you can se RabbbitMQ mangment page
- With postman You can send a json to the url that runs on: http://localhost:8090/quote
- In rabbitmq mangment under Exchange in "replyto.exch" you can see the Routing key sent by postman
- In Chanels under overview, you can see when you send a message

# Screenshots
Then there are some screenshots:
- where in the project I have added port 8090
- postman
- RabbitMQ mangment Chanels and Exchanges


