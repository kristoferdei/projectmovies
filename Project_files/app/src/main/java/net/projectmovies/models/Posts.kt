package net.projectmovies.models

data class Posts(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
