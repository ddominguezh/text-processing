package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TopWordsTest {
    
    @Test
    public void sort_words_with_the_same_occurrences(){
        List<String> expected = new ArrayList<String>(){
            {
                add("an");
                add("Hello");
                add("is");
                add("this");
            }
        };
        assertEquals(expected, TopWords.create("Hello, this is an").value());
    }
}
