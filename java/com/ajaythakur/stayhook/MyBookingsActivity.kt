package com.ajaythakur.stayhook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.settings.MyBookingAdapter

class MyBookingsActivity : AppCompatActivity() {
    private lateinit var backBtn: TextView
    private lateinit var bookingsRV: RecyclerView
    private val list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_bookings)

        backBtn = findViewById(R.id.text1)
        bookingsRV = findViewById(R.id.bookingsRV)

        // Call the function to populate the list
        getBookingList()


     val myBookingAdapter = MyBookingAdapter(list,this)  // Removed the 'selected' parameter
        bookingsRV.layoutManager = LinearLayoutManager(this)
        bookingsRV.adapter = myBookingAdapter

        backBtn.setOnClickListener {
            finish()
        }
    }

    // Function to populate the list
    private fun getBookingList() {
        list.add("2 Rooms Available")
        list.add("1 Room Available")
        list.add("Full House Available")
        list.add("2 Rooms Available")
        list.add("1 Room Sharing Available")
        list.add("1 Room Available")
    }
}
