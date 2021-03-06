package ru.moskalets.chapter004.httpprotocol;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс производит валидацию данных.
 */
public class ValidateService implements Validate {

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
    public static Validate getInstance() {
        return INSTANCE;
    }

    /**
     * Проверяет не существует ли пользователя с такими же данными и добавляет если не существует.
     * @param user
     */
    @Override
    public void add(User user) {
        if (!findAll().containsValue(user)) {
            this.store.add(user);
        }
    }

    /**
     * Находит пользователя по id и изменяет его данные.
     * @param user
     */
    @Override
    public void update(User user) {
            this.store.update(user);
    }

    /**
     * Находит пользователя по id и удаляет его.
     * @param id
     */
    @Override
    public void delete(int id) {
            this.store.delete(id);
    }

    /**
     * Возвращает map со всеми пользователями.
     * @return
     */
    public Map<Integer, User> findAll() {
        return this.store.findAll();
    }

    /**
     * Возвращает пользователя по id, если он существует.
     * @param id
     * @return
     */
    @Override
    public User findById(int id) {
        return this.store.findById(id);
    }

    @Override
    public User isCredentional(String login, String password) {
        return this.store.isCredentional(login, password);
    }

    @Override
    public List<Role> getAllRoles() {
        return this.store.getAllRoles();
    }

    @Override
    public List<City> getAllCities() {
        return this.store.getAllCities();
    }

    @Override
    public void addCity(City city) {
        if (!getAllCities().contains(city)) {
            this.store.addCity(city);
        }
    }
}