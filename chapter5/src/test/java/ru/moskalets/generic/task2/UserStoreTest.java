package ru.moskalets.generic.task2;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Testing the method UserStore.
 * @author Igor Moskalets
 * @since 18.08.2017
 */
public class UserStoreTest {
    /**
     * This test checks methods addValue() and getValues. First added the User then returns all the values.
     */
    @Test
    public void whenAddedUserIsReturnedArrayWithUser(){
        UserStore<User> us = new UserStore<User>(10);
        us.addValue(new User("First"));
        assertThat(us.getValues().get(0), is(new User("First")));
    }
    /**
     * This test checks the method updateValues(). Add a User then modify it.
     */
    @Test
    public void whenUpdateUserReturnUpdatedUser(){
        UserStore<User> us = new UserStore<User>(10);
        us.addValue(new User("First"));
        us.updateValue(0, new User("First Updated"));
        assertThat(us.getValues().get(0), is(new User("First Updated")));
    }
    /**
     * This test checks the method deleteValues().
     * Add two Users, then delete the first, next, call first, and returns second.
     */
    @Test
    public void  whenRemovedUserReturnsNextUser(){
        UserStore<User> us = new UserStore<User>(10);
        us.addValue(new User("First"));
        us.addValue(new User("Second"));
        us.deleteValue(0);
        assertThat(us.getValues().get(0), is(new User("Second")));
    }
}