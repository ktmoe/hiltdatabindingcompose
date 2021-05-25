package com.ktmmoe.daggerhilttutorial.ui.login.viewmodel

import android.util.Patterns
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ktmmoe.daggerhilttutorial.data.model.LoginUser

/**
 * Created by ktmmoe on 25, May, 2021
 **/
class LoginViewModel: ViewModel() , Observable{

    @Bindable
    val emailAddress: MutableLiveData<String> = MutableLiveData()
    @Bindable
    val password: MutableLiveData<String> = MutableLiveData()
    val validInputs: MutableLiveData<Boolean> = MutableLiveData()

    init {
        validInputs.value = false
    }

    fun onLoginClicked() {
        val mail = emailAddress.value!!
        val mPassword = password.value!!
        if (Patterns.EMAIL_ADDRESS.matcher(mail).matches() || mPassword.isNotEmpty() )
            validInputs.postValue(true)
        else validInputs.postValue(false)
    }
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}