package com.learning.kotlin.superheroregistry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.kotlin.superheroregistry.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}