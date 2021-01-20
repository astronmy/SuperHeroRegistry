package com.learning.kotlin.superheroregistry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.kotlin.superheroregistry.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    companion object{
        const val HERO_NAME = "heroName"
        const val HERO_ALTER = "alterEgo"
        const val HERO_BIO = "bio"
        const val HERO_POWER = "power"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras!!
        loadDetail(bundle)
    }

    private fun loadDetail(data:Bundle) {
        binding.heroName.text = data.getString(HERO_NAME) ?: ""
        binding.alterHeo.text = data.getString(HERO_ALTER) ?: ""
        binding.shortBio.text = data.getString(HERO_BIO) ?: ""
        binding.powerBar.rating = (data.getFloat(HERO_POWER))

    }

}