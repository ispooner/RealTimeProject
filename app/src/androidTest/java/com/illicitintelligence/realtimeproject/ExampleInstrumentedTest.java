package com.illicitintelligence.realtimeproject;

import android.content.Context;

import androidx.test.espresso.Espresso;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.illicitintelligence.realtimeproject.view.MainActivity;
import com.illicitintelligence.realtimeproject.view.MainKActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.illicitintelligence.realtimeproject", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainKActivity> testRule = new ActivityTestRule<>(MainKActivity.class);

    @Test
    public void testEditText() {
        Espresso.onView(withId(R.id.main_message_editText)).perform(typeText("Hello"));
        Espresso.onView(withId(R.id.main_send_button)).perform(click());
        Espresso.onView(withId(R.id.main_message_editText)).check(matches(withText("")));
    }
}
