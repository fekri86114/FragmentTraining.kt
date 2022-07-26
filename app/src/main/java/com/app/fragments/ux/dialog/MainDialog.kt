package com.app.fragments.ux.dialog

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.app.fragments.databinding.DialogMainBinding

class MainDialog(private val mainDialogEvent: MainDialogEvent) : DialogFragment() {
    lateinit var binding: DialogMainBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

//        val view = LayoutInflater.from(context).inflate(R.layout.dialog_main, null, false)


        val dialog = AlertDialog.Builder(requireContext())

        binding = DialogMainBinding.inflate(layoutInflater, null, false)

        dialog.setView(binding.root)

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

        return dialog.create()
    }

    interface MainDialogEvent {

        fun sendTextData(data: String)

    }

}