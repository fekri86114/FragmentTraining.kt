package com.app.fragments.ux.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.app.fragments.databinding.DialogMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainBottomSheet(private val mainDialogEvent: MainDialogEvent) : BottomSheetDialogFragment() {
    lateinit var binding: DialogMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DialogMainBinding.inflate(layoutInflater, null, false)


        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        binding.btnAccept.setOnClickListener {

            val name = binding.edtName.text.toString()
            val lastname = binding.edtLastName.text.toString()

            if (name.isNotEmpty() && lastname.isNotEmpty()) {

                // send data to activity
                dismiss()

                mainDialogEvent.sendTextData(" $name $lastname ")


            } else {
                Toast.makeText(context, "Please, enter your name and last name", Toast.LENGTH_LONG)
                    .show()
            }

        }

        return binding.root

    }

    interface MainDialogEvent {

        fun sendTextData(data: String)

    }

}