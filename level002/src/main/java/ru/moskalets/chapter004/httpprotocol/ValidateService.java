package ru.moskalets.chapter004.httpprotocol;

import java.util.Map;
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
     * store
     */
    private final Store store = DbStore.getInstance();
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
            this.store.add(user);
    }

    /**
     * Находит пользователя по id и изменяет его данные.
     * @param user
     */
    public void update(User user) {
            this.store.update(user);
    }

    /**
     * Находит пользователя по id и удаляет его.
     * @param id
     */
    public void delete(int id) {
            this.store.delete(id);
    }

    /**
     * Возвращает map со всеми пользователями.
     * @return
     */
    public Map<Integer, User> findAll() {
        Map<Integer, User> result = null;
        try {
            result = this.store.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Возвращает пользователя по id, если он существует.
     * @param id
     * @return
     */
    public User findById(int id) {
        User user = null;
        if ((this.store.findAll().containsKey(id))) {
            user = this.store.findById(id);
        }
        return user;
    }
}