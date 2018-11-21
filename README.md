# bank-web-service
Bank web service

# Calculatation of interest rate

InterstRate | CREDIT SCORE | LOAN AMOUNT  | LoanDuration |ROUTING KEY |
------|-------------|---------------|-------------|-------------| 
 `1` | `< 500 ` | `<= 10000 `  | `<= 365*30` | `G4_JSON` |
  `Math.random() * (2.0)` | `>= 500 ` | `<= 10000`  | `<=365*30` | `G4_JSON` |
 `Math.random() * (2.0)+0.25` | `>= 500 && < 900 ` | `>= 10000 && <= 20000`  | `<=365*30 && <750*30 ` | `G4_JSON` |
 `Math.random() * (2.0) +0.5` |`>= 500 && < 900 ` | `>= 20000 &&< 50000`  | `<=365*30 && <750*30` | `G4_JSON` |
`Math.random() * (2.0) +1` |`>= 500 && < 900 ` | `>= 50000 &&< 100000`  | `<=750*30 && <1365*30` | `G4_JSON` |
`Math.random() * (2.0) +1.25` |`>= 500 && < 900 ` | `>= 50000 &&< 100000`  | `>1365*30 && <2000*30` | `G4_JSON` |
 `1` | `otherwise`| `otherwise`| `otherwise` |`G4_JSON` |
 `-1` | `otherwise` | `otherwise`| `otherwise`| `otherwise`|
 
To send request to the bank and to get the bank response to rabbit mq, we shall do:

- Run program
- On the Loan broker project file, open gitbash: docker-compose up rabbitmq 
- On http://localhost:15672 (username: guest, pasword:guest) you can se RabbbitMQ mangment page
- With postman You can send a json to the url that runs on: http://localhost:8091/quote
- In rabbitmq management under Exchange in "replyto.exch" you can see the Routing key sent by postman
- When you send a message, in Channels under overview in RabbitMQ management page, you can see the message rates diagram

# Screenshots
Then there are some screenshots:
- postman
- RabbitMQ mangment Channels and Exchanges
(Respectively)


![image](https://user-images.githubusercontent.com/20173643/48667423-664c2500-ead5-11e8-894b-9c7c2ab5c7ec.png)

![image](https://user-images.githubusercontent.com/20173643/48667434-a6aba300-ead5-11e8-9d8e-f67054ac3b62.png)

![image](https://user-images.githubusercontent.com/20173643/48667446-02762c00-ead6-11e8-8fbd-258203085f7b.png)

![image](https://user-images.githubusercontent.com/20173643/48667455-597c0100-ead6-11e8-992f-2fa70a4011f0.png)
