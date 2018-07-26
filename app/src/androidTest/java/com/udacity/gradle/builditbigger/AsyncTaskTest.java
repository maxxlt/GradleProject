package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.util.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertFalse;

//https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {
    private final CountDownLatch mSignal = new CountDownLatch(1);

    @Rule
    public ActivityTestRule<MainActivity> mTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTask() throws Throwable {
        final EndpointsAsyncTask mTask = new EndpointsAsyncTask() {
            @Override
            protected String doInBackground(Pair<Context, String>... params) {
                return super.doInBackground(params);
            }

            @Override
            protected void onPostExecute(String result) {
                Log.v("AsyncTest","result value is: " + result);
                assertNotNull(result);
                assertFalse(result.equals(""));
                mSignal.countDown();
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mTask.execute(new Pair<Context, String>(mTestRule.getActivity(),"Max"));
            }
        };

        runnable.run();
        mSignal.await(30, TimeUnit.SECONDS);

    }

}
