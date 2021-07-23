package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPerson: RecyclerView
    private var list: ArrayList<Person> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPerson = findViewById(R.id.rv_Github)
        rvPerson.setHasFixedSize(true)

        list.addAll(PersonData.listData)
        showRecycler()

    }
    private fun showRecycler() {
        rvPerson.layoutManager = LinearLayoutManager(this)
        val personAdapter = PersonAdapter(list)
        rvPerson.adapter = personAdapter
    }
}