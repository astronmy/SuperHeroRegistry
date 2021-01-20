package com.learning.kotlin.superheroregistry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.kotlin.superheroregistry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val heroName = binding.etSuperHeroName.text.toString()
            val alterEgo = binding.etSuperheroAlter.text.toString()
            val bio = binding.etSuperheroBio.text.toString()
            val power = binding.rbRaiting.rating
            openDetail(heroName,alterEgo,bio, power)
        }

    }

    private fun openDetail(heroName:String, alterEgo:String, bio:String, power:Float) {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("heroName", heroName)
        intent.putExtra("alterEgo", alterEgo)
        intent.putExtra("bio", bio)
        intent.putExtra("power", power)
        startActivity(intent)
    }
}