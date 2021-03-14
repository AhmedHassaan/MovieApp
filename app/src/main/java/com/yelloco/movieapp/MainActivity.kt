package com.yelloco.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yelloco.kotlin_test_app.app_utils.GuiManager
import com.yelloco.movieapp.databinding.ActivityMainBinding
import com.yelloco.movieapp.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        GuiManager.setFragmentManagerObject(supportFragmentManager)
        GuiManager.setContainerResource(R.id.activity_main_frame_layout)
        GuiManager.setCurrentFragment(MainFragment())
    }
}