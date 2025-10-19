package com.aliosman.g101.ui.main.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.aliosman.g101.R


class FragmentAddStep1 : Fragment() {

    private val viewModel: AddPageViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_step1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.shapeableImageView1)
        viewModel.selectedImageUri.observe(viewLifecycleOwner) { uri ->
            uri?.let { it ->
                imageView.setImageURI(it)
            }
        }
    }


    override fun onResume() {
        super.onResume()
    }
}