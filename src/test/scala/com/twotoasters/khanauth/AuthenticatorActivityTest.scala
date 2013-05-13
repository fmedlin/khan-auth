package com.twotoasters.khanauth

import org.fest.assertions.api.ANDROID._

import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.robolectric.RobolectricTestRunner

@RunWith(classOf[RobolectricTestRunner])
class AuthenticatorActivityTest {

	var activity : AuthenticatorActivity = null

	@Before def setUp {
		activity = new AuthenticatorActivity()
		activity.onCreate(null)		
	}

	@Test def itShouldNotBeNull {
		assertNotNull(activity)
	}

	@Test def shouldHaveCredentialFields {
		assertThat(activity.findViewById(R.id.edit_username)).isVisible()
		assertThat(activity.findViewById(R.id.edit_password)).isVisible()
	}

	@Test def shouldHaveSubmitButtons {
		assertThat(activity.findViewById(R.id.button_ok)).isVisible()
		assertThat(activity.findViewById(R.id.button_cancel)).isVisible()
	}

}