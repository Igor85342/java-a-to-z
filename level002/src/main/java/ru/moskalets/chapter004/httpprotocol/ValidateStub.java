package ru.moskalets.chapter004.httpprotocol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateStub implements Validate {
//    private static final ValidateStub INSTANCE = new ValidateStub();
    private final Map<Integer, User> store = new HashMap<>();
    private int ids = 0;

//    public static ValidateStub getInstance() {
//        return INSTANCE;
//    }

    @Override
    public void add(User user) {
        user.setId(this.ids++);
        this.store.put(user.getId(), user);
//        return user;
    }

    @Override
    public void update(User user) {
        this.store.put(user.getId(), user);
    }

    @Override
    public void delete(int id) {
        this.store.remove(id);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
   public Map<Integer, User> findAll() {
        return this.store;
    }

    @Override
    public User isCredentional(String login, String password) {
        return null;
    }

    @Override
    public List getAllRoles() {
        return null;
    }
}