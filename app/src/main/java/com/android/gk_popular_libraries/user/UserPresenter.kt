package com.android.gk_popular_libraries.user

import com.android.gk_popular_libraries.navigation.DetailsScreen
import com.android.gk_popular_libraries.repository.interfaces.GithubRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router,
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onItemClicked(id: Long) {
        router.navigateTo(DetailsScreen(id))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}