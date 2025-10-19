package com.aliosman.g101.ui.main.add

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.aliosman.g101.R
import com.aliosman.g101.core.utils.BaseActivity
import com.aliosman.g101.databinding.ActivityAddPageBinding

class AddPageActivity : BaseActivity() {

    private lateinit var binding: ActivityAddPageBinding

    private lateinit var navController: NavController
    private lateinit var nextButton: ImageButton
    private lateinit var backButton: ImageButton
    private val stepProgress = 100 / 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAddPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tolbar back button option
        val toolbar = binding.toolbar
        setupToolbar(toolbar)

        initNavigationController()
        setupSegmentedButtons()
        setupNextAndBackButtons()

    }

    // Set navigation controller
    private fun initNavigationController() {
        // Find navhostfragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view_add_page) as NavHostFragment
        navController = navHostFragment.navController
    }

    // Set up nextButton for the firs time
    private fun setupSegmentedButtons() {
        // Segmented buttons
        val button1 = binding.button1
        val button2 = binding.button2
        val segmentedBars = listOf(button1.segmentedBar, button2.segmentedBar)

        // Next button
        nextButton = binding.btnNext.btnSegmentedNextButton
        nextButton.isSelected = true

        // Place icons and texts
        button1.apply {
            icon.setImageResource(R.drawable.state_ic_camera)
            txtButtonText.setText(R.string.camera)
        }

        button2.apply {
            icon .setImageResource(R.drawable.state_ic_folder)
            txtButtonText.setText(R.string.gallery)
        }

        // Listen clicks and
        segmentedBars.forEachIndexed { index, bar ->
            bar.setOnClickListener {
                // Make all buttons unselected
                segmentedBars.forEach { it.isSelected = false }

                bar.isSelected = true
                when(index) {
                    0 -> {/*Run camera permission and camera options*/}
                    1 -> {/*Run gallery permission and select image options*/}
                    3 -> {
                        navigateNextStep()
                    }
                }
            }
        }
    }

    // Setup for the firs time back button
    private fun setupNextAndBackButtons() {
        backButton = binding.btnBack.btnSegmentedNextButton
        backButton.setImageResource(R.drawable.ic_back_arrow_left)
        val buttons = listOf(backButton, nextButton)

        // Make all buttons unselected then make clicked button selected
        buttons.forEachIndexed { index, btn ->
            btn.setOnClickListener {
                buttons.forEach { it.isSelected = false }
                btn.isSelected = true
                when(index) {
                    0 -> {navigateBackStep()}
                    1 -> {navigateNextStep()}
                }
            }
        }
    }

    // Navigate next page
    private fun navigateNextStep() {
        // Listen next button
        when(navController.currentDestination?.id) {
            R.id.fragmentAddStep1 -> {
                navController.navigate(R.id.action_fragmentAddStep1_to_fragmentAddStep2)
                binding.llHorizontalGroup.visibility = View.GONE
                binding.llNextAndBackButton.visibility = View.VISIBLE
            }
            R.id.fragmentAddStep2 -> {
                navController.navigate(R.id.action_fragmentAddStep2_to_fragmentAddStep3)
            }
        }
    }

    // Navigate back page
    private fun navigateBackStep() {
        when(navController.currentDestination?.id) {
            R.id.fragmentAddStep2 -> {
                navController.navigate(R.id.action_fragmentAddStep2_to_fragmentAddStep1)
                binding.llHorizontalGroup.visibility = View.VISIBLE
                binding.llNextAndBackButton.visibility = View.GONE
            }
            R.id.fragmentAddStep3 -> {
                navController.navigate(R.id.action_fragmentAddStep3_to_fragmentAddStep2)
            }
        }
    }

}