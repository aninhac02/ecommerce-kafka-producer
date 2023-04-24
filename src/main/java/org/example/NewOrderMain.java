package org.example;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (var dispatcher = new KafkaDispatcher()){
            var key = UUID.randomUUID().toString();
            var order = key + ", userId, orderValue";
            var email = "Thanks for your order! We are processing it";

            dispatcher.send("ECOMMERCE_NEW_ORDER", key, order);
            dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
        }

    }
}