package com.example.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.jokenpo.databinding.ActivityMain3Binding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

// A activity da Tela Jogador 1

class MainActivity3 : AppCompatActivity() {
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        val toolbar = binding.toolbar3
        setContentView(binding.root)
        setSupportActionBar(toolbar)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNav
        setupToolbar()
        setupDrawer()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation(){
        bottomNav.setOnItemSelectedListener {
                menuItem -> when(menuItem.itemId){
                R.id.playerOne_bottom_nav_bar ->{
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
                    true
                }
            R.id.result_bottom_nav_bar ->{
                val intent = Intent(this, MainActivity4::class.java)
                startActivity(intent)
                true
            }
            else -> false
                }
        }
    }

    private fun setupDrawer(){
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            drawer.closeDrawers()
            when(menuItem.itemId){
                R.id.playerOne ->{
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
                    true
                }
                R.id.result ->{
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupToolbar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_screen_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_reload->{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                true
            }
            else -> false
        }
    }
}