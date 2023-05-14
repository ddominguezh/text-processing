package com.codurance.katalyst;

import java.util.Arrays;
import java.util.List;
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
        return Arrays.asList(text.split(" ", -1))
            .stream()
            .sorted((a, b) -> a.toUpperCase().compareTo(b.toUpperCase()))
            .collect(Collectors.toList());
    }
    
}
