package ru.moskalets.generalizations.task2;

import java.util.HashMap;
import java.util.List;

/**
 * Converts a list consisting of User objects in the Map.
 * author Igor Moskalets
 * Since 09.06.2017
 */
public class ConvertListToMap {
    /**
     * The method converts a list consisting of User objects in the Map.
     * @param List<User> users.
     * @return HashMap<Integer, User>.
     */
    public HashMap<Integer, User> process(List<User> users) {
        HashMap<Integer, User> finalHashMap = new HashMap<Integer, User>();
        for (User user: users){
            finalHashMap.put(user.getID(),user);
        }
        return finalHashMap;
    }
}
