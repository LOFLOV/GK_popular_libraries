package com.android.gk_popular_libraries.repository.impl

import com.android.gk_popular_libraries.model.GithubUser
import com.android.gk_popular_libraries.repository.interfaces.GithubRepository

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

    override fun getUsers(): List<GithubUser> {
        return repositories
    }

    override fun getUserById(id: Long): GithubUser? {
        return repositories.find { it.id == id }
    }
}