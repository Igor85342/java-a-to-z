package ru.moskalets.chapter2.monitoresynchronizy.task002;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс - структура данных для хранения User.
 */
@ThreadSafe
public class UserStorage {
    /**
     * containers.
     */
    @GuardedBy("this")
    private Map<Integer, User> containers = new HashMap();

    /**
     * Добавление пользователя.
     * @param user
     * @return
     */
    public boolean add(User user) {
        synchronized (this) {
            boolean flag = false;
            if (!this.containers.containsKey(user.getId())) {
                this.containers.put(user.getId(), user);
                flag = true;
            }
            return flag;
        }
    }

    /**
     * Изменение пользователя.
     * @param user
     * @return
     */
    public boolean update(User user) {
        synchronized (this) {
            boolean flag = false;
            if (this.containers.containsKey(user.getId())) {
                this.containers.put(user.getId(), user);
                flag = true;
            }
            return flag;
        }
    }

    /**
     * Удаление пользователя.
     * @param user
     * @return
     */
    public boolean delete(User user) {
        synchronized (this) {
            return this.containers.remove(user.getId(), user);
        }
    }

    /**
     * Перевод от User к User.
     * @param fromId
     * @param toId
     * @param amount
     * @return
     */
    public boolean transfer(int fromId, int toId, int amount) {
        synchronized (this) {
            boolean flag = false;
            if (this.containers.get(fromId).getAmount() >= amount) {
                this.containers.get(fromId).setAmount(this.containers.get(fromId).getAmount() - amount);
                this.containers.get(toId).setAmount(this.containers.get(toId).getAmount() + amount);
                flag = true;
            }
            return flag;
        }
    }

    /**
     * Возвращает containers.
     * @return
     */
    public Map<Integer, User> getContainers() {
        synchronized (this) {
            return this.containers;
        }
    }
}
