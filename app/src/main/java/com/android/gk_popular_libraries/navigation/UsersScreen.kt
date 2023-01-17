package com.android.gk_popular_libraries.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.android.gk_popular_libraries.details.DetailsFragment
import com.android.gk_popular_libraries.user.UserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen


object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

data class DetailsScreen(private val id: Long) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return DetailsFragment.getInstance(id)
    }
}