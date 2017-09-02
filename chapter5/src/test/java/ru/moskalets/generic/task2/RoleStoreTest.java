package ru.moskalets.generic.task2;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the method RoleStore.
 * @author Igor Moskalets
 * @since 18.08.2017
 */
public class RoleStoreTest {
    /**
     * This test checks methods addValue() and getValues. First added the Role then returns all the values.
     */
    @Test
    public void whenAddedUserIsReturnedArrayWithUser() {
        RoleStore<Role> rs = new RoleStore<Role>(10);
        rs.addValue(new Role("First"));
        assertThat(rs.getValues().get(0), is(new Role("First")));
    }
    /**
     * This test checks the method updateValues(). Add a Role then modify it.
     */
    @Test
    public void whenUpdateUserReturnUpdatedUser() {
        RoleStore<Role> rs = new RoleStore<Role>(10);
        rs.addValue(new Role("First"));
        rs.updateValue(0, new Role("First Updated"));
        assertThat(rs.getValues().get(0), is(new Role("First Updated")));
    }
    /**
     * This test checks the method deleteValues().
     * Add two Roles, then delete the first, next, call first, and returns second.
     */
    @Test
    public void  whenRemovedUserReturnsNextUser() {
        RoleStore<Role> rs = new RoleStore<Role>(10);
        rs.addValue(new Role("First"));
        rs.addValue(new Role("Second"));
        rs.deleteValue(0);
        assertThat(rs.getValues().get(0), is(new Role("Second")));
    }
}