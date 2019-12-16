package ru.job4.critery;

import java.io.IOException;
/**
 * PredicateFactory.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class PredicateFactory {
    /**
     * Метод - возвращает объект класса Predicate.
     * @param  choose- строка  выбора класса.
     * @param  arg - ссылка класса Arg
     * @return  объект класса Predicate. .
     */
    public Predicate createSearch(String choose, Arg arg) {
        Predicate predicate = null;
        if(choose.equals(arg.getMap().get("fullname")))
            predicate = new SearchByFullName();
        else if(choose.equals(arg.getMap().get("mask"))) {
            predicate =new SearchByMask();
        } else if(choose.equals((arg.getMap().get("regex")))) {
            predicate = new SearchByRegEx();
        }
        return predicate;
    }
}

