# bank-web-service
Bank web service

To send request to the bank and to get the bank response to rabbit mq, we shall do:

- Run program
- On the Loan broker project file, open gitbash: docker-compose up rabbitmq 
- On http://localhost:15672 (username: guest, pasword:guest) you can se RabbbitMQ mangment page
- With postman You can send a json to the url that runs on: http://localhost:8091/quote
- In rabbitmq management under Exchange in "replyto.exch" you can see the Routing key sent by postman
- When you send a message, in Channels under overview in RabbitMQ management page, you can see the message rates diagram

# Screenshots
Then there are some screenshots:
- where in the project I have added port 8091
- postman
- RabbitMQ mangment Chanels and Exchanges


![image](https://user-images.githubusercontent.com/20173643/48667407-15d4c780-ead5-11e8-9ca1-1f7f33c4d7f6.png)

![image](https://user-images.githubusercontent.com/20173643/48667423-664c2500-ead5-11e8-894b-9c7c2ab5c7ec.png)

![image](https://user-images.githubusercontent.com/20173643/48667434-a6aba300-ead5-11e8-9d8e-f67054ac3b62.png)

![image](https://user-images.githubusercontent.com/20173643/48667446-02762c00-ead6-11e8-8fbd-258203085f7b.png)

![image](https://user-images.githubusercontent.com/20173643/48667455-597c0100-ead6-11e8-992f-2fa70a4011f0.png)