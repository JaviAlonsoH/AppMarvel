package com.example.sdkgiphyapp.model


import com.example.sdkgiphyapp.Character
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Data(
    @SerializedName("offset")
    @Expose
    val offset: Int,
    @SerializedName("limit")
    @Expose
    val limit: Int,
    @SerializedName("total")
    @Expose
    val total: Int,
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("results")
    @Expose
    val results: List<Character>
)