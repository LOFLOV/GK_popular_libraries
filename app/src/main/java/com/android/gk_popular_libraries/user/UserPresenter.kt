package com.android.gk_popular_libraries.user

import android.util.Log
import com.android.gk_popular_libraries.navigation.DetailsScreen
import com.android.gk_popular_libraries.repository.interfaces.GithubRepository
import com.android.gk_popular_libraries.utils.subscribeByDefault
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router,
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        repository.getUsers()
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideLoading()
                }, {
                    Log.e("AAA", it.message.toString())
                }
            )
    }

    fun onItemClicked(id: Long) {
        router.navigateTo(DetailsScreen(id))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}