package com.twotoasters.khanauth

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu

class StartupActivity extends Activity {

	val resultCode = 100
	val account : Account = null

    override def onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        login
    }

    def login {
    	val am = AccountManager.get(this)
    	val accounts = am.getAccountsByType("com.twotoasters.khanauth")
    	if (accounts.isEmpty) {
    		val intent = new Intent(this, classOf[AuthenticatorActivity])
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
			startActivityForResult(intent, resultCode)
    	}
    }
}

