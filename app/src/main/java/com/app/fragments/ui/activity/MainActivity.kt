package com.app.fragments.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.translationMatrix
import androidx.fragment.app.Fragment
import com.app.fragments.R
import com.app.fragments.databinding.ActivityMainBinding
import com.app.fragments.ui.fragment.FragmentFirst
import com.app.fragments.ui.fragment.FragmentSecond
import com.app.fragments.ui.fragment.FragmentThird

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_main_container, FragmentFirst())
        transaction.addToBackStack(null)
        transaction.commit()

    }

}