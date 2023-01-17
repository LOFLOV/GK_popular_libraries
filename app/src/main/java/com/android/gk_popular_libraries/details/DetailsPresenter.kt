package com.android.gk_popular_libraries.details

import android.util.Log
import com.android.gk_popular_libraries.navigation.UsersScreen
import com.android.gk_popular_libraries.repository.interfaces.GithubRepository
import com.android.gk_popular_libraries.utils.subscribeByDefault
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class DetailsPresenter(
    private val repository: GithubRepository,
    private val router: Router,
) : MvpPresenter<DetailsView>() {

    fun loadUser(id: Long) {
        repository.getUserById(id)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.show(it)
                }, {
                    Log.e("@@@", it.message.toString())
                }
            )
    }

    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }
}