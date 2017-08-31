package ru.moskalets.testtask.task1;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Testing the method Tracker.
 * @author Igor Moskalets
 * @since 15.06.2017
 */
public class TrackerTest {
    /**
     * Checks add users. Also checks a method that returns all users.
     */
    @Test
    public void whenAddUser() {
        Tracker tracker = new Tracker();
        User user1 = new User("Ivan", "777");
        User user2 = new User("Bob", "111");
        Map<User, ArrayList<Account>> expected = new HashMap<User, ArrayList<Account>>();
        expected.put(user1, new ArrayList<Account>());
        expected.put(user2, new ArrayList<Account>());
        tracker.addUser(user1);
        tracker.addUser(user2);
        assertThat(tracker.getUsers().equals(expected), is(true));
    }
    /**
     * Checks remove users.
     */
    @Test
    public void whenRemoveUser() {
        Tracker tracker = new Tracker();
        User user1 = new User("Ivan", "777");
        User user2 = new User("Bob", "111");
        Map<User, ArrayList<Account>> expected = new HashMap<User, ArrayList<Account>>();
        expected.put(user2, new ArrayList<Account>());
        tracker.addUser(user1);
        tracker.addUser(user2);
        tracker.deleteUser(user1);
        assertThat(tracker.getUsers().equals(expected), is(true));
    }
    /**
     * Checks add one account to the selected user.
     */
    @Test
    public void whenAddOneAccountToUser() {
        Tracker tracker = new Tracker();
        User user2 = new User("Bob", "111");
        Account account1 = new Account("account1", 10000.00);
        ArrayList<Account> user2Accounts = new ArrayList<Account>();
        user2Accounts.add(account1);
        tracker.addUser(user2);
        tracker.addAccountToUser(user2, account1);
        assertThat(tracker.getUserAccounts(user2), is(user2Accounts));
    }
    /**
     * Checks the addition of two accounts to the selected user.
     */
    @Test
    public void whenAddTwoAccountToUser() {
        Tracker tracker = new Tracker();
        User user2 = new User("Bob", "111");
        Account account1 = new Account("account1", 10000.00);
        Account account2 = new Account("account2", 20000.00);
        ArrayList<Account> user2Accounts = new ArrayList<Account>();
        user2Accounts.add(account1);
        user2Accounts.add(account2);
        tracker.addUser(user2);
        tracker.addAccountToUser(user2, account1);
        tracker.addAccountToUser(user2, account2);
        assertThat(tracker.getUserAccounts(user2), is(user2Accounts));
    }
    /**
     * Checks the deletion of the account with the selected user.
     */
    @Test
    public void whenRemoveAccountToUser() {
        Tracker tracker = new Tracker();
        User user2 = new User("Bob", "111");
        Account account1 = new Account("account1", 10000.00);
        Account account2 = new Account("account2", 20000.00);
        ArrayList<Account> user2Accounts = new ArrayList<Account>();
        user2Accounts.add(account2);
        tracker.addUser(user2);
        tracker.addAccountToUser(user2, account1);
        tracker.addAccountToUser(user2, account2);
        tracker.deleteAccountFromUser(user2, account1);
        assertThat(tracker.getUserAccounts(user2), is(user2Accounts));
    }
    /**
     * Checks transfer from one account to another selected user.
     */
    @Test
    public void whenTransferMoneyBetweenAccountsSameUser() {
        Tracker tracker = new Tracker();
        User user2 = new User("Bob", "111");
        Account account1 = new Account("account1", 10000.00);
        Account account2 = new Account("account2", 20000.00);
        ArrayList<Account> user2Accounts = new ArrayList<Account>();
        user2Accounts.add(account2);
        tracker.addUser(user2);
        tracker.addAccountToUser(user2, account1);
        tracker.addAccountToUser(user2, account2);
        boolean flag = tracker.transferMoneyBetweenAccountsSameUser(user2, account1, account2, 10000.00);
        assertThat(flag, is(true));
        assertThat(tracker.getUserAccounts(user2).get(0).getValue(), is(0.00));
        assertThat(tracker.getUserAccounts(user2).get(1).getValue(), is(30000.00));
    }
    /**
     * Checks transfer from the account of one user to another user.
     */
    @Test
    public void whenTransferBetweenAccountsTwoUsers() {
        Tracker tracker = new Tracker();
        User user2 = new User("Bob", "111");
        User user3 = new User("Tom", "234");
        Account account1 = new Account("account1", 10000.00);
        Account account2 = new Account("account2", 20000.00);
        ArrayList<Account> user2Accounts = new ArrayList<Account>();
        ArrayList<Account> user3Accounts = new ArrayList<Account>();
        user2Accounts.add(account2);
        user3Accounts.add(account1);
        tracker.addUser(user2);
        tracker.addUser(user3);
        tracker.addAccountToUser(user2, account2);
        tracker.addAccountToUser(user3, account1);
        boolean flag = tracker.transferMoney(user2, account2, user3, account1, 15000.00);
        assertThat(flag, is(true));
        assertThat(tracker.getUserAccounts(user2).get(0).getValue(), is(5000.00));
        assertThat(tracker.getUserAccounts(user3).get(0).getValue(), is(25000.00));
    }
}
