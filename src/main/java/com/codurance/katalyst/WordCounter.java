package com.codurance.katalyst;

import java.util.Arrays;

public class WordCounter {

    private String text;
    protected WordCounter(String text){
        this.text = text;
    }
    public static WordCounter create(String text) {
        return new WordCounter(text);
    }
    
    public long count(){
        if("".equals(TextCleaner.create(text).clean().trim())){
            return 0;
        }
        return Arrays.asList(TextCleaner.create(text).clean().split(" ", -1)).stream().filter(word -> !"".equals(word)).count();
    }
}
