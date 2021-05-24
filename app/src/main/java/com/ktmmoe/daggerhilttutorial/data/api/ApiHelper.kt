package com.ktmmoe.daggerhilttutorial.data.api

import com.ktmmoe.daggerhilttutorial.data.model.User
import retrofit2.Response

/**
 * Created by ktmmoe on 24, May, 2021
 **/
interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}