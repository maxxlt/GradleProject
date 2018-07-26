package com.udacity.gradle.builditbigger;


import android.support.test.espresso.IdlingRegistry;

import static android.support.test.espresso.Espresso.onView;


import android.support.test.espresso.idling.CountingIdlingResource;

import static android.support.test.espresso.action.ViewActions.click;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.not;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TestData {

    @Rule
    public ActivityTestRule<MainActivity> mTestRule = new ActivityTestRule<>(MainActivity.class);

    private CountingIdlingResource mIdlingResource;
    private IdlingRegistry mRegistry = IdlingRegistry.getInstance();

    @Before
    public void setUp() {
        mIdlingResource = mTestRule.getActivity().getmCountingIdlingResource();
        mRegistry.register(mIdlingResource);
    }

    @Test
    public void testData() {
        onView(withId(R.id.fragment_button)).perform(click());
        onView(withId(R.id.display_text_tv)).check(matches(not(withText(""))));
    }

    @After
    public void tearDown() {
        mRegistry.unregister(mIdlingResource);
    }

}
