package ru.job4j.bank;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BankTest {
    private User user;
    private Account account;
    @Before
    public void insertInfo() {
        user = new User("Kuzmitch", "0101010101");
        account = new Account(3.14, "DataOfBank");
    }
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        bank.addUser(user);
        Map treeMap = bank.getMap();
        assertThat(treeMap.containsKey(user), is(true));
    }
    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        bank.addUser(user);
        bank.deleteUser(user);
        Map treeMap = bank.getMap();
        assertThat(treeMap.containsKey(user), is(false));
    }
    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addAccountToUser("0101010101", account);
        List<Account> result = bank.getUserAccounts("0101010101");
        assertThat(result.get(0).getReqs(), is("DataOfBank"));
    }
    @Test
    public void whenDeleteAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addAccountToUser("0101010101", account);
        bank.deleteAccountFromUser("0101010101", account);
        Map treemap = bank.getMap();
        assertThat(treemap.containsValue(account), is(false));
    }
    @Test
    public void whenTransferMoneyOneUserToAnotherUser() {
        Bank bank = new Bank();
        User srcUser = new User("Kuzmitch", "0101010101");
        User destUser = new User("Petrovich", "0202020202");
        Account srcAccount = new Account(55000.0, "srcDataOfBank");
        Account destAccount = new Account(75000.0, "destDataOfBank");
        bank.addUser(srcUser);
        bank.addUser(destUser);
        bank.addAccountToUser("0101010101", srcAccount);
        bank.addAccountToUser("0202020202", destAccount);
        bank.transferMoney("0101010101", "srcDataOfBank", "0202020202", "destDataOfBank", 10000.0);
        List<Account> resultSrc = bank.getUserAccounts("0101010101");
        List<Account> resultDest = bank.getUserAccounts("0202020202");
        assertThat(resultSrc.get(0).getValues(), is(45000.0));
        assertThat(resultDest.get(0).getValues(), is(85000.0));
    }
}
