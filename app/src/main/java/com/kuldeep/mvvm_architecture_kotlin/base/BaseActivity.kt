package com.kuldeep.mvvm_architecture_kotlin.base
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView())
        init()
        screenTitle()
    }

    override fun onResume() {
        super.onResume()
    }


    abstract fun contentView(): Int
    abstract fun init()
    abstract fun screenTitle() : String


    fun<V: ViewModel>getViewModel(owner: androidx.fragment.app.FragmentActivity, model: Class<V>):V = ViewModelProviders.of(owner).get<V>(model)

}