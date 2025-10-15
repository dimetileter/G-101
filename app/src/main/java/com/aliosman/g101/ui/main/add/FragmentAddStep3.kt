package com.aliosman.g101.ui.main.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.aliosman.g101.R
import com.aliosman.g101.databinding.FragmentAddStep3Binding
import kotlin.getValue

class FragmentAddStep3 : Fragment() {

    private var _binding: FragmentAddStep3Binding? = null
    private val binding get() = _binding!!

    private val viewModel: AddPageViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddStep3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpDoneButton()

        // İmage uri observer
        imageURIObserver()

    }

     // Setup done button
     private fun setUpDoneButton() {
         val button = binding.btnDone.txtButtonText
         button.apply {
             isEnabled = false
             setText(R.string.done)
         }

         button.setOnClickListener {
             //Todo: Kıyafeti kaydet
         }
     }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // İmage uri observer
    private fun imageURIObserver() {
        viewModel.selectedImageUri.observe(viewLifecycleOwner) { uri ->
            uri?.let {
                binding.imgProductImage.setImageURI(it)
            }
        }
    }

}