package ru.moskalets.spring.section001.task001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MemoryStorage implements Storage {
    private static final Logger LOG = LoggerFactory.getLogger(MemoryStorage.class);

    public void add(User user) {
        System.out.println("Store to memory.");
    }
}