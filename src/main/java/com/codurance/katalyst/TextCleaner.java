package com.codurance.katalyst;

public class TextCleaner {

    private String text;
    protected TextCleaner(String text){
        this.text = text;
    }
    public static TextCleaner create(String text) {
        return new TextCleaner(text);
    }
    public String clean(){
        return this.text.replace(".", "").replace(",", "");
    }
}
