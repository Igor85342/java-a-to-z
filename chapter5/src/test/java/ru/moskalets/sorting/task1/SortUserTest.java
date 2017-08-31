package ru.moskalets.sorting.task1;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Testing the method SortUser.
 * @author Igor Moskalets
 * @since 12.06.2017
 */
public class SortUserTest {
    /**
     * Checks that the age of first and last element of TreeSet was the least and the largest, respectively.
     */
    @Test
    public void whenInputListReturnSortedToAgeSet() {
        SortUser su = new SortUser();
        User user1 = new User("Ivan", 25);
        User user2 = new User("Igor", 31);
        User user3 = new User("Robert", 18);
        List<User> list = Arrays.asList(user1, user2, user3);
        TreeSet<User> setUsers = new TreeSet<User>();
        setUsers = su.sort(list);
        assertThat(setUsers.first().getName(), is("Robert"));
        assertThat(setUsers.last().getName(), is("Igor"));
    }
}
