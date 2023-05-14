package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AverageReadingTest {
    
    @Test
    public void get_average_reading_by_word(){
        assertEquals("0' 6''", AverageReading.create(WordCounter.create("Hello, this is an example for you to practice. You should grab this text and make it as your test case.").count()).value());
        assertEquals("3' 54''", AverageReading.create(783).value());
    }
}
