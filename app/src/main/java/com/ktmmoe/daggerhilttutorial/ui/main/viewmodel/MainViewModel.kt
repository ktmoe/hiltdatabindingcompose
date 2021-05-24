package com.ktmmoe.daggerhilttutorial.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktmmoe.daggerhilttutorial.data.model.User
import com.ktmmoe.daggerhilttutorial.data.repository.MainRepository
import com.ktmmoe.daggerhilttutorial.utils.NetworkHelper
import com.ktmmoe.daggerhilttutorial.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by ktmmoe on 24, May, 2021
 **/
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
): ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
    get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading())
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) _users.postValue(Resource.success(it.body()))
                    else _users.postValue(Resource.error(it.errorBody().toString()))
                }
            } else _users.postValue(Resource.error("No internet connection."))
        }
    }
}