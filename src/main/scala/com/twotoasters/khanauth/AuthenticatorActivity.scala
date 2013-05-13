package com.twotoasters.khanauth

import android.accounts.AccountAuthenticatorActivity
import android.app.Activity
import android.os.Bundle

object AuthenticatorActivity {
	def NewAccountRequest = "new_account_request"
}

class AuthenticatorActivity extends AccountAuthenticatorActivity {

	override def onCreate(savedInstanceState : Bundle) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_authenticator)
	}
}