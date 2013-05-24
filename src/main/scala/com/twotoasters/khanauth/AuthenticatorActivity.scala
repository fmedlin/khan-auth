package com.twotoasters.khanauth

import android.accounts.AccountAuthenticatorActivity
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText

object AuthenticatorActivity {
	def NewAccountRequest = "new_account_request"
}

class AuthenticatorActivity extends AccountAuthenticatorActivity {

	lazy val usernameEdit : EditText = { findById[EditText](R.id.edit_username) }
	lazy val passwordEdit : EditText = { findById[EditText](R.id.edit_password) }

	var username : String = null
	var password : String = null

	override def onCreate(savedInstanceState : Bundle) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_authenticator)
	}

	def findById[V <: View](resource : Int) : V = {
		findViewById(resource).asInstanceOf[V]
	}

	def onLoginClick(v : View) {
		if (isNewAccountRequest) {
			username = usernameEdit.getText().toString
		}
		password = passwordEdit.getText.toString
	}

	def isNewAccountRequest : Boolean = {
		return true
	}
}



