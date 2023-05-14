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
        return removeJavascriptCode(this.text, "javascript").chars()
            .filter(c -> Character.isDigit(c) || Character.isAlphabetic(c) || Character.isWhitespace(c))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
    private String removeJavascriptCode(String text, String tag){
        int startIndex = text.indexOf("<" + tag + ">");
        if(startIndex != -1){
            while(startIndex != -1){
                int lastIndex = text.indexOf("</" + tag + ">");
                text = text.substring(0, startIndex) + text.substring(lastIndex + tag.length() + 3);
                startIndex = text.indexOf("<" + tag + ">");
            }
        }
        return text;
    }
}
