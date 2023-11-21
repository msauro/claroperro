package com.example.claroperro.dogdetail

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.claroperro.Dog
import com.example.claroperro.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {
    companion object{
        const val DOG_KEY = "dog"
    }
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

       // binding.intelligence.text = getString(R.string.intelligence, dog.intelligence)
        binding.dog = dog
    }
}