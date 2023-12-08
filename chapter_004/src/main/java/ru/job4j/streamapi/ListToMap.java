package ru.job4j.streamapi;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {

    public static Map<String, Student> convert(List<Student> list) {

        return  list
                .stream()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                Function.identity(),
                                (existing, replacement) -> existing
                        ));

    }
}
