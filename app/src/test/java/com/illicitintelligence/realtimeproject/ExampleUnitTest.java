package com.illicitintelligence.realtimeproject;

import com.illicitintelligence.realtimeproject.model.Error;
import com.illicitintelligence.realtimeproject.model.Message;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testMessageTitle() {
        Message x = new Message("title", "Date", "username", "content");
        assertEquals("title", x.getMessageTitle());
    }

    @Test
    public void testErrorType() {
        Error x = new Error("Error", "There was an error");
        assertEquals("Error", x.getType());
    }
}