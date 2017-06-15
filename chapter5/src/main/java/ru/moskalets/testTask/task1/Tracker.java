package ru.moskalets.testTask.task1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * The class stores information about users and accounts belonging to them.
 * author Igor Moskalets
 * Since 15.06.2017
 */
public class Tracker {
    private Map<User, ArrayList<Account>> users = new HashMap<User, ArrayList<Account>>();
    /**
     * Get Map user.
     * @return Map<User, ArrayList<Account>>
     */
    public Map<User, ArrayList<Account>> getUsers(){
        return this.users;
    }
    /**
     * Adds the user.
     * @param User user.
     * @return void.
     */
    public void addUser(User user){
        this.users.put(user,new ArrayList<Account>());
    }
    /**
     * Delete the user.
     * @param User user.
     * @return void.
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }
    /**
     * Adds the account to the selected user.
     * @param User user.
     * @param Account account.
     * @return void.
     */
    public void addAccountToUser(User user, Account account) {
        if (this.users.containsKey(user)){
            ArrayList<Account> tempList = new ArrayList<Account>();
            if (this.users.get(user) !=null) {
                tempList = this.users.get(user);
                tempList.add(account);
                this.users.put(user, tempList);
            } else {
                tempList.add(account);
                this.users.put(user, tempList);
            }
        }
    }
    /**
     * Delete the account to the selected user.
     * @param User user.
     * @param Account account.
     * @return void.
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (this.users.get(user) !=null) {
            ArrayList<Account> tempList;
            tempList = this.users.get(user);
            for (Account userAccount: tempList){
                if (userAccount.equals(account)){
                    tempList.remove(userAccount);
                    break;
                }
            }
            this.users.put(user, tempList);
        }
    }
    /**
     * Returns a list of accounts the selected user.
     * @param User user.
     * @return ArrayList<Account>.
     */
    public ArrayList<Account> getUserAccounts(User user) {
        ArrayList<Account> tempList = new ArrayList<Account>();
        if (this.users.get(user) !=null) {
            tempList = this.users.get(user);
        }
        return tempList;
    }
    /**
     * Transfers the selected amount from the account of one user to another user.
     * @param User srcUser.
     * @param Account srcAccount.
     * @param User dstUser.
     * @param Account dstAccount.
     * @param double amount.
     * @return boolean.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount){
        boolean flag = true;
        if (this.users.containsKey(srcUser) & this.users.containsKey(dstUser)){
            if (((srcAccount.getValue() - amount)>=0) & (this.users.get(srcUser).contains(srcAccount)) & (this.users.get(dstUser).contains(dstAccount))){
                this.users.put(srcUser, changeValuesAccountMinus(srcUser, srcAccount,0-amount));
                this.users.put(dstUser, changeValuesAccountMinus(dstUser, dstAccount, amount));
            } else flag = false;
        }else flag = false;
        return flag;
    }
    /**
     * Transfers the selected amount from the account of one user to another user.
     * @param User dstUser.
     * @param Account srcAccount.
     * @param Account dstAccount.
     * @param double amount.
     * @return boolean.
     */
    public boolean transferMoneyBetweenAccountsSameUser(User dstUser, Account srcAccount, Account dstAccount, double amount ){
        boolean flag = true;
        if (((srcAccount.getValue() - amount)>=0) & (this.users.get(dstUser).contains(srcAccount)) & (this.users.get(dstUser).contains(dstAccount))){
            this.users.put(dstUser, changeValuesAccountMinus(dstUser,srcAccount,0-amount));
            this.users.put(dstUser, changeValuesAccountMinus(dstUser, dstAccount, amount));
        } else flag = false;
        return flag;
    }
    /**
     * Changes the value in the account from list of accounts.
     * @param User dstUser.
     * @param Account srcAccount.
     * @param Account dstAccount.
     * @param double amount.
     * @return ArrayList<Account>.
     */
    public ArrayList<Account> changeValuesAccountMinus(User dstUser, Account account, double amount){
        ArrayList<Account> tempList = this.users.get(dstUser);
        int index = tempList.indexOf(account);
        Account tempAccount = tempList.get(index);
        tempAccount.setValue(tempAccount.getValue() + amount);
        tempList.set(index, tempAccount);
        return tempList;
    }
}

