package com.android.gk_popular_libraries.repository.interfaces

import com.android.gk_popular_libraries.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
    fun getUserById(id: Long): Single<GithubUser>
}