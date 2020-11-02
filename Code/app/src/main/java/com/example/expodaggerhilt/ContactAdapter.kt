package com.example.expodaggerhilt

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contactData: MutableList<String>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(val contactView: TextView) : RecyclerView.ViewHolder(contactView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_contact, parent, false) as TextView
        return ContactViewHolder(textView)
    }

    override fun getItemCount() = contactData.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.contactView.text = contactData[position]
    }

}
