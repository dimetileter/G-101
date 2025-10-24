package com.aliosman.g101.ui.categories

import android.os.Bundle
import android.view.Menu
import android.view.ViewOutlineProvider
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliosman.g101.R
import com.aliosman.g101.core.utils.BaseActivity
import com.aliosman.g101.databinding.ActivityCategoriesPageBinding
import com.aliosman.g101.data.db.AppDatabase
import com.aliosman.g101.data.entity.Category
import com.aliosman.g101.data.entity.Clothes
import com.aliosman.g101.data.repository.CategoryRepository
import com.aliosman.g101.data.repository.ClothesRepository

class CategoriesPageActivity : BaseActivity() {

    // Binding ve popmenu
    private lateinit var binding: ActivityCategoriesPageBinding
    private lateinit var popupMenu: PopupMenu
    private var recyclerAdapter: ClothesListRecyclerAdapter? = null

    // ViewModel'i ve database yapılarını bağla
    private val db by lazy { AppDatabase.getInstance(this.applicationContext) }
    private val clothesDao by lazy { db.clothesDao() }
    private val categoriesDao by lazy { db.categoriesDao() }
    private val clothesRepository by lazy { ClothesRepository(clothesDao) }
    private val categoriesRepository by lazy { CategoryRepository(categoriesDao) }
    private val viewModelFactory by lazy { CategoriesViewModelFactory(clothesRepository, categoriesRepository) }
    private val viewModel: CategoriesViewModel by viewModels { viewModelFactory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // binding
        binding = ActivityCategoriesPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }


        // Split button and menu
        setUpSplitButtonAndMenu()

        // Load categories
        observeViewModel()

        // Set up toolbar actions
        val toolbar = binding.toolbar
        setupToolbar(toolbar)

        // BlurView
        setBlurView()
    }

    // Split button and menu
    private fun setUpSplitButtonAndMenu() {

        // Popup menu
        popupMenu = PopupMenu(this, binding.btnPopMenu)
        popupMenu.setOnDismissListener {
            binding.btnPopMenu.isSelected = false
        }

        // Split button actions
        binding.btnPopMenu.setOnClickListener {
            it.isSelected = true
            // Menüyü göster
            popupMenu.show()
        }

        /*
                Menüde ikonların gösterilmesi

        try {
            val field = popupMenu.javaClass.getDeclaredField("mPopup")
            field.isAccessible = true
            val menuPopupHelper = field.get(popupMenu)

            val setForceShowIcon = menuPopupHelper.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.javaPrimitiveType)
            setForceShowIcon.invoke(menuPopupHelper, true)

        } catch (e: Exception) {
            e.printStackTrace()
            // Reflection başarısız olursa (Android sürümü değiştiğinde olabilir)
            // Hata çıktısını log'lara yazdırır.
        }
        */
    }

    // Show Pop Menu
    private fun updatePopMenu(categories: List<Category>) {

        // Menü güncellenirken eski verileri temizle
        popupMenu.menu.clear()

        if(categories.isEmpty()) {
            Toast.makeText(this, "Kategori listesi boş döndü", Toast.LENGTH_SHORT).show()
        }
        // Menüyü doldur
            categories.forEachIndexed { index, category ->
            popupMenu.menu.add(
                Menu.NONE,
                category.categoryId.toInt(),
                index,
                getString(category.categoryName)
            )
        }

        // Menü tıklama olayını ayarla
        popupMenu.setOnMenuItemClickListener { menuItem ->
            val selectedCategory = categories.find { it.categoryId.toInt() == menuItem.itemId }
            selectedCategory?.let {
                Toast.makeText(this, "Seçilen: ${it.categoryId}", Toast.LENGTH_SHORT).show()
                // Seçilen kategori ile işlem yap
                handleCategorySelection(it)
            }
            true
        }
    }

    private fun handleCategorySelection(category: Category) {
        // Seçilen kategorinin metnini metin kutusuna koy
        binding.txtCategoryText.text = getString(category.categoryName)
    }

    // Observe ViewModel
    private fun observeViewModel() {
        println("Observe fonksiyonuna girildi.")

        viewModel.categoriesList.observe(this) { it ->
            println("categories Observe içine girildi")
            if (!it.isNullOrEmpty()) {
                println("Observer veriyi gözlemleri ve boş omadığından emin")
                updatePopMenu(it)
            }
        }

        viewModel.clothesList.observe(this) { it ->
            println("clothes Observe içine girildi")
            if(!it.isNullOrEmpty()) {
                setUpRecyclerAdapter(it)
            }
        }
    }

    // RecyclerView
    private fun setUpRecyclerAdapter(clothesList: List<Clothes>) {
        // Recycler Adapter
        recyclerAdapter = ClothesListRecyclerAdapter(clothesList)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter
    }

    // Set blur view
    private fun setBlurView() {
        val radius = 20f
        val decorView = this.window.decorView

        val blurTarget = binding.blurTarget // BlurTarget
        val windowBackground = decorView.background
        val blurView = binding.blurViewAppbar // Bulanıklık efektini gösterecek BlurView

        blurView.outlineProvider = ViewOutlineProvider.BACKGROUND
        blurView.setClipToOutline(true)
        blurView.setupWith(blurTarget)
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)
    }
}