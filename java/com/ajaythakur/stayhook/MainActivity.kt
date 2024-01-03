package com.ajaythakur.stayhook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {
    private lateinit var lottieView:LottieAnimationView
    private lateinit var introHeading: TextView
    private lateinit var introCmt : TextView
    private lateinit var getStartBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lottieView= findViewById(R.id.lottieView)
        introHeading=findViewById(R.id.intro_heading)
        introCmt=findViewById(R.id.intro_cmt)
        getStartBtn=findViewById(R.id.getStartBtn)

        var i: Long = 4

        while (i < 1000) {
            val currentDelay = i  // Capture the current value of i in a local variable

            android.os.Handler(Looper.getMainLooper()).postDelayed({
                lottieView.setAnimation(R.raw.living_hall_lottie)
                lottieView.playAnimation()
                introHeading.text = "Forget Your Stress"
            }, currentDelay * 1000)

            i += 5
            // Increment i by 5 after the first delayed task

            android.os.Handler(Looper.getMainLooper()).postDelayed({
                lottieView.setAnimation(R.raw.coliving_lottie)
                lottieView.playAnimation()
                introHeading.text = "Find Partner to Stay with"
            }, (currentDelay + 5) * 1000)

            i += 6
            // Increment i by 6 after the second delayed task

            android.os.Handler(Looper.getMainLooper()).postDelayed({
                lottieView.setAnimation(R.raw.search_lottie)
                lottieView.playAnimation()
                introHeading.text = "Find Home that Suits You"
            }, (currentDelay + 11) * 1000)

            i += 6
            // Increment i by 6 after the third delayed task
        }

        getStartBtn.setOnClickListener {
            val intent = Intent(this@MainActivity,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}