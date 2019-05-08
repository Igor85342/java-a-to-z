package ru.moskalets.spring.section001.task001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class MemoryStorage implements Storage {
    private static final Logger LOG = LoggerFactory.getLogger(MemoryStorage.class);

    private final ArrayList users = new ArrayList();

    public void add(User user) {
        users.add(user);
    }

    public List<User> getAll() {
        return this.users;
    }
}