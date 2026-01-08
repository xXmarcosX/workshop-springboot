package com.marcos.store.config;

import com.marcos.store.models.User;
import com.marcos.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria", "maria@gmail.com", "11111111", "123456");
        User user2 = new User(null, "Mario", "mario@gmail.com", "22222222", "456789");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
