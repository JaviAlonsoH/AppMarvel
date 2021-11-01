package com.example.sdkgiphyapp

import com.example.sdkgiphyapp.Character
import com.example.sdkgiphyapp.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getCharacters(@Url url:String): Response<CharacterResponse>
}
