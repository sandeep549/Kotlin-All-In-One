package com.example.kotlinsamples.extensionfunctions

open class Shape

class Rectangle : Shape()

fun Shape.getName() = "Shape"

fun Rectangle.getName() = "Rectangle"

fun printClassName(s: Shape) {
    println(s.getName())
}

class Example {
    fun hello() {
        println("hello")
    }
}

fun Example.hello() {
    println("hello")
}

fun main() {
    printClassName(Rectangle())
    Example().hello()
}