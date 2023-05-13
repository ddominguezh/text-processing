package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TextCleanerTest {
    
    @Test
    public void remove_dots(){
        assertEquals("Hello, this is an example for you to practice You should grab this text and make it as your test case", TextCleaner.create("Hello, this is an example for you to practice. You should grab this text and make it as your test case.").clean());
    }
}
