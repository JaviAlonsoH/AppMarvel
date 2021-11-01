package com.example.sdkgiphyapp.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ItemXXX(
    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String,
    @SerializedName("name")
    @Expose
    val name: String
)