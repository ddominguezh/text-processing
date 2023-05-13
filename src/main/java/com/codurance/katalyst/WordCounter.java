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
        if("".equals(TextCleaner.create(text).clean().trim())){
            return 0;
        }
        return 1;
    }
}
