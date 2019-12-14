package com.aram.padatabindingnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.aram.padatabindingnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navController = this.findNavController(R.id.myNavHostFragment)

        drawerLayout = binding.drawerLayout

        // up back button                                                    NAVDRAWER BUTTON
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        // navigation drawer
        NavigationUI.setupWithNavController(binding.navView,navController)


// Hide the keyboard.
//        val imm = ContextCompat.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(it.windowToken, 0)
//


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawerLayout)
    }
}
