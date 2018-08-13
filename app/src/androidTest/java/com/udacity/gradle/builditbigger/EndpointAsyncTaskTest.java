package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest
{

    @Test
    public void testEndpointAsyncTask_result_not_emtpy() throws InterruptedException
    {
        final CountDownLatch signal = new CountDownLatch(1);

        EndpointsAsyncTask.Listener listener = new EndpointsAsyncTask.Listener()
        {
            @Override
            public void onJokeReceived(String superFunnyJoke)
            {
                Assert.assertNotNull(superFunnyJoke);
                Assert.assertTrue(superFunnyJoke.length() > 0);

                signal.countDown();
            }
        };

        new EndpointsAsyncTask(listener).execute();

        signal.await();
    }
}
