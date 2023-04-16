package com.example.motivationcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motivationcards.adapter.ItemAdapter
import com.example.motivationcards.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        val check : TextView = findViewById(R.id.textView)
//        check.text = Datasource().loadAffirmations().size.toString()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().loadAffirmations()
        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        recycleView.adapter = ItemAdapter(this, myDataset)
    }
}