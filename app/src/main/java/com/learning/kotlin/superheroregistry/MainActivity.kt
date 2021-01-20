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

            val hero = Superhero(heroName,alterEgo,bio,power)
            openDetail(hero)
        }

    }

    private fun openDetail(hero:Superhero) {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra(SecondActivity.HERO_KEY, hero)
        startActivity(intent)
    }
}