package ru.moskalets.chapter004.httpprotocol;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс производит валидацию данных.
 */
public class ValidateService {

    /**
     * INSTANCE
     */
    private static final ValidateService INSTANCE = new ValidateService();

    /**
     * memoryStore
     */
    private final MemoryStore memoryStore = MemoryStore.getInstance();

    /**
     * Конструктор.
     */
    private ValidateService() {
    }

    /**
     * Возвращает INSTANCE.
     * @return
     */
    public static ValidateService getInstance() {
        return INSTANCE;
    }

    /**
     * Проверяет не существует ли пользователя с такими же данными и добавляет если не существует.
     * @param user
     */
    public void add(User user) {
        if (!this.memoryStore.findAll().contains(user)) {
            this.memoryStore.add(user);
        }

    }

    /**
     * Находит пользователя по id и изменяет его данные.
     * @param id
     * @param name
     * @param login
     * @param email
     */
    public void update(int id, String name, String login, String email) {
        if (this.memoryStore.findAll().containsKey(id)) {
            this.memoryStore.update(id, name, login, email);
        }
    }

    /**
     * Находит пользователя по id и удаляет его.
     * @param id
     */
    public void delete(int id) {
        if (this.memoryStore.findAll().containsKey(id)) {
            this.memoryStore.delete(id);
        }
    }

    /**
     * Возвращает map со всеми пользователями.
     * @return
     */
    public ConcurrentHashMap<Integer, User> findAll() {
        return memoryStore.findAll();
    }

    /**
     * Возвращает пользователя по id, если он существует.
     * @param id
     * @return
     */
    public User findById(int id) {
        User user = null;
        if ((this.memoryStore.findAll().containsKey(id))) {
            user = this.memoryStore.findById(id);
        }
        return user;
    }
}