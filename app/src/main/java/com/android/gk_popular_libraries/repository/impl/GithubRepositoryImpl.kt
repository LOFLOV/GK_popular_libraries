package com.android.gk_popular_libraries.repository.impl

import com.android.gk_popular_libraries.model.GithubUser
import com.android.gk_popular_libraries.repository.interfaces.GithubRepository
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class GithubRepositoryImpl : GithubRepository {
    private val repositories = listOf(
        GithubUser("Art", 1),
        GithubUser("Bac", 2),
        GithubUser("Cov", 3),
        GithubUser("Dar", 4),
        GithubUser("Dar", 4),
        GithubUser("Dar", 4),
        GithubUser("Dar", 4),
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }.delay(3, TimeUnit.SECONDS)
    }

    override fun getUserById(id: Long): Single<GithubUser> {
        return Single.create {
            repositories.find { it.id == id }?.let { it1 -> it.onSuccess(it1) }
        }
    }
}