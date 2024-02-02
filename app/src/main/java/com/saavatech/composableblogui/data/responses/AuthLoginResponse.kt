package com.saavatech.composableblogui.data.responses

import com.google.gson.annotations.SerializedName

data class AuthLoginResponse(val login: LoginResponse)

data class LoginResponse(
    @SerializedName("user") val user: Any,
    @SerializedName("token") val token: String,
    )
