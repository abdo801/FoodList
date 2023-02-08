package com.example.foodlist

data class Foods(
    val name: String,
//this is not really an image url (link) its just going to hold a drawable resource id as the annotation suggests
     val imageUrl: Int
)