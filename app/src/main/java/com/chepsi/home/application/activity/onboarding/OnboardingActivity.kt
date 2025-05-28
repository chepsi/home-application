package com.chepsi.home.application.activity.onboarding

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.chepsi.home.application.R
import com.chepsi.home.application.activity.home.HomeActivity
import com.chepsi.home.application.activity.isAppDefaultHome
import com.chepsi.home.application.activity.onboarding.model.OnboardingEvents

class OnboardingActivity : AppCompatActivity() {

    private val onboardingPager by lazy {
        findViewById<ViewPager2>(R.id.onboarding_pager)
    }

    private val onboardingAdapter by lazy {
        OnboardingPagerAdapter(this, onEvent = {
            when (it) {
                is OnboardingEvents.OnNextScreenEvent -> onNextScreen()
                is OnboardingEvents.OnSetDefaultHomeEvent -> {
                    onSetDefaultHome()
                }

                is OnboardingEvents.OnFinishEvent -> onFinish()
            }
        })
    }

    private fun onSetDefaultHome() {
        if (!isAppDefaultHome(this)) {
            openDefaultHomeAppSettings()
        } else {
            onNextScreen()
        }
    }

    private fun onNextScreen() {
        onboardingPager.currentItem = onboardingPager.currentItem + 1
    }

    private fun onFinish() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
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

    private fun setupViews() {
        onboardingPager.adapter = onboardingAdapter
    }

    private fun openDefaultHomeAppSettings() {
        val intent = Intent(Settings.ACTION_HOME_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Could not open default home app settings.", Toast.LENGTH_SHORT)
                .show()
            e.printStackTrace()
        }
    }
}