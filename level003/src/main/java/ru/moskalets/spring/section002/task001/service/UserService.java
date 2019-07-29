package ru.moskalets.spring.section002.task001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.moskalets.spring.section002.task001.models.UserSpring;
import ru.moskalets.spring.section002.task001.stores.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserSpring findByLogin(String login) {
       return userRepository.findByLogin(login);
    }
}