package com.marcos.store.config;

import com.marcos.store.models.Order;
import com.marcos.store.models.User;
import com.marcos.store.repositories.OrderRepository;
import com.marcos.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria", "maria@gmail.com", "11111111", "123456");
        User user2 = new User(null, "Mario", "mario@gmail.com", "22222222", "456789");

        Order order1 = new Order(null, Instant.parse("2026-01-08T21:52:03Z"), user1);
        Order order2 = new Order(null, Instant.parse("2026-01-07T19:23:03Z"), user2);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2));
    }
}
