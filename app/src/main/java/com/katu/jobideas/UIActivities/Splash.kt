package com.katu.jobideas.UIActivities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.katu.jobideas.MainActivity
import com.katu.jobideas.R

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(this::goMain, 3000)
    }

    fun goMain(){
        startActivity(Intent(this,MainActivity::class.java))
    }
}
