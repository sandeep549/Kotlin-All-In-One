package com.example.kotlinsamples.destructuringdeclaration

data class Person(val name: String, val age: Int)

fun main() {
    var (name, age) = Person("sandeep", 32)
    println("name=$name")
}

private fun hello(): Pair<Int, Int> {
    return Pair(2, 3)
}