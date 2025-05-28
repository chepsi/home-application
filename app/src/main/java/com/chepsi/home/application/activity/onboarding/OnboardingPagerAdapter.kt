package com.chepsi.home.application.activity.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chepsi.home.application.activity.onboarding.screens.FinalFragment
import com.chepsi.home.application.activity.onboarding.screens.GuidanceFragment
import com.chepsi.home.application.activity.onboarding.screens.WelcomeFragment

class OnboardingPagerAdapter(
    fragmentActivity: FragmentActivity,
    val onContinueClicked: () -> Unit
) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WelcomeFragment(onContinueClicked)
            1 -> GuidanceFragment()
            2 -> FinalFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

}