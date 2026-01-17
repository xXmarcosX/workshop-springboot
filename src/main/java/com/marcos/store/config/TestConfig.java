package com.marcos.store.config;

import com.marcos.store.models.*;
import com.marcos.store.models.enums.OrderStatus;
import com.marcos.store.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        User user1 = new User(null, "Maria", "maria@gmail.com", "11111111", "123456");
        User user2 = new User(null, "Mario", "mario@gmail.com", "22222222", "456789");

        Order order1 = new Order(null, Instant.parse("2026-01-08T21:52:03Z"), OrderStatus.valueOf(2), user1);
        Order order2 = new Order(null, Instant.parse("2026-01-07T19:23:03Z"), OrderStatus.valueOf(1), user2);

        Product p1 = new Product(null, "Xbox", "lorem ipsum", 500.99, "url");
        Product p2 = new Product(null, "iPhone", "lorem ipsum", 700.99, "url2");

        productRepository.saveAll(Arrays.asList(p1, p2));

        p1.getCategories().add(c1);
        p2.getCategories().add(c1);

        productRepository.saveAll(Arrays.asList(p1, p2));
        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2));

        OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(order2, p2, 2, p2.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2));
    }
}
