package com.aliosman.g101.ui.categories

import android.os.Bundle
import android.view.MenuItem
import android.view.ViewOutlineProvider
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliosman.g101.R
import com.aliosman.g101.databinding.ActivityCategoriesPageBinding

class CategoriesPageActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    private lateinit var binding: ActivityCategoriesPageBinding
    private lateinit var popupMenu: PopupMenu
    private var recyclerAdapter: ClothesListRecyclerAdapter? = null

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

        // Recycler Adapter
        val clothesList = getClothesList()
        recyclerAdapter = ClothesListRecyclerAdapter(clothesList)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        // BlurView
        setBlurView()

        // Appbar navigaion ıcon
        binding.toolbar.setNavigationOnClickListener {
            setAppbarNavigationIconBehavior()
        }

        // Split button actions
        val splitButtonMenu = binding.splitButtonMenu
        splitButtonMenu.setOnClickListener {
            showPopupMenu()
        }

        // Pop menu initialization and listeners
        popupMenu = PopupMenu(this, binding.splitButtonMenu)
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.setOnDismissListener {
            splitButtonMenu.isPressed = true
            Toast.makeText(this, "Pop-up closed", Toast.LENGTH_SHORT).show()
        }

        //popup menu
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.split_button_categories_menu, popupMenu.menu)
        try {
            val field = popupMenu.javaClass.getDeclaredField("mPopup")
            field.isAccessible = true
            val menuPopupHelper = field.get(popupMenu)

            // mPopup'ın türü MenuPopupHelper'dır. Bu sınıf içinde ikonları göstermeyi sağlayan metodu reflection ile çağırıyoruz.
            val setForceShowIcon = menuPopupHelper.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.javaPrimitiveType)
            setForceShowIcon.invoke(menuPopupHelper, true)

        } catch (e: Exception) {
            e.printStackTrace()
            // Reflection başarısız olursa (Android sürümü değiştiğinde olabilir)
            // Hata çıktısını log'lara yazdırır.
        }

    }

    private fun getClothesList(): List<ClothesRecyclerData> {
        return listOf(
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
            ClothesRecyclerData(R.drawable.shoe_small, R.string.shoe, R.string.shoe),
        )
    }

    // Show Pop-Up menu
    private fun showPopupMenu() {
        popupMenu.show()
    }

    // Menu click listener
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_t_shirt -> {binding.splitButtonTitle.setText(R.string.tshirt)}
            R.id.action_jacket -> {binding.splitButtonTitle.setText(R.string.jacket)}
            R.id.action_dress -> {binding.splitButtonTitle.setText(R.string.dress)}
            R.id.action_accessories -> {binding.splitButtonTitle.setText(R.string.accessories)}
            R.id.action_skirt -> {binding.splitButtonTitle.setText(R.string.skirt)}
            R.id.action_suit -> {binding.splitButtonTitle.setText(R.string.suit)}
            R.id.action_glasses -> {binding.splitButtonTitle.setText(R.string.glasses)}
            R.id.action_perfume -> {binding.splitButtonTitle.setText(R.string.perfume)}
            R.id.action_shirt -> {binding.splitButtonTitle.setText(R.string.shirt)}
            R.id.action_shoe -> {binding.splitButtonTitle.setText(R.string.shoe)}
            R.id.action_sweater -> {binding.splitButtonTitle.setText(R.string.sweater)}
            R.id.action_pant -> {binding.splitButtonTitle.setText(R.string.pant)}
            else -> return false
        }
        return true
    }

    private fun setAppbarNavigationIconBehavior() {
        onBackPressedDispatcher.onBackPressed()
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