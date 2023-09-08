package ru.job4j.streamapi;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {

        return profiles
                .stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

}
