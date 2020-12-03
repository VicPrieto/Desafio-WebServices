package com.digitalhouse.desafio.models

data class HQ(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: Thumbnail,
    val dates: List<Date>,
    val prices: Prices,
    val pageCount: Int,
    )