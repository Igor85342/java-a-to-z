package ru.moskalets.sorting.task2;
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
    public void whenInputListReturnSortedToAgeSet(){
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
    /**
     * Sorts in alphabetical order the names of the users.
     */
    @Test
    public void whenSortedToNamesReturnList(){
        SortUser su = new SortUser();
        User user1 = new User("Ivan", 25);
        User user2 = new User("Igor", 31);
        User user3 = new User("Robert", 18);
        List<User> result = Arrays.asList(user1, user2, user3);
        result = su.sortNameLength(result);
        List<User> expected = Arrays.asList(user2, user1, user3);
        assertThat(result, is(expected));
    }
    /**
     * Sorts in alphabetical order the names of the users.If the names are the same, compares the age.
     */
    @Test
    public void whenSortedToNamesAndAgeReturnList(){
        SortUser su = new SortUser();
        User user1 = new User("Ivan", 25);
        User user2 = new User("Igor", 31);
        User user3 = new User("Robert", 18);
        User user4 = new User("Ivan", 20);
        User user5 = new User("Robert", 36);
        List<User> result = Arrays.asList(user1, user2, user3, user4, user5);
        result = su.sortByAllFields(result);
        List<User> expected = Arrays.asList(user2, user4, user1, user3, user5);
        assertThat(result, is(expected));
    }
}
