package ru.job4j.tdd;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
/**
 * Cinema- interface.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Cinema extends Movies {
    /*
  The method returns list of Session's objects with certain criteria.
    */
    List<Session> find(Predicate<Session> filter);
    /*
   The method returns  Ticket's.
     */

    Ticket buy(Account account, int row, int column, Calendar date);
    /*
     The method adds Session's objects into list.
       */

    void add(Session session);
}
