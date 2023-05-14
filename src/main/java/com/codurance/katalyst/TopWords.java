package com.codurance.katalyst;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TopWords {

    private String text;
    protected TopWords(String text){
        this.text = text;
    }
    public static TopWords create(String text) {
        return new TopWords(TextCleaner.create(text).clean());
    }
    public List<String> value() {
        TreeSet<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(Arrays.asList(text.split(" ", -1)));
        return set
            .stream()
            .filter(word -> !"".equals(word))
            .sorted((a, b) -> {
                int compareTo = countOcurrences(b) - countOcurrences(a);
                if(compareTo == 0){
                    return a.toUpperCase().compareTo(b.toUpperCase());
                }
                return compareTo;
            })
            .distinct()
            .collect(Collectors.toList());
    }
    private int countOcurrences(String word){
        return (int)Arrays.asList(text.split(" ", -1))
            .stream()
            .filter(otherWord -> word.equalsIgnoreCase(otherWord))
            .count();
    }
}
