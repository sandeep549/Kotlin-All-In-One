package com.example.kotlinsamples.leetcode.kotlin

import kotlin.math.abs
import kotlin.math.absoluteValue

// using comparator
private fun sortArray(twoDArray: Array<IntArray>) {

    // 1
    twoDArray.sortWith(kotlin.Comparator { t1, t2 -> t1[1] - t2[1] })

    // 2
    twoDArray.sortWith(object : Comparator<IntArray> {
        override fun compare(p0: IntArray?, p1: IntArray?): Int {
            return p0!![1] - p1!![1]
        }

    })

}

//using pair and tripple
private fun PairExample() {
    var p = Pair("sandeep", 1)
    println(p.first)
    println(p.second)
}

//using pair and tripple
private fun TrippleExample() {
    var p = Triple("sandeep", 1, 4.9)
    println(p.first)
    println(p.second)
    println(p.third)
}

fun main() {
    minIndex()
}

//find min index of smallest abs value in array
private fun minIndex() {
    var arr = intArrayOf(3, 2, -1, 6, 9, 0)
    println(arr.indexOf(arr.minBy { i -> (i) }!!))

    val index = arr.minBy { (it) }?.let { arr.indexOf(it) }
    println(index)

    val i = arr.withIndex().minBy { (_, f) -> f }?.index
    println(i)

    println(arr.indexOf(arr.min()!!))

    println(arr.indices.minBy { arr[it] })
}
