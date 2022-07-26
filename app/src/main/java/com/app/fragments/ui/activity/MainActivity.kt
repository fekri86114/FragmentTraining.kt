package com.app.fragments.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.fragments.databinding.ActivityMainBinding
import com.app.fragments.ux.dialog.MainBottomSheet

class MainActivity : AppCompatActivity(), MainBottomSheet.MainDialogEvent {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenDialogFragment.setOnClickListener {

            val mainBottomSheet = MainBottomSheet(this)

            mainBottomSheet.show( supportFragmentManager, null)

        }

    }

    override fun sendTextData(data: String) {
        binding.txtMain.text = data
    }

}