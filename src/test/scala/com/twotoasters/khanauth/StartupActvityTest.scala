package com.twotoasters.khanauth;

import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.robolectric.RobolectricTestRunner
import org.robolectric.matchers.StartedMatcher

@RunWith(classOf[RobolectricTestRunner])
class StartupActivityTest {

    var activity: StartupActivity = null

    @Before def setup {
        activity = new StartupActivity
        activity.onCreate(null)
    }

    @Test def itShouldAuthenticate {
    	assertThat(activity, new StartedMatcher(classOf[AuthenticatorActivity]))
    }

}