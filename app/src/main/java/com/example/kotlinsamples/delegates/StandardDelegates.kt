package com.example.kotlinsamples.delegates

import kotlin.properties.Delegates

fun main() {
    println(name)
    println(name)

    println(city)
    city = "pinkcity"
}

val name: String by lazy {
    println("first time")
    "sam"
}

var city: String by Delegates.observable("<no name>") {
        prop, old, new ->
    println("$old -> $new")
}