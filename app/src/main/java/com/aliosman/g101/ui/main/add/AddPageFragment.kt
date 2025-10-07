package com.aliosman.g101.ui.main.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.aliosman.g101.R
import com.aliosman.g101.databinding.FragmentAddPageBinding

class AddPageFragment : Fragment() {

    private var _binding: FragmentAddPageBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController
    private lateinit var nextButton: ImageButton
    private lateinit var backButton: ImageButton
    private val stepProgress = 100 / 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddPageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Horizontal Segmented Buttons
        initNavigationController()
        setupSegmentedButtons()
        setupNextAndBackButtons()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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

    // Navigation Control
    private fun initNavigationController() {
        // Find navhostfragment
        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment_container_view_add_page) as NavHostFragment
        navController = navHostFragment.navController

    }

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


    // region Permissions
    private fun checkCameraPermission() {

    }
    private fun checkGalleryPermission() {

    }

}