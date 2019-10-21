package com.example.fullstack.repository;

import com.example.fullstack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //find by + userName
    Optional<User> findByUserName(String userNamme);


}
