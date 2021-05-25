package com.ktmmoe.daggerhilttutorial.data.model

import android.util.Patterns

/**
 * Created by ktmmoe on 25, May, 2021
 **/
data class LoginUser (
    val userEmailAddress: String? = "",
    val password : String? =""
        ) {
    fun isEmailValid(): Boolean = Patterns.EMAIL_ADDRESS.matcher(userEmailAddress?:"").matches()
}