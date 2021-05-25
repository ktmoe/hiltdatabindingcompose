package com.ktmmoe.daggerhilttutorial.ui.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.ktmmoe.daggerhilttutorial.R
import com.ktmmoe.daggerhilttutorial.databinding.ActivityLoginBinding
import com.ktmmoe.daggerhilttutorial.ui.login.viewmodel.LoginViewModel
import com.ktmmoe.daggerhilttutorial.ui.main.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        mBinding.viewModel = viewModel

        viewModel.validInputs.observe(this, Observer {v->
            if (v) validInput() else invalidInput()
        })

    }

    private fun validInput() {
        finishAffinity()
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun invalidInput() {
        Snackbar.make(this.window.decorView, "Wrong Login", Snackbar.LENGTH_SHORT).show()
    }
}