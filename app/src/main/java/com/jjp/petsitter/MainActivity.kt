package com.jjp.petsitter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jjp.petsitter.ui.AnimalsLoader
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val animalsLoader = AnimalsLoader()

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        showError()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        loadAnimals()
    }

    private fun loadAnimals() = runBlocking {
       GlobalScope.launch(exceptionHandler) {
           animalsLoader.loadAnimals()
        }
    }

    private fun showError() {
        Toast.makeText(baseContext, "Error", Toast.LENGTH_LONG).show()
    }
}
