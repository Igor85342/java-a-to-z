package ru.moskalets.map.task2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * In this class, see the work of the collection map.
 */
public class MapWork {
    /**
     * In the method check that will be displayed on the screen. Given two objects with the same fields,
     * methods, equals() and hashCode() is not overridden. These objects are placed in the map as keys.
     */
    @Test
    public void addingTwoIdenticalObjectsAreNotOverridingEqualsAndHashCode() {
        Map<User, Object> map = new HashMap<>();
        User first = new User("Igor");
        User second = new User("Igor");
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}
