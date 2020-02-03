package com.example.kotlinsamples.leetcode.kotlin.twopointer

private fun trap(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var leftmax = 0
    var rightmax = 0
    var res = 0
    while (left < right) {
        if (height[left] <= height[right]) {
            if (height[left] > leftmax) leftmax = height[left]
            else res += (leftmax - height[left])
            left++
        } else {
            if (height[right] > rightmax) rightmax = height[right]
            else res += (rightmax - height[right])
            right--
        }
    }
    return res
}

private fun trap2(height: IntArray): Int {
    if (height.size == 0 || height.size == 1 || height.size == 2) return 0
    var res = 0
    var L = IntArray(height.size)
    var R = IntArray(height.size)
    L[0] = 0
    for (i in 1 until height.size) L[i] = maxOf(L[i - 1], height[i - 1])
    R[height.size - 1] = 0
    for (i in height.size - 2 downTo 0) R[i] = maxOf(R[i + 1], height[i + 1])
    for (i in 0 until height.size) res += (if (minOf(L[i], R[i]) - height[i] > 0) minOf(L[i], R[i]) - height[i] else 0)
    return res
}