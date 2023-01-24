package com.example.android1_1;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;


import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ChangeTextBehaviorTest {

    public static final String STRING_ANAGRAM = "!";
    public static final String STRING_FILTER = "xl";

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.android1_1", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);


    private String getResourceString(int id) {
        Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        return targetContext.getResources().getString(id);
    }

    @Test
    public void allViewsIsDisplayed() {
        onView(withId(R.id.input_text)).check(matches(isDisplayed()));
        onView(withId(R.id.input_filter)).check(matches(isDisplayed()));
        onView(withId(R.id.anagram_text)).check(matches(isDisplayed()));
    }

    @Test
    public void typeInputAndFilterText() {
        onView(withId((R.id.input_text))).perform(typeText(STRING_ANAGRAM), closeSoftKeyboard());
        onView(withId(R.id.input_filter)).perform(typeText(STRING_FILTER), closeSoftKeyboard());

        onView(withId(R.id.anagram_text)).check(matches(withText(STRING_ANAGRAM)));
    }

    @Test
    public void typeInputAndFilterTextThanDeleteText() {
        onView(withId((R.id.input_text))).perform(typeText(STRING_ANAGRAM), closeSoftKeyboard());
        onView(withId(R.id.input_filter)).perform(typeText(STRING_FILTER), closeSoftKeyboard());

        onView(withId((R.id.input_text))).perform(replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.input_filter)).perform(replaceText(""), closeSoftKeyboard());

        onView(withId(R.id.anagram_text)).check(matches(withText(getResourceString(R.string.anagram_text_def))));

    }

}
