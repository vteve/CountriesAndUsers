package com.example.exam.repository;


import com.example.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAgeGreaterThanEqualOrderByFirstName(Integer age);
}

