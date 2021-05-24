package com.ktmmoe.daggerhilttutorial.data.model

import com.squareup.moshi.Json

/**
 * Created by ktmmoe on 24, May, 2021
 **/
data class User(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "email") val email: String,
    @Json(name = "avatar") val avatar: String
)