package ru.moskalets.spring.section001.task001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public class UserStorage {
    private static final Logger LOG = LoggerFactory.getLogger(UserStorage.class);

    private final Storage storage;


    public  UserStorage(final Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }

    public List<User> getAll() {
        return this.storage.getAll();
    }
}