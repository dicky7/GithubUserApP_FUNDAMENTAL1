package com.example.githubuserapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.githubuserapp.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_PERSON = "person"
    }
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        binding.detailAvatar.setImageResource(person.image)
        binding.detailName.text = person.name
        binding.detailUsername.text = person.username
        binding.detailCompany.text = person.company
        binding.detailFollowers.text = person.follower.toString()
        binding.detailFollowing.text = person.following.toString()
        binding.detailLocation.text = person.location
        binding.detailRepotories.text = person.repository.toString()

        val share:View = findViewById(R.id.share)
        share.setOnClickListener{view->
            Snackbar.make(view,"${person.name} Berhasil di share",Snackbar.LENGTH_LONG)
                .setAction("Action",null)
                .show()
        }

    }
}