package com.app.fragments.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.fragments.R
import com.app.fragments.databinding.FirstFragmentBinding

class FragmentFirst: Fragment() {
    lateinit var binding: FirstFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FirstFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToSecondFragment.setOnClickListener {

            // replace fragment -> fragment second ;-)

            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_main_container, FragmentSecond())
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }

}