package ru.moskalets.generalizations.task2;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Testing the method ConvertListToMap.
 * @author Igor Moskalets
 * @since 09.06.2017
 */
public class ConvertListToMapTest {
    /**
     * When the incoming parameter List returns a Map with the key.
     */
    @Test
    public void WhenListReturnMap(){
        ConvertListToMap cltm = new ConvertListToMap();
        User user1 = new User(1,"Ivan", "Rio");
        User user2 = new User(2,"Karlos", "Tokio");
        User user3 = new User(3,"Sam", "London");
        List<User> list = Arrays.asList(user1, user2, user3);
        HashMap<Integer, User> expected = new HashMap<Integer, User>();
        expected.put(1,user1);
        expected.put(2,user2);
        expected.put(3,user3);
        assertThat(cltm.process(list),is(expected));
    }
}
