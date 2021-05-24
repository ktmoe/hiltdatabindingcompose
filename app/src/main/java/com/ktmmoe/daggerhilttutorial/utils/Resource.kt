package com.ktmmoe.daggerhilttutorial.utils

/**
 * Created by ktmmoe on 24, May, 2021
 **/
data class Resource<out T>(val status: Status, val data: T? = null, val message: String? = null) {
    companion object {
        fun <T> success(data: T? = null): Resource<T> = Resource(Status.SUCCESS, data)

        fun <T> error (msg: String, data: T? = null): Resource<T> = Resource(Status.ERROR, data, msg)

        fun <T> loading (data: T? = null) : Resource<T> = Resource(Status.LOADING, data)
    }
}
