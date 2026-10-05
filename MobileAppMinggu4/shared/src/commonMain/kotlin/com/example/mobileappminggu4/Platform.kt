package com.example.mobileappminggu4

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform