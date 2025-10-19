package com.aliosman.g101.ui.main.add

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.aliosman.g101.R
import com.aliosman.g101.core.utils.BaseActivity
import com.aliosman.g101.databinding.ActivityAddPageBinding
import com.aliosman.g101.ui.main.MainActivity
import kotlin.getValue

class AddPageActivity : BaseActivity() {

    private lateinit var binding: ActivityAddPageBinding

    private lateinit var navController: NavController
    private lateinit var pickMedia: ActivityResultLauncher<PickVisualMediaRequest>
    private val viewModel: AddPageViewModel by viewModels()

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

        // Toolbar back button option
        val toolbar = binding.toolbar
        setNavigationOnClickListenerWithIntent(toolbar, turnBackMainPage(), true)

        // SADECE BİR KEZ ÇAĞRILACAK KURULUM FONKSİYONLARI
        initializePhotoPicker()
        setupNavigationAndUIUpdates()
        setupStep1Controls()
        setupStep2Controls()

    }

    /**
        Sayfa her değiştiğinde arayüzü güncellemek.
     */
    private fun setupNavigationAndUIUpdates() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view_add_page) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragmentAddStep1 -> {
                    binding.progressIndicator.setProgress(25, true)
                    binding.llHorizontalGroup.visibility = View.VISIBLE
                    binding.llNextAndBackButton.visibility = View.GONE
                }
                R.id.fragmentAddStep2 -> {
                    binding.progressIndicator.setProgress(50, true)
                    binding.llHorizontalGroup.visibility = View.GONE
                    binding.llNextAndBackButton.visibility = View.VISIBLE
                }
                R.id.fragmentAddStep3 -> {
                    binding.progressIndicator.setProgress(75, true)
                    binding.llHorizontalGroup.visibility = View.GONE
                    binding.llNextAndBackButton.visibility = View.GONE
                }
            }
        }
    }

    /**
         1. Adımdaki (Kamera/Galeri/İleri) butonlarının tüm kurulumunu bir kez yapmak.
     */
    private fun setupStep1Controls() {
        val cameraButtonLayout = binding.button1
        val galleryButtonLayout = binding.button2
        val nextButton = binding.btnNext.btnSegmentedNextButton
        nextButton.isSelected = true

        // Butonların UI metin ve ikonlarını ayarla
        cameraButtonLayout.apply {
            icon.setImageResource(R.drawable.state_ic_camera)
            txtButtonText.setText(R.string.camera)
        }
        galleryButtonLayout.apply {
            icon.setImageResource(R.drawable.state_ic_folder)
            txtButtonText.setText(R.string.gallery)
        }

        val segmentedButtons = listOf(cameraButtonLayout.root, galleryButtonLayout.root)

        // Kamera ve Galeri butonları için tıklama ve 'isSelected' mantığı
        segmentedButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                // Önce ikisini de seçilmemiş yap
                segmentedButtons.forEach { it.isSelected = false }
                // Sonra tıklananı seçilmiş yap
                button.isSelected = true

                when(index) {
                    0 -> { /* Kamera kodunu çağır */ }
                    1 -> { launchPhotoPicker() }
                }
            }
        }

        // 1. Adım İleri butonu için tıklama mantığı
        nextButton.setOnClickListener {
            navController.navigate(R.id.action_fragmentAddStep1_to_fragmentAddStep2)
        }
    }

    /**
        2. Adımdaki (Geri/İleri) butonlarının tüm kurulumunu bir kez yapmak.
     */
    private fun setupStep2Controls() {
        val backButton = binding.btnBack.btnSegmentedBackButton
        val nextButton2 = binding.btnNextStep2.btnSegmentedNextButton
        nextButton2.isSelected = true

        backButton.setOnClickListener {
            navController.popBackStack() // Geri git
        }

        nextButton2.setOnClickListener {
            navController.navigate(R.id.action_fragmentAddStep2_to_fragmentAddStep3)
        }
    }

    private fun initializePhotoPicker() {
        pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                viewModel.onImageSelected(uri)
                Toast.makeText(this, "Resim seçildi: $uri", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun launchPhotoPicker() {
        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private fun turnBackMainPage(): Intent {
        return Intent(this, MainActivity::class.java)
    }

}