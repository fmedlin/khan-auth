package com.twotoasters.khanauth

import java.net.URI;

import org.apache.http.client.methods.HttpUriRequest;
import org.fest.assertions.api.ANDROID._
import org.hamcrest.CoreMatchers._
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

import android.accounts.AccountManager
import android.content.Intent
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText

@RunWith(classOf[RobolectricTestRunner])
class AuthenticatorActivityTest {

	var activity : AuthenticatorActivity = null

	@Before def setUp {
		activity = new AuthenticatorActivity()
		activity.setIntent(
			new Intent()
				.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, null.asInstanceOf[Parcelable])
		)
		activity.onCreate(null)		
	}

	@Test def shouldNotBeNull {
		assertNotNull(activity)
	}

	@Test def shouldShowCredentialFields {
		assertThat(activity.findViewById(R.id.edit_username)).isVisible()
		assertThat(activity.findViewById(R.id.edit_password)).isVisible()
	}

	@Test def shouldShowSubmitButtons {
		assertThat(activity.findViewById(R.id.button_ok)).isVisible()
		assertThat(activity.findViewById(R.id.button_cancel)).isVisible()
	}

	@Test def shouldSignupByEmail {
		val username = activity.findById[EditText](R.id.edit_username)
		val password = activity.findById[EditText](R.id.edit_password)
		username.setText("boom")
		password.setText("toasted")
		
		val loginButton = activity.findById[Button](R.id.button_ok)
		loginButton.performClick

		//val request = Robolectric.getSentHttpRequest(0).asInstanceOf[HttpUriRequest];
		//val uri = request.getURI();
    	//Assert.assertThat(uri, equalTo(URI.create("https://www.googleapis.com/discovery/v1/apis")));
	}
}