package com.github.sinhasamarth.studymaterial.model

data class ResponseModelItem(
    val `data`: List<ResponseModelItem>,
    val key: String,
    val meta: Meta,
    val value: Any
)