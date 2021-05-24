package com.ktmmoe.daggerhilttutorial.data.repository

import com.ktmmoe.daggerhilttutorial.data.api.ApiHelper
import javax.inject.Inject

/**
 * Created by ktmmoe on 24, May, 2021
 **/
class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}