package ru.job4j.synch;
import java.util.ArrayList;
import java.util.List;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
/**
 * UserStorage.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    /**
     * Field - stores object's list of Users.
     */
    private  final List<User> list = new ArrayList<>();
    /**
     * The method adds new object of Users.
     * @param user new user.
     */

    public synchronized   boolean  add (User user) {
        boolean result = false;
        if (user != null) {
            result = list.add(user);
        }
        return result;
    }
    /**
     * The method updates  object of Users new values.
     * @param user new user.
     */

    public synchronized boolean update(User user) {
        boolean result = false;
        for (User us : this.list) {
            if (us.getId() == user.getId()) {
                list.set(list.indexOf(us), user);
                result = true;
            }
        }
        return result;
    }
    /**
     * The method deletes  object of Users.
     * @param user .
     */

    public synchronized boolean delete(User user) {
        boolean result = false;
        for (User us : this.list) {
            if (us.getId() == user.getId()) {
                result = list.remove(us);
            }
        }
        return result;
    }
    /**
     * The method executes operations on amount of Users.
     * @param fromId - id of first user .
     * @param toId - id of second user
     * @param amount - a quantity for transfer.
     */

    public synchronized void transfer(int fromId, int toId, int amount) {
        for (User us : this.list) {
            if (us.getId() == fromId) {
                us.setAmount(us.getAmount() - amount);
            } else if (us.getId() == toId) {
                us.setAmount(us.getAmount() + amount);
            }
        }
    }
    /**
     * The method returns list of users.
     * @return list.
     */

    public synchronized List<User> getList() {
        return this.list;
    }
}
