package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PhoneDictionary.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionary {
    /**
     * Хранит массив  пользователей .
     */
    private List<Person> persons = new ArrayList<>();
    /**
     * Метод добовляет пользователей в массив.
     *  @param person - пользователь в телефонном справочнике.
     */
    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
         return persons.stream().filter(
                person -> person.getName().contains(key) || person.getSurname().contains(key) || person.getPhone().contains(key) || person.getAddress().contains(key)
        ).collect(Collectors.toList());
    }
}
