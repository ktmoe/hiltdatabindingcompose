package com.ktmmoe.daggerhilttutorial.data.api

import com.ktmmoe.daggerhilttutorial.data.model.User
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by ktmmoe on 24, May, 2021
 **/
class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper{

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()
}