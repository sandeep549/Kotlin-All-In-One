package com.example.kotlinsamples.leetcode.kotlin.array

fun IntArray.swap(first: Int, second: Int) {
    this[first] = second.also { this[second] = first }
}