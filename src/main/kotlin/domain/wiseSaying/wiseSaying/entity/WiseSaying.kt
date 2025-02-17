package com.domain.wiseSaying.wiseSaying.entity

data class WiseSaying (
    var content: String,
    var author: String
) {
    var id: Int = 0

    fun modify(content: String, author: String) {
        this.content = content
        this.author = author
    }

    fun isNew(): Boolean {
        return id == 0
    }

    val json: String
        get() {
            return """
                {
                    "id": $id,
                    "content": "$content",
                    "author": "$author"
                }
            """.trimIndent()
        }
}