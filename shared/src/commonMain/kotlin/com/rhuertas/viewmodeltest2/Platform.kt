package com.rhuertas.viewmodeltest2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform