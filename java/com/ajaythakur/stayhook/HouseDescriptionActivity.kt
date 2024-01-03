package com.ajaythakur.stayhook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class HouseDescriptionActivity : AppCompatActivity() {

    private lateinit var backBtn: ImageView
    private lateinit var favtBtn:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_description)

        backBtn=findViewById(R.id.backBtn)
        favtBtn=findViewById(R.id.favtBtn)

        backBtn.setOnClickListener {
                finish()
        }

        favtBtn.setOnClickListener {
            if (1==1){
                favtBtn.setImageResource(R.drawable.red_heart)
            }
            else{
                favtBtn.setImageResource(R.drawable.hearts)
            }
        }

    }

    override fun onBackPressed() {
        finish()
    }
}