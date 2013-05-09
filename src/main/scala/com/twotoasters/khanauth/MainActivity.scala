package com.twotoasters.khanauth

import android.app.Activity
import android.os.Bundle
import android.view.Menu

class MainActivity extends Activity {

    override def onCreate(savedInstanceState: Bundle) = {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
    }    

    override def onCreateOptionsMenu(menu: Menu) = {
        getMenuInflater().inflate(R.menu.main, menu)
        true
    }

}

