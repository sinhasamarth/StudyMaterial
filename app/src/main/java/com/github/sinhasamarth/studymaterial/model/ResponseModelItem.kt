package com.github.sinhasamarth.studymaterial.model

data class ResponseModelItem(
    val `data`: List<Data>,
    val key: String,
    val meta: Meta
)