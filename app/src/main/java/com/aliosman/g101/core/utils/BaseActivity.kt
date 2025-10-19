package com.aliosman.g101.core.utils

import android.content.Intent
import android.widget.Toast
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

    protected fun setNavigationOnClickListenerWithIntent(
        toolbar: androidx.appcompat.widget.Toolbar,
        intent: Intent,
        kill: Boolean = false) {

        toolbar.setNavigationOnClickListener {
            startActivity(intent)
            if (kill == true) {
                finish()
                Toast.makeText(this,"kill yapıldı", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
