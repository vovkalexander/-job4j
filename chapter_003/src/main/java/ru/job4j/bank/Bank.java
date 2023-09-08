package ru.job4j.bank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * Bank.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Bank {
    /**
     * Поле - хранит отображение с ключом типа пользователь  и значением типа список.
     */
    private Map<User, List<Account>> userBank = new TreeMap<>();
    /**
     * Метод - добавляет пользователя в отображение.
     * @param user пользователь.
     */

    public void addUser(User user) {
        this.userBank.putIfAbsent(user, new ArrayList<>());
    }
    /**
     * метод - удаляет пользователя из отображения.
     * @param user пользователь.
     */

    public void deleteUser(User user) {
        this.userBank.remove(user);
    }
    /**
     * Метод - добавляет значение к пользователю в отображение.
     * @param passport  пользователя.
     * @param account счет пользователя.
     */

    public void addAccountToUser(String passport, Account account) {
        userBank.keySet().stream().filter(user -> user.getPassport().contains(passport)).forEach(user ->
                 this.userBank.get(user).add(account));
    }

    /**
     * Метод - удаляет значение у пользователя в отображение.
     * @param passport  пользователя.
     * @param account счет пользователя.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        userBank.keySet().stream().filter(user -> user.getPassport().contains(passport)).forEach(user ->
                this.userBank.get(user).remove(account));
        }

    /**
     * Метод - находит значение по ключу - пользователь в отображение.
     * @param passport  пользователя.
     * @return список счетов пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        return this.userBank.keySet().stream().filter(user -> user.getPassport().contains(passport)).map(
                user -> this.userBank.get(user)).findFirst().orElse(null);
    }
    /**
     * Метод - преводит сумму с счета на счет.
     * @param srcPassport исходного пользователя.
     * @param srcRequisite реквизиты исходного пользователя.
     * @param destPassport принимающего пользователя.
     * @param destRequisite реквизиты принимающего пользователя.
     * @param amount - сумма перечисления.
     * @return логический вывод.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        User userSrc = getUser(srcPassport);
        User userDest = getUser(destPassport);
        Account accountSrc = null;
        Account accountDest = null;
        if (userSrc != null) {
            accountSrc = getAccount(userSrc, srcRequisite);
        }
        if (userDest != null) {
            accountDest = getAccount(userDest, destRequisite);
        }
        return accountSrc != null && accountDest != null && accountSrc.transfer(accountDest, amount);
    }
    /**
     * Метод - находит  ключ - пользователя в отображение.
     * @param passport  пользователя.
     * @return  пользователя по пасспорту.
     */

    public User getUser(String passport) {
        User result = null;
        for (User user : this.userBank.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
            }
        }
        return this.userBank.keySet().stream().filter(user -> user.getPassport().contains(passport)
        ).findFirst().orElse(null);
    }
    /**
     * Метод - находит  значение-счет в отображение.
     * @param user пользователь.
     * @param requisite  реквизиты пользователя.
     * @return счет  пользователя по реквизитам.
     */

    public Account getAccount(User user, String requisite) {
        return this.userBank.get(user).stream().filter(account -> account.getReqs().contains(requisite)).
                findFirst().orElse(null);
    }
    /**
     * Метод - возвращает отображение.
     * @return поле отображение.
     */

    public Map getMap() {
        return userBank;
    }
}




