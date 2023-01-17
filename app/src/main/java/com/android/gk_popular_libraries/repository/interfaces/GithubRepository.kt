package com.android.gk_popular_libraries.repository.interfaces

import com.android.gk_popular_libraries.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
    fun getUserById(id: Long): GithubUser?
}