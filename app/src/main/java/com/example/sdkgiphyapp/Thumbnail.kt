package com.example.sdkgiphyapp.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Thumbnail(
    @SerializedName("path")
    @Expose
    val path: String,
    @SerializedName("extension")
    @Expose
    val extension: String
)
