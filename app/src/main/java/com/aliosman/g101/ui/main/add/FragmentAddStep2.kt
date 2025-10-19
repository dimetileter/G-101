package com.aliosman.g101.ui.main.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.aliosman.g101.databinding.FragmentAddStep2Binding
import kotlin.getValue

class FragmentAddStep2 : Fragment() {

    private var _binding: FragmentAddStep2Binding? = null
    private val binding get() = _binding!!

    private val viewModel: AddPageViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddStep2Binding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = binding.shapeableImageView
        viewModel.selectedImageUri.observe(viewLifecycleOwner) { uri ->
            uri?.let {
                imageView.setImageURI(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}