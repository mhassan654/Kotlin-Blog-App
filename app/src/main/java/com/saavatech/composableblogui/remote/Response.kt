package com.saavatech.composableblogui.remote

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("error")
    val error: Boolean,

    @SerializedName("message")
    val message: String
)

//data class LoginResponse(
//    @SerializedName("error")
//    val error: Boolean,
//
//    @SerializedName("message")
//    val message: String,
//
//    @SerializedName("loginResult")
//    val loginResult: LoginResult
//)

data class LoginResult(
    @SerializedName("userId")
    val userId: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("token")
    val token: String
)

//data class StoriesResponse(
//    @field:SerializedName("error")
//    val error: Boolean,
//
//    @field:SerializedName("message")
//    val message: String,
//
//    @field:SerializedName("listStory")
//    val listStory: List<ListStoryItem>
//)

data class FileUploadResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)


//@Entity(tableName = "story")
//class ListStoryItem(
//    @PrimaryKey
//    @field:SerializedName("id")
//    val id: String,
//
//    @field:SerializedName("name")
//    val name: String? = null,
//
//    @field:SerializedName("description")
//    val description: String? = null,
//
//    @field:SerializedName("photoUrl")
//    val photoUrl: String,
//
//    @field:SerializedName("createdAt")
//    val createdAt: String? = null,
//
//    @field:SerializedName("lon")
//    val lon: Double,
//
//    @field:SerializedName("lat")
//    val lat: Double
//)