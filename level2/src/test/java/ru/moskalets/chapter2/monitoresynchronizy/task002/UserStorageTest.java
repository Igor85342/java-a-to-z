package ru.moskalets.chapter2.monitoresynchronizy.task002;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Класс тестирует UserStorage.
 */
public class UserStorageTest {
    /**
     * Тестирует добавление User.
     */
    @Test
    public void addTest() {
        UserStorage us = new UserStorage();
        User u1 = new User(1, 100);
        us.add(u1);
        assertThat(us.getContainers().get(1), is(u1));
    }

    /**
     * Тестирует изменение User.
     */
    @Test
    public void updateTest() {
        UserStorage us = new UserStorage();
        User u1 = new User(1, 100);
        User u2 = new User(1, 200);
        us.add(u1);
        us.update(u2);
        assertThat(us.getContainers().get(1), is(u2));
    }
    /**
     * Тестирует удаление User.
     */
    @Test
    public void deleteTest() {
        UserStorage us = new UserStorage();
        User u1 = new User(1, 100);
        us.add(u1);
        us.delete(u1);
        assertThat(us.getContainers().size(), is(0));
    }

    /**
     * Тестирует метод transfer().
     */
    @Test
    public void transferTest() {
        UserStorage us = new UserStorage();
        User u1 = new User(1, 100);
        User u2 = new User(2, 200);
        us.add(u1);
        us.add(u2);
        us.transfer(1, 2, 50);
        assertThat(us.getContainers().get(1).getAmount(), is(50));
        assertThat(us.getContainers().get(2).getAmount(), is(250));
    }
    @Test
    /**
     * Тестирует создание двух User в двух разных потоках.
     */
    public void whenExecuteTwoThreadThen() throws InterruptedException {
        UserStorage us = new UserStorage();
        User u1 = new User(1, 100);
        User u2 = new User(2, 200);
        Thread thread001 = new Thread() {
            @Override
            public void run() {
                us.add(u1);
            }
        };
        Thread thread002 = new Thread() {
            @Override
            public void run() {
                us.add(u2);
            }
        };
        thread001.start();
        thread002.start();
        thread001.join();
        thread002.join();
        assertThat(us.getContainers().size(), is(2));
    }
}