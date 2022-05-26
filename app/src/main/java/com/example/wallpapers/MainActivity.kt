package com.example.wallpapers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.AdapterView
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.wallpapers.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationBarView.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ->1 bottomNavigationView ni boshqarish
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
        //<-1
        buttonNavigateActivity() // navigationView ni tugma orqali boshqarish

//        binding.bottomNavigationView.setOnItemSelectedListener{
//            when(it.itemId){
//                R.id.homeMenu -> Log.d(TAG, "onCreate: menuItemSelected")
//                R.id.popularMenu -> Log.d(TAG, "onCreate: popularItemSelected")
//            }
//            return@setOnItemSelectedListener true
//        }
    }

    fun buttonNavigateActivity(){
        binding.buttonNavImage.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(binding.navView)) {
                binding.drawerLayout.closeDrawer(binding.navView)
            } else {
                binding.drawerLayout.openDrawer(binding.navView)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.container).navigateUp()
    }
}