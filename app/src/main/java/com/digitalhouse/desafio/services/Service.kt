package com.digitalhouse.desafio.services

import com.digitalhouse.desafio.models.Msg
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository {

    @GET("comics")
    suspend fun getResults(
        @Query("offset") p1: Int,
        @Query("limit") p2: Int,
        @Query("ts") p3: Int,
        @Query("apikey") p4: String,
        @Query("hash") p5: String,
    ): Msg
}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/characters/1009610/"

val retrofit = Retrofit.Builder()
    .baseUrl(urlApiMarvel)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)

//https://gateway.marvel.com:443/v1/public/characters/1009610/comics?
// apikey=35ad1d6a890da5ea66ebdf44e423d42c