package com.chepsi.home.application.activity.onboarding.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.chepsi.home.application.R
import com.chepsi.home.application.activity.onboarding.model.OnboardingEvents

class GuidanceFragment(val onEvent: (OnboardingEvents) -> Unit) : Fragment(R.layout.fragment_guidance) {

    private val btnOnContinue by lazy {
        requireView().findViewById<Button>(R.id.btn_guidance_continue)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        btnOnContinue.setOnClickListener {
            onEvent(OnboardingEvents.OnSetDefaultHomeEvent)
        }
    }

}