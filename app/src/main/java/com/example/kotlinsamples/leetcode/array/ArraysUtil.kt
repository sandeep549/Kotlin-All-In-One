package com.example.kotlinsamples.leetcode.array

fun IntArray.swap(first: Int, second: Int) {
    this[first] = second.also { this[second] = first }
}