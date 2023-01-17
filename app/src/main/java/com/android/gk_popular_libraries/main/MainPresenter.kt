package com.android.gk_popular_libraries.main

import com.android.gk_popular_libraries.navigation.UsersScreen
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.navigateTo(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }

}