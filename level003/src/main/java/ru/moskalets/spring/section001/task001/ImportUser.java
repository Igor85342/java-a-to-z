package ru.moskalets.spring.section001.task001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class ImportUser {
    private static final Logger LOG = LoggerFactory.getLogger(ImportUser.class);
    private final JdbcStorage storage;

    public ImportUser(JdbcStorage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }

    public List<User> getAll() {
        return this.storage.getAll();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ImportUser importUser = context.getBean(ImportUser.class);
        importUser.add(new User("Test"));
        importUser.getAll().forEach((user)->System.out.println(user.getName()));
    }
}