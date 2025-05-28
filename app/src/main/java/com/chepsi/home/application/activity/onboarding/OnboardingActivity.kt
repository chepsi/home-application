package com.chepsi.home.application.activity.onboarding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.chepsi.home.application.R

class OnboardingActivity : AppCompatActivity() {

    private val onboardingPager by lazy {
        findViewById<ViewPager2>(R.id.onboarding_pager)
    }

    private val onboardingAdapter by lazy {
        OnboardingPagerAdapter(this, onContinueClicked = {
            onboardingPager.currentItem = onboardingPager.currentItem + 1
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.onboarding)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupViews()
    }

    private fun setupViews(){
        onboardingPager.adapter = onboardingAdapter
    }
}