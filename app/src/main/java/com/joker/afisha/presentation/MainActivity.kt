package com.joker.afisha.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.joker.afisha.R

class MainActivity : AppCompatActivity() {
    val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.main_nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottom_nav)

        // Установите слушатель для смены элементов меню
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.afisha -> {
                    navController.navigate(R.id.afisha)
                }

                R.id.tickets -> {
                    navController.navigate(R.id.tickets)
                }

                R.id.profile -> {
                    navController.navigate(R.id.profile)
                }
                // Добавьте другие элементы меню и соответствующие начальные фрагменты, если необходимо
            }
            return@setOnNavigationItemSelectedListener true
        }


    }

    override fun onSupportNavigateUp(): Boolean {

        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}