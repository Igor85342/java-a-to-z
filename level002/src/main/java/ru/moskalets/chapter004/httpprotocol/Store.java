package ru.moskalets.chapter004.httpprotocol;

import java.util.Map;

/**
 * Интерфейс - хранилище.
 */
public interface Store {

    /**
     * Добавляет пользователя.
     * @param user
     */
    void add(User user);

    /**
     * Изменяте данные пользователя.
     * @param id
     * @param name
     * @param login
     * @param email
     */
    void update(int id, String name, String login, String email);

    /**
     * Удаляет пользователя.
     * @param id
     */
    void delete(int id);

    /**
     * Возвращает данные о всех пользователях.
     * @return
     */
    Map<Integer, User> findAll();

    /**
     * Возвращает данные об одном пользователе по id.
     * @param id
     * @return
     */
    User findById(int id);
}