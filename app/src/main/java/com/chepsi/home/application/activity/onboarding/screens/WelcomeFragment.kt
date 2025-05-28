package com.chepsi.home.application.activity.onboarding.screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.chepsi.home.application.R
import com.chepsi.home.application.activity.onboarding.model.OnboardingEvents
import com.chepsi.home.application.activity.onboarding.model.OnboardingEvents.OnNextScreenEvent

class WelcomeFragment(val onEvent: (OnboardingEvents) -> Unit) : Fragment(R.layout.fragment_welcome) {
    private val btnContinue by lazy {
        requireView().findViewById<TextView>(R.id.btn_welcome_continue)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        btnContinue.setOnClickListener {
            onEvent(OnNextScreenEvent)
        }
    }
}