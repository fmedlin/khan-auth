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
//import org.robolectric.matchers.StartedMatcher

@RunWith(classOf[RobolectricTestRunner])
class StartupActivityTest {

    var activity : StartupActivity = null
    var manager : AccountManager = null

    @Before def setup {
        activity = new StartupActivity
        manager = AccountManager.get(Robolectric.application)
    }

    @Test def itShouldAddNewAccount {
		activity.login
        assertThat(shadowOf(activity).getNextStartedActivity(),
            equalTo(
                new Intent()
                    .setClassName("com.twotoasters.khanauth", classOf[AuthenticatorActivity].getName())
            )
        )
    }

    @Test def itShouldAuthenticateExistingAccount {
        //shadowOf(manager).addAccount(new Account("fred", "com.google"))
        val manager = mock(classOf[AccountManager])
        val account = new Account("fred", "com.google")

        when(manager.getAccountsByType("com.google"))
            .thenReturn(Array(account))
        when(manager.getPassword(account))
            .thenReturn(null)

        activity.login(manager)
    	assertThat(shadowOf(activity).getNextStartedActivity(),
    		equalTo(new Intent()
        		.setClassName("com.twotoasters.khanauth", classOf[AuthenticatorActivity].getName())
        		.putExtra("username", "fred")))
    }

    @Test def itShouldAllowAuthenticatedUsers {
	    val manager = mock(classOf[AccountManager])
	    val account = new Account("fred", "com.google")

    	when(manager.getAccountsByType("com.google"))
    		.thenReturn(Array(account))
    	when(manager.getPassword(account))
    	 	.thenReturn("monkey")

        activity.login(manager)
    	assertThat(shadowOf(activity).getNextStartedActivity(),
    		equalTo(new Intent()
        		.setClassName("com.twotoasters.khanauth", classOf[MainActivity].getName())))
    }
}
