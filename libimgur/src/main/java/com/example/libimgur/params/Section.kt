package com.example.libimgur.params

import com.squareup.moshi.Json


// this enum is created to restrict use of inputs except hot and top
// as api has only 2 sections

enum class Section {
    @Json(name = "hot") HOT,

    @Json(name = "top") TOP
}