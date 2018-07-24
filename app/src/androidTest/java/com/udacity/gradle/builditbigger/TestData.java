package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import static android.support.test.espresso.Espresso.onView;


import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

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
    public void setUp(){
        mIdlingResource = mTestRule.getActivity().getmCountingIdlingResource();
        mRegistry.register(mIdlingResource);
    }

    @Test
    public void testData(){
        onView(ViewMatchers.withId(R.id.fragment_button)).perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.display_text_tv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @After
    public void tearDown(){
        mRegistry.unregister(mIdlingResource);
    }

}
