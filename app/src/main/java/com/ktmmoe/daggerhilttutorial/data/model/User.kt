package com.ktmmoe.daggerhilttutorial.data.model

import com.squareup.moshi.Json

/**
 * Created by ktmmoe on 24, May, 2021
 **/
data class User(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "name") val name: String = "default name",
    @Json(name = "email") val email: String = "default@mail",
    @Json(name = "avatar") val avatar: String = "default avatar"
)