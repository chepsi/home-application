package com.chepsi.home.application.activity.onboarding.model

sealed interface OnboardingEvents {
    data object OnSetDefaultHomeEvent: OnboardingEvents
    data object OnNextScreenEvent: OnboardingEvents

    data object OnFinishEvent: OnboardingEvents
}