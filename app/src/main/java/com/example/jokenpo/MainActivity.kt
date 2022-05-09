package com.example.jokenpo
//A activity da Tela Inicial
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        
        val activity2Intent = Intent(this, MainActivity2::class.java)

        binding.startActivityButton.setOnClickListener {
                startActivity(activity2Intent)
        }
    }
}