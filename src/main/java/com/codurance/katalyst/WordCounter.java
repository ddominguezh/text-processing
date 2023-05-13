package com.codurance.katalyst;

public class WordCounter {

    private String text;
    protected WordCounter(String text){
        this.text = text;
    }
    public static WordCounter create(String text) {
        return new WordCounter(text);
    }
    
    public int count(){
        return 0;
    }
}
