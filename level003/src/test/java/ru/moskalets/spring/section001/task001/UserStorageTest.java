package ru.moskalets.spring.section001.task001;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class UserStorageTest {
    @Test
    public void whenAddUserToStorageShouldSaveIt() {
        MemoryStorage memoryStorage = new MemoryStorage();
        UserStorage storage = new UserStorage(memoryStorage);
        storage.add(new User());
    }

    @Test
    public void whenLoadContextShouldGetBeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage memory = context.getBean(UserStorage.class);
        memory.add(new User());
        assertNotNull(memory);
    }

}