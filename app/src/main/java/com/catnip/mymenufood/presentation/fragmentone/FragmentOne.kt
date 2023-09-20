package com.catnip.mymenufood.presentation.fragmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.catnip.mymenufood.databinding.FragmentOneBinding
import com.catnip.mymenufood.model.Menu

class FragmentOne : Fragment() {

    private lateinit var binding : FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnNavigate.setOnClickListener {
            navigateToFragmentTwo()
        }
        binding.btnSendDataNavigate.setOnClickListener {
            navigateToFragmentTwo(getMenu())
        }
    }

    private fun getMenu(): Menu? {
        return Menu(
            food = "Pizza",
            country = "Italia",
            foodDesc ="Pizza adalah roti berbentuk bulat pipih dengan diameter 30 cm yang dipanggang dalam oven dan biasanya disiram saus tomat serta keju dan dengan makanan tambahan lainnya (topping) yang sesuai selera penikmatnya.",
            profilePictUrl = "https://www.google.com/imgres?imgurl=http%3A%2F%2Fwww.tokomesin.com%2Fwp-content%2Fuploads%2F2015%2F09%2Fpizza-ala-hut2-tokomesin.jpg&tbnid=aCbe0xyhlYk-3M&vet=12ahUKEwiQhab1_LiBAxWfkGMGHbtgDrkQMygPegQIARBt..i&imgrefurl=https%3A%2F%2Fwww.tokomesin.com%2Fpeluang-usaha-pizza-ala-hut-dan-analisa-usahanya.html&docid=6drYFoVcElCnwM&w=800&h=601&q=deskripsi%20pizza&client=firefox-b-d&ved=2ahUKEwiQhab1_LiBAxWfkGMGHbtgDrkQMygPegQIARBt",
        )
    }

    private fun navigateToFragmentTwo(person: Menu? = null) {

        val action = FragmentOneDirections.actionFragmentOneToFragmentTwo(person)
        findNavController().navigate(action)
    }

}