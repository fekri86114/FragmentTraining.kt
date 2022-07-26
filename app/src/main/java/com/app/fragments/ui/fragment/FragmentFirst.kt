package com.app.fragments.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.fragments.R
import com.app.fragments.databinding.FirstFragmentBinding
import com.app.fragments.ux.Person

class FragmentFirst: Fragment() {
    lateinit var binding: FirstFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FirstFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToSecondFragment.setOnClickListener {

            val name = binding.edtName.text.toString()
            val lastname = binding.edtLastName.text.toString()
            val age = binding.edtAge.text.toString()
            val gender = true

            if (name.isNotEmpty() && lastname.isNotEmpty()) {

                val data = Person(name, lastname, age, gender)

                val bundle = Bundle()
                bundle.putParcelable( SEND_PARCELABLE_KEY , data )

                val fragment = FragmentSecond()
                fragment.arguments = bundle

                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_main_container, fragment)
                transaction.addToBackStack(null)
                transaction.commit()

            }else {
                Toast.makeText(context, "Please, enter your name and last name", Toast.LENGTH_LONG).show()
            }

        }

    }

}