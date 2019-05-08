package ru.moskalets.spring.section001.task001;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    @Test
    public void whenAddUserToStorageShouldSaveIt() {
        MemoryStorage memoryStorage = new MemoryStorage();
        UserStorage storage = new UserStorage(memoryStorage);
        storage.add(new User("Test"));
    }

    @Test
    public void whenLoadContextShouldGetBeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage memory = context.getBean(UserStorage.class);
        User user = new User("Test");
        memory.add(user);
        assertThat(user, is(memory.getAll().get(0)));
    }

}