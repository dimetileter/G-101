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
        val splitButtonMenu = binding.btnPopMenu
        splitButtonMenu.setOnClickListener {
            splitButtonMenu.isSelected = true
            showPopupMenu()
        }

        // Pop menu initialization and listeners
        popupMenu = PopupMenu(this, binding.btnPopMenu)
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.setOnDismissListener {
            // If menu disabled then change button's icon state situation
            splitButtonMenu.isSelected = false
        }

        //popup menu
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.split_button_categories_menu, popupMenu.menu)
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
        val title = binding.txtCategoryText
        val icon = binding.icCategoryIcon
        when(item?.itemId) {
            R.id.action_t_shirt -> {
                title.setText(R.string.tshirt)
                icon.setImageResource(R.drawable.ic_tshirt)
            }

            R.id.action_jacket -> {
                title.setText(R.string.jacket)
                icon.setImageResource(R.drawable.ic_jacket)}

            R.id.action_dress -> {
                title.setText(R.string.dress)
                icon.setImageResource(R.drawable.ic_dress)
            }

            R.id.action_accessories -> {
                    title.setText(R.string.accessories)
                icon.setImageResource(R.drawable.ic_accessories)
                }

            R.id.action_skirt -> {
                title.setText(R.string.skirt)
                icon.setImageResource(R.drawable.ic_skirt)
            }

            R.id.action_suit -> {
                title.setText(R.string.suit)
                icon.setImageResource(R.drawable.ic_suit)
            }

            R.id.action_glasses -> {
                title.setText(R.string.glasses)
                icon.setImageResource(R.drawable.ic_eyeglasses)
            }

            R.id.action_perfume -> {
                title.setText(R.string.perfume)
                icon.setImageResource(R.drawable.ic_perfume)
            }

            R.id.action_shirt -> {
                title.setText(R.string.shirt)
                icon.setImageResource(R.drawable.ic_shirt)
            }

            R.id.action_shoe -> {
                title.setText(R.string.shoe)
                icon.setImageResource(R.drawable.ic_shoe)
            }

            R.id.action_sweater -> {
                title.setText(R.string.sweater)
                icon.setImageResource(R.drawable.ic_sweater)
            }

            R.id.action_pant -> {
                title.setText(R.string.pant)
                icon.setImageResource(R.drawable.ic_pant)
            }

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