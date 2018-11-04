package ru.moskalets.chapter004.httpprotocol;

import java.util.List;
import java.util.Map;

public interface Validate {

    void add(User user);

    void update(User user);

    void delete(int id);

    User findById(int id);

    Map<Integer, User> findAll();

    User isCredentional(String login, String password);

    List getAllRoles();
}