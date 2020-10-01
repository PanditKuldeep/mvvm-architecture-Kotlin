package com.kp.mvvm_architecture_kotlin.login

import android.content.Intent
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.lifecycle.Observer
import com.kp.mvvm_architecture_kotlin.R
import com.kp.mvvm_architecture_kotlin.base.BaseActivity
import com.kp.mvvm_architecture_kotlin.global.App
import com.kp.mvvm_architecture_kotlin.home.HomeActivity
import com.kp.mvvm_architecture_kotlin.utils.Utils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    lateinit var mViewModel: LoginViewModel

    override fun contentView() = R.layout.activity_login
    override fun screenTitle() = ""

    override fun init() {
        mViewModel = getViewModel(this, LoginViewModel::class.java)

        btn_sign_in.setOnClickListener {
             if (validate()) {
                 checkUser()
             }
        }

        chk_show_password.setOnCheckedChangeListener { _, b ->
            if (b) et_password.transformationMethod = null
            else et_password.transformationMethod = PasswordTransformationMethod()
        }
    }

    private fun validate(): Boolean {
        if (et_username.text.isNullOrEmpty()) {
            et_username.error = "Please Enter valid username"
            et_username.requestFocus()
            return false
        } else et_username.error = null

        if (et_password.text.isNullOrBlank()) {
            et_password.error = "Please Enter valid password"
            et_password.requestFocus()
            return false
        } else et_password.error = null

        return true
    }

    private fun checkUser() {
        if (Utils.isConnectivityAvailable(App.component.app())) {
            mViewModel.getUser(et_password.text.toString()).observe(this, Observer { isLogin ->
                if (isLogin) {
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Password is Admin", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(this, "Device is offline", Toast.LENGTH_SHORT).show()
        }
    }
}