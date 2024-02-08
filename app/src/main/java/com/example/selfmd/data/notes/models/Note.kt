package com.example.selfmd.data.notes.models

data class Note(
    val id : Long = 0,
    val title: String,
    val content: String,
    var isFavorite : Boolean = false
    )
