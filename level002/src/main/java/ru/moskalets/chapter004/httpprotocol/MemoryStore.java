package ru.moskalets.chapter004.httpprotocol;

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
        counter.incrementAndGet();
        user.setId(counter.get());
        this.users.put(counter.get(), user);
    }

    @Override
    public void update(int id, String name, String login, String email) {
        User user = this.users.get(id);
        user.updateUser(name, login, email);
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
}