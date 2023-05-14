package com.codurance.katalyst;

import java.util.List;

public class TopWords {

    private String text;
    protected TopWords(String text){
        this.text = text;
    }
    public static TopWords create(String text) {
        return new TopWords(text);
    }
    public List<String> value() {
        return null;
    }
    
}
