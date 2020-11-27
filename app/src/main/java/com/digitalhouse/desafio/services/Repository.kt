package com.digitalhouse.desafio.services

import com.digitalhouse.desafio.models.Msg
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Service {

    @GET("comics?apikey=35ad1d6a890da5ea66ebdf44e423d42c")
    suspend fun getAllHQ(): Msg
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com:443/v1/public/characters/1009610")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service: Service = retrofit.create(Service::class.java)

//https://gateway.marvel.com:443/v1/public/characters/1009610/comics?apikey=35ad1d6a890da5ea66ebdf44e423d42c