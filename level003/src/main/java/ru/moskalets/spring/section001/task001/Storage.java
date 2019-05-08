package ru.moskalets.spring.section001.task001;

import java.util.List;

public interface Storage {
    void add(User user);
    List<User> getAll();
}