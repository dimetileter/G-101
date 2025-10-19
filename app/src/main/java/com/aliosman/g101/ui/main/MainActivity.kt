package com.aliosman.g101.ui.main

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.view.ViewOutlineProvider
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.aliosman.g101.R
import com.aliosman.g101.adapter.viewPagerAdapter.MainPagesViewPager
import com.aliosman.g101.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.view.get
import com.aliosman.g101.ui.main.add.AddPageActivity
import com.aliosman.g101.ui.main.add.AddPageFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding bağla
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Set navigation bar window scale
        val navBar = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar)
        navBar.setOnApplyWindowInsetsListener { view, insets ->
            insets.consumeSystemWindowInsets()
        }

        // VivewPager2 ve Navigation bar bağlantısını yap
        viewPagerAndNavigationBarSync(navBar)
        // Appbar ve navigation bar blur efekti uygula
        blurEffect()


    }


    // Set up ViewPager and Navigation Bottom Bar
    private fun viewPagerAndNavigationBarSync(navBar: BottomNavigationView) {
        // Set up view pager
        val viewPager = binding.viewPager2
        viewPager.adapter = MainPagesViewPager(this)

        // ViewPager item listener
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                navBar.menu[position].isChecked = true
            }
        })

        // Navigationbar item listener
        navBar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home_page -> viewPager.setCurrentItem(0, false)
                R.id.combine_page -> viewPager.setCurrentItem(1, false)
                R.id.favorite_page -> viewPager.setCurrentItem(2, false)
                R.id.add_page -> {startAddPageActivity()}
            }
            true
        }
    }


    // Set up blur effect
    private fun blurEffect() {
        val radius = 25f
        val decorView = getWindow().getDecorView()
        val blurTarget = binding.blurTarget

        val windowBackground = decorView.background
        val blurViewNavBar = binding.blurViewNavbar


        blurViewNavBar.outlineProvider = ViewOutlineProvider.BACKGROUND
        blurViewNavBar.setClipToOutline(true)
        blurViewNavBar.setupWith(blurTarget)
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)

    }

    // Start AddPage Activity
    private fun startAddPageActivity() {
        val intent = Intent(this, AddPageActivity::class.java)
        startActivity(intent)
    }
}