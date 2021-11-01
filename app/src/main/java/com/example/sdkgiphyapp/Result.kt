package com.example.sdkgiphyapp


import android.media.Image
import com.example.sdkgiphyapp.model.*
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Character(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("modified")
    @Expose
    val modified: String,
    @SerializedName("thumbnail")
    @Expose
    val thumbnail: Thumbnail,
    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String,
    @SerializedName("comics")
    @Expose
    val comics: Comics,
    @SerializedName("series")
    @Expose
    val series: Series,
    @SerializedName("stories")
    @Expose
    val stories: Stories,
    @SerializedName("events")
    @Expose
    val events: Events,
    @SerializedName("urls")
    @Expose
    val urls: List<Url>
)