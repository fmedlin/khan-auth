package com.twotoasters.khanauth;

import android.accounts.Account
import android.accounts.AccountManager
import android.content.Intent

import org.hamcrest.CoreMatchers._

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

import org.mockito.Mockito._

import org.robolectric._
import org.robolectric.Robolectric._
import org.robolectric.matchers.StartedMatcher

@RunWith(classOf[RobolectricTestRunner])
class StartupActivityTest {

    val accountManager = mock(classOf[AccountManager])
	val account = new Account("fred", "com.twotoasters.khanauth")

    var activity: StartupActivity = null

    @Test def itShouldAuthenticateNewAccount {
        activity = new StartupActivity
        activity.onCreate(null)

    	assertThat(activity, new StartedMatcher(classOf[AuthenticatorActivity]))
    }

    @Test def itShouldAuthenticateExistingAccount {
    	when(accountManager.getAccountsByType("com.twotoasters.khanauth"))
    		.thenReturn(Array[Account](account))

        activity = new StartupActivity(accountManager)
        activity.onCreate(null)

        val expected = new Intent()
        	.setClassName("com.twotoasters.khanauth", classOf[AuthenticatorActivity].getName())
        	.putExtra("username", "fred")

    	assertThat(shadowOf(activity).getNextStartedActivity(),
    		equalTo(expected))
    }

    @Test def itShouldAllowAuthenticatedUsers {
    	fail("Implement me")
    }
}
