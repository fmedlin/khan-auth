package com.twotoasters.khanauth

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu

class StartupActivity(am : AccountManager) extends Activity {

	var accountManager = am

	val NewAccountCode = 100
	val ExistingAccountCode = 101
	val UsernameParam = "username"

	def this() {
		this(null)
	}

    override def onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        login
    }

    def login {
        if (accountManager == null) {
        	accountManager = AccountManager.get(this)
        }

    	val accounts = accountManager.getAccountsByType("com.twotoasters.khanauth")
    	if (accounts.isEmpty) {
    		val intent = new Intent(this, classOf[AuthenticatorActivity])
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
			startActivityForResult(intent, NewAccountCode)
    	}
    	else {
    		val password = accountManager.getPassword(accounts.head)
    		if (password == null) {
	    		val intent = new Intent(this, classOf[AuthenticatorActivity])
	    		intent.putExtra(UsernameParam, accounts.head.name)
				startActivityForResult(intent, ExistingAccountCode)
    		}
    	}
    }

}

