package com.chepsi.home.application.activity.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.chepsi.home.application.R
import com.chepsi.home.application.activity.isAppDefaultHome
import com.chepsi.home.application.activity.onboarding.OnboardingActivity

class HomeActivity : AppCompatActivity() {

    private val txtHomeInformation by lazy {
        findViewById<TextView>(R.id.txt_home)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onResume() {
        super.onResume()
        if (!isAppDefaultHome(this)) {
            startActivity(Intent(this, OnboardingActivity::class.java))
        } else {
            txtHomeInformation.visibility = View.VISIBLE
        }
    }

}