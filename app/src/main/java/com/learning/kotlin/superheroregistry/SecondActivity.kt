package com.learning.kotlin.superheroregistry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.kotlin.superheroregistry.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    companion object{
        const val HERO_KEY = "hero"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras!!
        loadDetail(bundle)
    }

    private fun loadDetail(data:Bundle) {
        val hero = data.getParcelable<Superhero>(HERO_KEY)!!
        binding.hero = hero
    }

}