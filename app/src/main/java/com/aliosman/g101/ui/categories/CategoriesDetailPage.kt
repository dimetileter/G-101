package com.aliosman.g101.ui.categories

import android.os.Bundle
import android.view.ViewOutlineProvider
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliosman.g101.R
import com.aliosman.g101.core.utils.BaseActivity
import com.aliosman.g101.databinding.ActivityCategoriesDetailPageBinding

class CategoriesDetailPage : BaseActivity() {

    private lateinit var binding: ActivityCategoriesDetailPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoriesDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Set up toolbar actions
        val toolbar = binding.toolbar
        setupToolbar(toolbar)

        // BlurView
        setBlurView()

        // Settle the vertical segmented button's icons
        verticalSegmentedButtonsImplementation()

    }

    // Set blur view
    private fun setBlurView() {
        val radius = 20f
        val decorView = this.window.decorView

        val blurTarget = binding.blurTarget // BlurTarget
        val windowBackground = decorView.background
        val blurView = binding.blurView // Bulanıklık efektini gösterecek BlurView

        blurView.outlineProvider = ViewOutlineProvider.BACKGROUND
        blurView.setClipToOutline(true)
        blurView.setupWith(blurTarget)
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)
    }

    // Set verticak segmented buttons
    private fun verticalSegmentedButtonsImplementation() {
        // Values
        val topButton = binding.topButton.btnVerticalSegmentButton
        val midButton = binding.midButton.btnVerticalSegmentButton
        val bottomButton = binding.bottomButton.btnVerticalSegmentButton
        val buttons = listOf(topButton, midButton, bottomButton)

        // Settle the icons
        topButton.setImageResource(R.drawable.ic_add)
        midButton.setImageResource(R.drawable.ic_camera)
        bottomButton.setImageResource(R.drawable.state_favorite_ic_heart)

        // Listen all button, if clicked any one of them then apply that steps:
        buttons.forEach { btn ->
            btn.setOnClickListener {
                // Before, make all buttons unselected
                buttons.forEach { it.isSelected = false }

                // Then make selected clicked one
                btn.isSelected = true
            }
        }
    }
}