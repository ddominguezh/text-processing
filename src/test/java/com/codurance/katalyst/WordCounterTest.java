package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WordCounterTest {
    
    @Test
    public void count_one_word(){
        assertEquals(1, WordCounter.create("Hello").count());
    }

    @Test
    public void ignore_empty_string(){
        assertEquals(0, WordCounter.create("").count());
    }

    @Test
    public void ignore_empty_string_with_white_spaces(){
        assertEquals(0, WordCounter.create("   ").count());
    }

    @Test
    public void ignore_symbols(){
        assertEquals(0, WordCounter.create("(·%*` ").count());
    }

    @Test
    public void counts_words_from_text(){
        assertEquals(21, WordCounter.create("Hello, this is an example for you to practice. You should grab this text and make it as your test case.").count());
    }

    @Test
    public void ignore_empty_words_from_text(){
        assertEquals(21, WordCounter.create("Hello, this  is an example   for  you to practice. You should grab this text and make it as your test case.").count());
    }
}
