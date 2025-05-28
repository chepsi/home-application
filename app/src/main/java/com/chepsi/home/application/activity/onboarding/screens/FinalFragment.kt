package com.chepsi.home.application.activity.onboarding.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.chepsi.home.application.R
import com.chepsi.home.application.activity.onboarding.model.OnboardingEvents

class FinalFragment(val onEvent: (OnboardingEvents) -> Unit) : Fragment(R.layout.fragment_final) {

    private val btnContinue by lazy {
        requireView().findViewById<Button>(R.id.btn_final_continue)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews(){
        btnContinue.setOnClickListener {
            onEvent(OnboardingEvents.OnFinishEvent)
        }
    }

}