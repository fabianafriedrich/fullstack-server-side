package com.example.fullstack.service;

import com.example.fullstack.model.User;
import com.example.fullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    //It will be provided later with Spring @Bean.
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User saveUser(final User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //save = create or update
    @Override
    public User updateUser(final User user){
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(final Long userId){
        userRepository.deleteById(userId);
    }

    @Override
    public User findByUserName(final String username){
        return userRepository.findByUserName(username).orElse(null);
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public Long numberOfUsers(){
        return userRepository.count();
    }
}
