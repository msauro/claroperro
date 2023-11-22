package com.example.claroperro.doglist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.claroperro.api.ApiResponseStatus
import com.example.claroperro.databinding.ActivityDogListBinding
import com.example.claroperro.dogdetail.DogDetailActivity
import com.example.claroperro.dogdetail.DogDetailActivity.Companion.DOG_KEY

class DogListActivity : AppCompatActivity() {

    private val dogListViewModel: DogListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loadingWheel = binding.loadingWheel

        val recycler = binding.dogRecycler
        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = DogAdapter()
        adapter.setOnItemClickListener {
            //Pasar el dog a DogDetailActivity
            val intent = Intent(this, DogDetailActivity::class.java)
            intent.putExtra(DOG_KEY, it)
            startActivity(intent)
        }
        recycler.adapter = adapter

        dogListViewModel.dogList.observe(this){
            dogList ->
            adapter.submitList(dogList)

        }

        dogListViewModel.status.observe(this){
            status->
            when(status){
                is ApiResponseStatus.Error -> {
                    loadingWheel.visibility = View.GONE
                    Toast.makeText(this, status.message,Toast.LENGTH_SHORT).show()
                }
                is ApiResponseStatus.Loading -> loadingWheel.visibility = View.VISIBLE
                is ApiResponseStatus.Succes -> loadingWheel.visibility = View.GONE
            }
        }
    }


}