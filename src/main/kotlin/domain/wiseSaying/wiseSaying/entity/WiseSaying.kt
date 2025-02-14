package com.domain.wiseSaying.wiseSaying.entity

data class WiseSaying (
    val id: Int,
    var content: String,
    var author: String
) {
    fun update(content: String, author: String) {
        this.content = content
        this.author = author
    }
}