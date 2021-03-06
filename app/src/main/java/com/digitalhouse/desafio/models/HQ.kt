package com.digitalhouse.desafio.models
import java.io.Serializable

data class HQ(val data: Data): Serializable

data class Data(val results: ArrayList<Results>): Serializable

data class Results(val id: Int, val title: String, val description: String, val pageCount: String, val prices: ArrayList<Price>, val thumbnail: Thumbnail, val dates: ArrayList<Date>): Serializable

data class Price(val type: String, val price: String): Serializable

data class Thumbnail(val path: String, val extension: String): Serializable

data class Date(val type: String, val date: String): Serializable