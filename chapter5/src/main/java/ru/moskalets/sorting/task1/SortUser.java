package ru.moskalets.sorting.task1;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * Sorts the elements in the TreeSet according to age.
 * author Igor Moskalets
 * Since 12.06.2017
 */
public class SortUser{
    private TreeSet<User> setUsers = new TreeSet<User>();
    /**
     * Get setUsers.
     * @return TreeSet<User>.
     */
    public TreeSet<User> getSetUsers(){
        return this.setUsers;
    }
    /**
     * Sorts the elements in the TreeSet according to age.
     * @param List<User> listUsers.
     * @return Set<User><Integer, User>.
     */
    public Set<User> sort(List<User> listUsers){
        //TreeSet<User> setUsers = new TreeSet<User>();
        for(User user: listUsers){
            setUsers.add(user);
        }
        return setUsers;
    }
}
