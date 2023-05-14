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

    @Test
    public void ignore_empty_words(){
        List<String> expected = new ArrayList<String>(){
            {
                add("an");
                add("Hello");
                add("is");
                add("this");
            }
        };
        assertEquals(expected, TopWords.create("Hello, this  is an").value());
    }

    @Test
    public void remove_duplicate_results(){
        List<String> expected = new ArrayList<String>(){
            {
                add("an");
                add("Hello");
                add("is");
                add("this");
            }
        };
        assertEquals(expected, TopWords.create("Hello, this  is an An").value());
    }

    @Test
    public void get_ranking_words_with_more_occurences(){
        List<String> expected = new ArrayList<String>(){
            {
                add("Hello");
                add("an");
                add("is");
                add("this");
            }
        };
        assertEquals(expected, TopWords.create("Hello, this hello is an").value());
    }
}
