package com.android.gk_popular_libraries.details

import com.android.gk_popular_libraries.navigation.UsersScreen
import com.android.gk_popular_libraries.repository.interfaces.GithubRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class DetailsPresenter(
    private val repository: GithubRepository,
    private val router: Router,
) : MvpPresenter<DetailsView>() {

    fun loadUser(id: Long) {
        val user = repository.getUserById(id)
        if (user != null) {
            viewState.show(user)
        }
    }

    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }
}