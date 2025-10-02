package com.aliosman.g101.ui.onBoarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.aliosman.g101.R
import com.aliosman.g101.databinding.ActivityOnBoardingBinding
import com.aliosman.g101.ui.main.MainActivity
import kotlin.jvm.java

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Binding
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, 0)
            insets
        }

        // NavHostFragment üzerinden navController al
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController

        // Butonu ayarla
        val nextButton = binding.btnSegmentedNextButton.btnSegmentedNextButton
        nextButton.isSelected = true

        nextButton.setOnClickListener {
            when (navController.currentDestination?.id) {
                R.id.introFragment1 -> {
                    navController.navigate(R.id.action_introFragment1_to_introFragment2)
                }
                R.id.introFragment2 -> {
                    navController.navigate(R.id.action_introFragment2_to_introFragment3)
                }
                R.id.introFragment3 -> {
                    // 3. fragmentten sonra başka activity aç
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}