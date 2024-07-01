package com.pricecomparation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkPricePerKg100(){
        onView(withId(R.id.editTextPrice1)).perform(typeText("100"));
        onView(withId(R.id.editTextWeight1)).perform(typeText("1000"));
        onView(withId(R.id.textViewPricePerKg1)).check(matches(withText("100.00")));
    }

    @Test
    public void checkResultIfPriceIsNull(){
        onView(withId(R.id.editTextWeight1)).perform(typeText("1000"));
        onView(withId(R.id.textViewPricePerKg1)).check(matches(withText("")));
    }

}
