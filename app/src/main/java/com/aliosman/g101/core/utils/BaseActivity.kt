package com.aliosman.g101.core.utils

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: androidx.appcompat.widget.Toolbar) {
        // Set toolbar as an appbar
//        setSupportActionBar(toolbar).apply {
//            title = null
//        }
        // Listen to the appbar back button clicks
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
