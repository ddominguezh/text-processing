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
                add("this");
                add("is");
                add("Hello");
                add("an");
            }
        };
        assertEquals(expected, TopWords.create("Hello, this is an").all());
    }

    @Test
    public void ignore_empty_words(){
        List<String> expected = new ArrayList<String>(){
            {
                add("this");
                add("is");
                add("Hello");
                add("an");
            }
        };
        assertEquals(expected, TopWords.create("Hello, this  is an").all());
    }

    @Test
    public void remove_duplicate_results(){
        List<String> expected = new ArrayList<String>(){
            {
                add("an");
                add("this");
                add("is");
                add("Hello");
            }
        };
        assertEquals(expected, TopWords.create("Hello, this  is an An").all());
    }

    @Test
    public void get_ranking_words_with_more_occurences(){
        List<String> expected = new ArrayList<String>(){
            {
                add("Hello");
                add("this");
                add("is");
                add("an");
            }
        };
        assertEquals(expected, TopWords.create("Hello, this hello is an").all());
    }

    @Test
    public void return_a_maximum_number_of_results(){
        List<String> expected = new ArrayList<String>(){
            {
                add("you");
                add("this");
                add("your");
                add("to");
                add("text");
                add("test");
                add("should");
                add("practice");
                add("make");
                add("it");
            }
        };
        assertEquals(expected, TopWords.create("Hello, this is an example for you to practice. You should grab this text and make it as your test case.").max(10));
    }
}
