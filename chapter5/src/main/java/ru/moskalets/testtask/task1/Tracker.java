package ru.moskalets.testtask.task1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * The class stores information about users and accounts belonging to them.
 * author Igor Moskalets
 * Since 15.06.2017
 */
public class Tracker {
    /**
     * A set of users.
     */
    private Map<User, ArrayList<Account>> users = new HashMap<User, ArrayList<Account>>();
    /**
     * Get Map user.
     * @return Map<User, ArrayList<Account>>
     */
    public Map<User, ArrayList<Account>> getUsers() {
        return this.users;
    }
    /**
     * Adds the user.
     * @param user This user.
     */
    public void addUser(User user) {
        this.users.put(user, new ArrayList<Account>());
    }
    /**
     * Delete the user.
     * @param user This user.
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }
    /**
     * Adds the account to the selected user.
     * @param user This user.
     * @param account This account.
     */
    public void addAccountToUser(User user, Account account) {
        if (this.users.containsKey(user) && !this.users.get(user).contains(account)) {
            ArrayList<Account> tempList = this.users.get(user);
            tempList.add(account);
            this.users.put(user, tempList);
        }
    }
    /**
     * Delete the account to the selected user.
     * @param user This user.
     * @param account Account from user.
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (this.users.containsKey(user) && this.users.get(user).contains(account)) {
            ArrayList<Account> tempList = this.users.get(user);
            tempList.remove(account);
            this.users.put(user, tempList);
        }
    }
    /**
     * Returns a list of accounts the selected user.
     * @param user This user.
     * @return ArrayList<Account>.
     */
    public ArrayList<Account> getUserAccounts(User user) {
        ArrayList<Account> tempList = new ArrayList<Account>();
        if (this.users.get(user) != null) {
            tempList = this.users.get(user);
        }
        return tempList;
    }
    /**
     * Transfers the selected amount from the account of one user to another user.
     * @param srcUser source user.
     * @param srcAccount Source account.
     * @param dstUser Distantion user.
     * @param dstAccount Distantion account.
     * @param amount This amount.
     * @return boolean.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean flag = false;
        if ((this.users.get(srcUser).contains(srcAccount)) && (this.users.get(dstUser).contains(dstAccount)) && ((srcAccount.getValue() - amount) >= 0)) {
                this.users.put(srcUser, changeValuesAccountMinus(srcUser, srcAccount, 0 - amount));
                this.users.put(dstUser, changeValuesAccountMinus(dstUser, dstAccount, amount));
                flag = true;
        }
        return flag;
    }
    /**
     * Transfers the selected amount from the account of one user to another user.
     * @param dstUser Distantion user.
     * @param srcAccount Source account.
     * @param dstAccount Distantion account.
     * @param amount This amount.
     * @return boolean.
     */
    public boolean transferMoneyBetweenAccountsSameUser(User dstUser, Account srcAccount, Account dstAccount, double amount) {
        boolean flag = false;
        if ((this.users.get(dstUser).contains(srcAccount)) && (this.users.get(dstUser).contains(dstAccount)) && ((srcAccount.getValue() - amount) >= 0)) {
            this.users.put(dstUser, changeValuesAccountMinus(dstUser, srcAccount, 0 - amount));
            this.users.put(dstUser, changeValuesAccountMinus(dstUser, dstAccount, amount));
            flag = true;
        }
        return flag;
    }
    /**
     * Changes the value in the account from list of accounts.
     * @param dstUser Distantion user.
     * @param account Source account.
     * @param amount This amount.
     * @return ArrayList<Account>.
     */
    public ArrayList<Account> changeValuesAccountMinus(User dstUser, Account account, double amount) {
        ArrayList<Account> tempList = this.users.get(dstUser);
        int index = tempList.indexOf(account);
        Account tempAccount = tempList.get(index);
        tempAccount.setValue(tempAccount.getValue() + amount);
        tempList.set(index, tempAccount);
        return tempList;
    }
}

