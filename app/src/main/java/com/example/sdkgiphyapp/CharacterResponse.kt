package com.example.sdkgiphyapp.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class CharacterResponse(
    @SerializedName("code")
    @Expose
    val code: Int,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("copyright")
    @Expose
    val copyright: String,
    @SerializedName("attributionText")
    @Expose
    val attributionText: String,
    @SerializedName("attributionHTML")
    @Expose
    val attributionHTML: String,
    @SerializedName("etag")
    @Expose
    val etag: String,
    @SerializedName("data")
    @Expose
    val `data`: Data
)