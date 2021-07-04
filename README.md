# Notification-service
- A simple diagram of the architecture.
  
    - [The simplest architecture](images/basic-architecture.png) <br>
    - [Class diagram](images/class%20diagram.png) <br>
    - [Class diagram with dependencies](images/dependency-architecture.png)


- How to run it:
    - mvn clean install package
    - mvn spring-boot:run

    <br> Use this curl to check if service is up and running:<br>
        <code>curl --location --request GET 'localhost:8080/v1/health'</code>


- How another microservice would contact this service to send a notification:<br>
    1. By making an api call (if we need to send some OTP/high priority notification): <br>
       `curl --location --request POST 'localhost:8080/v1/notification/' --header 'Content-Type: application/json'
       --data-raw '{ "notificationType": "SMS", "text": "text", "usersMetadata": { "234": { "phoneNumber": 123123 } } }'`
    2. In the production environment, it will be better for the producer service to publish the notification request to 
       Queue system(RabbitMq/Sqs) and this service will be the consumer


- Future improvements:
    - For Bulk notification, retry only for specific users, in case of Queue system, we can re-seed the data with 
      only the failed users and finally push such data to DLQ after 3 re-tries.
    - Use templates in this service, the caller service will provide template-id
    - Add limitations at max number of users supported to send notification in a single api call  
    - Add support for placeholders
    - Add more sources, apart from SMS, Push notifications
    - In case of uneven load for different type of notifications, we can divide this service into SMS service 
      and notification service
