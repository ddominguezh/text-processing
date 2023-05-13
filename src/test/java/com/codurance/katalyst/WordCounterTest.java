package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WordCounterTest {
    
    @Test
    public void count_words(){
        assertEquals(1, WordCounter.create("Hello").count());
    }

    @Test
    public void ignore_empty_string(){
        assertEquals(0, WordCounter.create("").count());
    }
}
