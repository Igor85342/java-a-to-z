package ru.moskalets.sorting.task1;
import java.util.List;
import java.util.TreeSet;
/**
 * Sorts the elements in the TreeSet according to age.
 * author Igor Moskalets
 * Since 12.06.2017
 */
public class SortUser {
    /**
     * Sorts the elements in the TreeSet according to age.
     * @param listUsers List of users.
     * @return Set<User><Integer, User>.
     */
    public TreeSet<User> sort(List<User> listUsers) {
        TreeSet<User> setUsers = new TreeSet<User>();
        for (User user: listUsers) {
            setUsers.add(user);
        }
        return setUsers;
    }
}
