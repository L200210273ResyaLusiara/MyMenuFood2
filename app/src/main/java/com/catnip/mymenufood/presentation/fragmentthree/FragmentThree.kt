package com.catnip.mymenufood.presentation.fragmentthree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catnip.mymenufood.databinding.FragmentThreeBinding
import com.catnip.mymenufood.presentation.otheractivity.OtherActivity

class FragmentThree : Fragment() {
    private lateinit var binding: FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnNavigateOther.setOnClickListener {
            navigateToOtherActivity()
        }
    }

    private fun navigateToOtherActivity() {
        OtherActivity.startActivity(requireContext(),"Resya",21)
    }
}