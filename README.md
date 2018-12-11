# POC Zipkin with Spring Cloud and Rabbit MQ

POC to test Spring Cloud using Rabbit MQ to delivery traces to Zipkin. 

# How to run

- Run **sudo docker-compose up** over disered **.yml** file founded on **docker** folder. OBS: remove ***docker-images.dimed.com.br:5000/*** from image to get it from Docker Hub.
 
- Run **poc-zipkin-service1** (https://github.com/vagner-nascimento/poc-zipkin-service1). It will be called here.

- Run **poc-zipkin-service2** (https://github.com/vagner-nascimento/poc-zipkin-service2). It will be called at **poc-zipkin-service1**.

- Build and ran application using gradle wrapper

- End-point: http://localhost:8080/zipkin/developers

# Utils
- Zipkin: https://zipkin.io/

- Rabbit MQ: https://www.rabbitmq.com/
