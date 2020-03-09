package com.example.kotlinsamples.leetcode.kotlin.array.easy

fun main() {
    println(
        arraysIntersection(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(1, 2, 5, 7, 9),
            intArrayOf(1, 3, 4, 5, 8)
        )
    )
}

private fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {
    var i = 0
    var j = 0
    var k = 0
    var ans = ArrayList<Int>()
    while (i < arr1.size && j < arr2.size && k < arr3.size) {
        if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
            ans.add(arr1[i])
            i++
            j++
            k++
        } else {
            var min = arrayOf(arr1[i], arr2[j], arr3[k]).min() // u can use Math.min() also
            if (min == arr1[i]) i++
            if (min == arr2[j]) j++
            if (min == arr3[k]) k++
        }
    }
    return ans
}