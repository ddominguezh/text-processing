package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TextCleanerTest {
    
    @Test
    public void remove_dots(){
        assertEquals("Hello this is an example for you to practice You should grab this text and make it as your test case", TextCleaner.create("Hello this is an example for you to practice. You should grab this text and make it as your test case.").clean());
    }

    @Test
    public void remove_commas_and_dots(){
        assertEquals("Hello this is an example for you to practice You should grab this text and make it as your test case", TextCleaner.create("Hello, this is an example for you to practice. You should grab this text and make it as your test case.").clean());
    }

    @Test
    public void remove_commas_and_dots_and_brackets(){
        assertEquals("Hello this is an example for you to practice You should grab this text and make it as your test case", TextCleaner.create("Hello, this is an example for you to practice. You should grab this (text) and make it as your test case.").clean());
    }

    @Test
    public void remove_javascript_code(){
        assertEquals("Hello this is an example for you to practice  You should grab this text and make it as your test case", TextCleaner.create("Hello, this is an example for you to practice. <javascript>if (true) {console.log('should should should')}</javascript> You should grab this (text) and make it as your test case.").clean());
    }
    
}
