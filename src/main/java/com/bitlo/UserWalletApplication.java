package com.bitlo;

import com.bitlo.model.User;
import com.bitlo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UserWalletApplication {

    public static void main(String[] args) {
        //SpringApplication.run(UserWalletApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(UserWalletApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        BCryptPasswordEncoder encoder = context.getBean(BCryptPasswordEncoder.class);


        List<User> users = new ArrayList<>();

        users.add(new User("Mevlüt", "Beder", "mevlut1", encoder.encode("123"), "mev@bitlo.com"));
        users.add(new User("Ahmet", "Demir", "ahmet1", encoder.encode("1234"), "ahmet@bitlo.com"));
        users.add(new User("Mehmet", "Çelik", "mehmet1", encoder.encode("12345"), "mehmet@bitlo.com"));

        userRepository.saveAll(users);

        //encoder.matches("123", user.getPassword());


    }


}
