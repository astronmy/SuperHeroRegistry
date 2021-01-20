package com.learning.kotlin.superheroregistry

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.learning.kotlin.superheroregistry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var heroImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        heroImage = binding.ivAvatar
        binding.ivAvatar.setOnClickListener {
            openCamera()
        }
        binding.btnSave.setOnClickListener {
            val heroName = binding.etSuperHeroName.text.toString()
            val alterEgo = binding.etSuperheroAlter.text.toString()
            val bio = binding.etSuperheroBio.text.toString()
            val power = binding.rbRaiting.rating

            val hero = Superhero(heroName,alterEgo,bio,power)
            openDetail(hero)
        }

    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, 1000)
    }

    private fun openDetail(hero:Superhero) {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra(SecondActivity.HERO_KEY, hero)
        intent.putExtra(SecondActivity.HERO_BITMAP, heroImage.drawable.toBitmap())
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 1000){
            val extras = data?.extras
            var heroBitmap = extras?.getParcelable<Bitmap>("data")
            heroImage.setImageBitmap(heroBitmap)
        }
    }
}