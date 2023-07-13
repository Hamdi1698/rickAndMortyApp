package com.rickandmortyapp

import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.rickandmortyapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView)as NavHostFragment
        navController=navHostFragment.navController

        binding.toolbar.imageButtonn.setOnClickListener{
            val popup  =PopupMenu(this@MainActivity,binding.toolbar.imageButtonn)
            popup.menuInflater.inflate(R.menu.toolbar_menu,popup.menu)
            popup.show()
            }


    }
}
