package com.example.mvvm_architecture_kotlin.home


import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvm_architecture_kotlin.R
import com.example.mvvm_architecture_kotlin.base.BaseActivity
import com.example.mvvm_architecture_kotlin.global.App
import com.example.mvvm_architecture_kotlin.utils.OnItemClickListener
import com.example.mvvm_architecture_kotlin.utils.ProgressLoader
import com.example.mvvm_architecture_kotlin.utils.Utils
import com.example.mvvm_architecture_kotlin.utils.livedata_wrapper.DataStatus
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    lateinit var mViewModel: HomeViewModel
    lateinit var loader: ProgressLoader
    private var mAdapter: HomeRecyclerAdapter? = null

    override fun contentView() = R.layout.activity_home
    override fun screenTitle() = ""

    override fun init() {
        loader = ProgressLoader(this)
        mViewModel = getViewModel(this, HomeViewModel::class.java)

        if (Utils.isConnectivityAvailable(App.component.app())) {
            mViewModel.getDetails().observe(this, Observer { response ->
                when (response.status) {
                    DataStatus.LOADING -> loader.showLoading()
                    DataStatus.SUCCESS -> {
                        loader.dismissLoading()
                        if (response.data != null) {
                            mAdapter = HomeRecyclerAdapter(
                                this,
                                response.data,
                                object : OnItemClickListener {
                                    override fun onItemClickListener(position: Int, value: String) {
                                        Toast.makeText(this@HomeActivity,value, Toast.LENGTH_SHORT).show()
                                    }
                                })
                            rv_centers.adapter = mAdapter
                        }
                    }
                    DataStatus.COMPLETE -> loader.dismissLoading()
                    DataStatus.ERROR -> {
                        loader.dismissLoading()
                        Toast.makeText(
                            this,
                            "Something went wrong.. Please try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        loader.dismissLoading()
                        Toast.makeText(
                            this,
                            "Something went wrong.. Please try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        } else {
            Toast.makeText(this, "Device is offline", Toast.LENGTH_SHORT).show()
        }
    }


}