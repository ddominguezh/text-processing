package com.codurance.katalyst;

public class AverageReading {

    private static float WORDS_PER_MINUTE = 200;
    private long words;
    protected AverageReading(long words){
        this.words = words;
    }
    public static AverageReading create(long words) {
        return new AverageReading(words);
    }
    public String value() {
        float average = words / WORDS_PER_MINUTE;
        int minute = (int)average;
        int seconds = (int)(((average - minute) * 0.6) * 100);
        return minute + "' " + seconds + "''";
    }
    
}
