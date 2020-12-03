package com.digitalhouse.desafio.services

import com.digitalhouse.desafio.models.HQ
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository {

    @GET("comics")
    suspend fun getResults(
        @Query("offset") p1: String,
        @Query("limit") p2: String,
        @Query("ts") p3: String,
        @Query("orderBy") p4: String,
        @Query("apikey") p5: String,
        @Query("hash") p6: String
    ): HQ
}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/characters/1009610/"

val retrofit = Retrofit.Builder()
    .baseUrl(urlApiMarvel)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)

//https://gateway.marvel.com/v1/public/characters/1009610/comics?ts=1&orderBy=focDate&limit=10&offset=1&apikey=c70e158b477c5ee33c838850e91a0be0&hash=90daceab9123b6f475d9ffeeea6ad19f

//PUBLIC KEY
//c70e158b477c5ee33c838850e91a0be0

//PRIVATE KEY
//d427f5a8db234bc02d1ffd9203d7fadb13254878

//HASH
//90daceab9123b6f475d9ffeeea6ad19f