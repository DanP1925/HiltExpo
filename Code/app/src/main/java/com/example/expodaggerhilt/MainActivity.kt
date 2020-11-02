package com.example.expodaggerhilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var contactFormatter: ContactFormatter

    lateinit var contactAdapter: ContactAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)

        val contactData =
            mutableListOf(
                "Juanito 2934900", "Pablito 12931342", "Maria 128389123"
            )
        viewAdapter = ContactAdapter(
            contactData.map {
                contactFormatter.giveFormat(it)
            } as MutableList<String>
        );

        recyclerView = findViewById<RecyclerView>(R.id.contact_recycler).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}