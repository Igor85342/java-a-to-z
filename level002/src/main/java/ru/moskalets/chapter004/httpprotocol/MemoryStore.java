package ru.moskalets.chapter004.httpprotocol;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Реализует хранилище пользователей в map.
 */
public class MemoryStore implements Store {

    /**
     * users
     */
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    /**
     * INSTANCE
     */
    private static final MemoryStore INSTANCE = new MemoryStore();

    /**
     * counter
     */
    private final AtomicInteger counter = new AtomicInteger(0);

    /**
     * Конструктор.
     */
    private MemoryStore() {
    }

    /**
     * Возвращает INSTANCE.
     * @return
     */
    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        user.setId(counter.incrementAndGet());
        this.users.put(counter.get(), user);
    }

    @Override
    public void update(User userUpdate) {
    User user = this.users.get(userUpdate.getId());
    user.updateUser(userUpdate.getLogin(), userUpdate.getPassword(), userUpdate.getRole());
}

    @Override
    public void delete(int id) {
        this.users.remove(id);
    }

    @Override
    public ConcurrentHashMap<Integer, User> findAll() {
        return this.users;
    }

    @Override
    public User findById(int id) {
        return this.users.get(id);
    }

    @Override
    public User isCredentional(String login, String password) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }
}