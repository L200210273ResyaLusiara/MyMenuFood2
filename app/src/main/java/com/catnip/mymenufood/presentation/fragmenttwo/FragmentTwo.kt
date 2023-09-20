package com.catnip.mymenufood.presentation.fragmenttwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import coil.load
import com.catnip.mymenufood.R
import com.catnip.mymenufood.databinding.FragmentTwoBinding
import com.catnip.mymenufood.model.Menu

class FragmentTwo : Fragment() {

    companion object{
        const val ARGS_PERSON = "ARGS_PERSON"
    }

    private lateinit var binding : FragmentTwoBinding

    private val person: Menu? by lazy {
        val args = arguments
        if (args != null) {
            FragmentTwoArgs.fromBundle(args).person
        } else {
            null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        showProfileData()
    }

    private fun showProfileData() {
        if(person != null){
            binding.llProfile.isVisible = true
            binding.ivProfileImg.load(person?.profilePictUrl)
            binding.tvName.text = person?.food
            binding.tvJob.text = person?.country
            binding.tvProfileDesc.text = person?.foodDesc
        }else {
            binding.llProfile.isVisible = false
            Toast.makeText(requireContext(), "Profile is Null", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setClickListener() {
        binding.btnNavigate.setOnClickListener {
            navigateToFragmentThree()
        }
    }

    private fun navigateToFragmentThree() {
        findNavController().navigate(R.id.action_fragmentTwo_to_fragmentThree)
    }


}