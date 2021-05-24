package com.ktmmoe.daggerhilttutorial.data.api

import com.ktmmoe.daggerhilttutorial.data.model.User
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by ktmmoe on 24, May, 2021
 **/
interface ApiService {

    @GET("users")
    suspend fun getUsers() : Response<List<User>>
}