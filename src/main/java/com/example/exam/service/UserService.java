package com.example.exam.service;


import com.example.exam.entity.Country;
import com.example.exam.entity.User;
import com.example.exam.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    @PostConstruct
    public void addInTable() {
        if (userRepository.count() == 0) {
            List<String> strings = Stream.of("Alexander", "Daniel", "Vadim", "Alexey", "Gleb", "Tamerlan", "Vadim Xleb")
                    .toList();
            Country[] countries = Country.values();
            Random random = new Random();
            for (int i = 0; i < 7; i++) {
                User user = new User(strings.get(i), random.nextInt(18, 30), countries[i]);
                userRepository.save(user);
            }
        }
    }

    public List<User> getUsersByMinimumAge(Integer age) {
        return userRepository.findByAgeGreaterThanEqualOrderByFirstName(age);
    }
}

