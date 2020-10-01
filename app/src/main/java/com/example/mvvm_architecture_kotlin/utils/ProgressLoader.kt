package com.example.mvvm_architecture_kotlin.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.example.mvvm_architecture_kotlin.R

class ProgressLoader(context: Context): Dialog(context) {

    init {
        setContentView(R.layout.dialog_progress_loader)
        // Glide.with(context).asGif().load(R.drawable.loader).into(img_loader)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun showLoading(){
        if(this.isShowing)
            dismissLoading()
        show()
    }

    fun dismissLoading(){
        dismiss()
    }
}