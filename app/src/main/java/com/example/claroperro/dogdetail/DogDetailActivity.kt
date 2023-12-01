package com.example.claroperro.dogdetail

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.claroperro.Dog
import com.example.claroperro.R
import com.example.claroperro.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {

    private val dogDetailViewModel: DogDetailViewModel by viewModels()

    companion object{
        const val DOG_KEY = "dog"
    }
    @SuppressLint("StringFormatInvalid")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dog = intent?.extras?.getParcelable(DOG_KEY, Dog::class.java)

        if(dog == null){
            Toast.makeText(this, "Dog not found", Toast.LENGTH_SHORT ).show()
            finish()
            return
        }

        dogDetailViewModel.downloadDogsImg(dog.imgId)

        dogDetailViewModel.dogImg.observe(this){dogImg->
            binding.intelligence.text = getString(R.string.intelligence, dog.intelligence)
            binding.dog = dog
            binding.dogImage.load(dogImg.url)
            binding.closeButton.setOnClickListener {
                finish()
            }
        }


    }
}