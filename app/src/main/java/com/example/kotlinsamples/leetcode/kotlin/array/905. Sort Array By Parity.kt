package com.example.kotlinsamples.leetcode.kotlin.array

fun main() {
    println(sortArrayByParity(intArrayOf(1, 3, 2, 4)).toList())
}

private fun sortArrayByParity(arr: IntArray): IntArray {
    return arr.sortedBy { it % 2 }.toIntArray()
}

private fun sortArrayByParity1(arr: IntArray): IntArray {
    var k = 0
    var ans = IntArray(arr.size)
    for (a in arr) if (a % 2 == 0) ans[k++] = a
    for (a in arr) if (a % 2 != 0) ans[k++] = a
    return ans
}

private fun sortArrayByParity2(arr: IntArray): IntArray {
    var i = 0
    var j = arr.size - 1
    while (i < j) {
        if (arr[i] % 2 > arr[j] % 2) {
            var tmp = arr[i]
            arr[i] = arr[j]
            arr[j] = tmp
        }
        if (arr[i] % 2 == 0) i++
        if (arr[j] % 2 == 1) j--
    }
    return arr
}