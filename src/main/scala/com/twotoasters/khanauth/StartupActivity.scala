package com.twotoasters.khanauth

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu

class StartupActivity extends Activity {

	val NewAccountCode = 100
	val ExistingAccountCode = 101
	val UsernameParam = "username"

    override def onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        login
    }

    def login {
    	login(AccountManager.get(this))
    }

    def login(accountManager : AccountManager) {
    	val accounts = accountManager.getAccountsByType("com.google")
    	if (accounts.isEmpty) {
    		val intent = new Intent(this, classOf[AuthenticatorActivity])
				.setFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
			startActivityForResult(intent, NewAccountCode)
    	}
    	else {
    		val password = accountManager.getPassword(accounts.head)
    		if (password == null) {
	    		val intent = new Intent(this, classOf[AuthenticatorActivity])
	    			.putExtra(UsernameParam, accounts.head.name)
				startActivityForResult(intent, ExistingAccountCode)
    		}
    		else {
    			startActivity(new Intent(this, classOf[MainActivity]))
    			finish
    		}
    	}
    }
}

