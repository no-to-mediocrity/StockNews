package com.example.stocknews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.stocknews.adapter.ItemAdapter
import com.example.stocknews.data.RSSParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val url = URL("https://finance.yahoo.com/rss/topstories")
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val connection = url.openConnection() as HttpURLConnection
                connection.connect()
                val inputStream = connection.inputStream
                val myDataset = RSSParser().get(inputStream)
                withContext(Dispatchers.Main) {
                    val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
                    if (recyclerView != null) {
                        recyclerView.adapter = ItemAdapter(myDataset)
                    }
                }
            }
        }
    }
}
