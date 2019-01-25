package ru.moskalets.hibernate.section001.task001;

import java.util.List;

public class ValidateService {
    private static final ValidateService INSTANCE = new ValidateService();
    private final DbStore store = DbStore.getInstance();

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    public void addItem(Item item) {
        this.store.addItem(item);
    }

    public void updateItem(Item item) {
        this.store.updateItem(item);
    }

    public void deleteItem(Item item) {
        this.store.deleteItem(item);
    }

    public List<Item> getAllItems() {
        return this.store.getAllItems();
    }
}