package com.android.gk_popular_libraries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class GithubUser(
    val login: String,
    val id: Long,
) : Parcelable
