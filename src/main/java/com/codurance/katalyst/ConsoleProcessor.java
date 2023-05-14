package com.codurance.katalyst;

public class ConsoleProcessor implements Processor{

    private static final int MAX_TOP_RESULTS = 10;
    @Override
    public void analyse(String text) {
        System.out.println("Those are the top " + MAX_TOP_RESULTS + " words used:");
        System.out.println("");

        int index = 1;
        for (String word : TopWords.create(text).max(MAX_TOP_RESULTS)) {
            System.out.println(index + ". " + word);
            index++;
        }

        System.out.println("");
        System.out.println("The text has in total " + WordCounter.create(text).count() + " words");
        
    }
    
}
