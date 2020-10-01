package com.kuldeep.mvvm_architecture_kotlin.home

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("data") var data:List<Response>,
    @SerializedName("status") var status: String
)


data class Response(
    @SerializedName("id") var id: String,
    @SerializedName("employee_name") var employee_name: String,
    @SerializedName("employee_salary") var employee_salary: String,
    @SerializedName("employee_age") var employee_age: String,
    @SerializedName("profile_image") var profile_image: String
)