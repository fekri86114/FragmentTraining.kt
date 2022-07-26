package com.app.fragments.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.fragments.databinding.SecondFragmentBinding
import com.app.fragments.ux.Person

const val NAME_DATA_KEY= "USER_NAME"
const val SEND_PARCELABLE_KEY = "SEND_DATA_PARCELABLE"

class FragmentSecond: Fragment() {
    lateinit var binding: SecondFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= SecondFragmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        if (bundle != null) {

//            val myText = bundle.getString(NAME_DATA_KEY)
//            binding.txtShowName.text = myText

            val person = bundle.getParcelable<Person>(SEND_PARCELABLE_KEY)!!

            binding.txtShowName.text ="${person.name} - ${person.lastname} - ${person.age} - ${person.gender}"

        } else {
            binding.txtShowName.text = "Not sent any information"
        }

    }

}