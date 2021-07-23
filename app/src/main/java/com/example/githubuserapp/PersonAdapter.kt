package com.example.githubuserapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PersonAdapter(private val listPerson : ArrayList<Person>) :RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername : TextView = itemView.findViewById(R.id.tv_item_username)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = listPerson[position]

        Glide.with(holder.itemView.context)
            .load(person.image)
            .apply(RequestOptions())
            .into(holder.imgPhoto)
        holder.tvName.text = person.name
        holder.tvUsername.text = person.username


        holder.itemView.setOnClickListener{
            val  intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_PERSON,person)
            holder.itemView.context.startActivity(intent)
        }
    }
}