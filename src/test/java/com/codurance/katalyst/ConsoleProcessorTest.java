package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsoleProcessorTest {
    
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp(){
        this.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.outputStream));
    }

    @Test
    public void print_analysis_text(){
        StringBuffer given = new StringBuffer();
        given.append("Hello, this is an example for you to practice. You should grab this text and make it as your test case:\n");
        given.append("<javascript>\n");
        given.append("if (true) {\n");
        given.append("console.log('should should should')\n");
        given.append("}\n");
        given.append("</javascript>\n");

        StringBuffer expected = new StringBuffer();
        expected.append("Those are the top 10 words used:\n");
        expected.append("\n");
        expected.append("1. you\n");
        expected.append("2. this\n");
        expected.append("3. your\n");
        expected.append("4. to\n");
        expected.append("5. text\n");
        expected.append("6. test\n");
        expected.append("7. should\n");
        expected.append("8. practice\n");
        expected.append("9. make\n");
        expected.append("10. it\n");
        expected.append("\n");
        expected.append("The text has in total 21 words\n");

        ConsoleProcessor processor = new ConsoleProcessor();
        processor.analyse(given.toString());

        assertEquals(expected.toString(), this.outputStream.toString());
    }
}
