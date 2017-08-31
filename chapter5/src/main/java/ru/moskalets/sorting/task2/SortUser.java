package ru.moskalets.sorting.task2;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Sorts the elements in the TreeSet according to age, to name, to name and age.
 * author Igor Moskalets
 * Since 12.06.2017
 */
public class SortUser {
    /**
     * Sorts the elements in the TreeSet according to age.
     * @param listUsers Collection of users.
     * @return Set<User><Integer, User>.
     */
    public TreeSet<User> sort(List<User> listUsers) {
        TreeSet<User> setUsers = new TreeSet<User>();
        for (User user: listUsers) {
            setUsers.add(user);
        }
        return setUsers;
    }
    /**
     * Sorts the users in the list according to name.
     * @param listUsers Collection of users.
     * @return List<User>.
     */
    public List<User> sortNameLength(List<User> listUsers) {
        Collections.sort(listUsers,
                new Comparator<User>() {
                    public int compare(User o1, User o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        );
        return listUsers;
    }
    /**
     * Sorts the users in the list according to name and age.
     * @param listUsers Collection of users.
     * @return List<User>.
     */
    public List<User> sortByAllFields(List<User> listUsers) {
        Collections.sort(listUsers,
                new Comparator<User>() {
                    public int compare(User o1, User o2) {
                        int flag = o1.getName().compareTo(o2.getName());
                        if (flag == 0) {
                            flag = o1.getAge() - o2.getAge();
                        }
                        return flag;
                    }
                }
        );
        return listUsers;
    }

}
