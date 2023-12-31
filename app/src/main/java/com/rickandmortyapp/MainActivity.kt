package com.rickandmortyapp

import android.os.Bundle
import android.view.Menu
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.rickandmortyapp.databinding.ActivityMainBinding
import com.rickandmortyapp.view.FilterFragment


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






    }
}
