package com.example.kotlinsamples.leetcode.kotlin.array

fun productExceptSelf(nums: IntArray): IntArray? {
    val result = IntArray(nums.size)
    var tmp = 1
    for (i in nums.indices) {
        result[i] = tmp
        tmp *= nums[i]
    }
    tmp = 1
    for (i in nums.indices.reversed()) {
        result[i] *= tmp
        tmp *= nums[i]
    }
    return result
}

fun productExceptSelf2(nums: IntArray): IntArray? {
    var ans = IntArray(nums.size)
    ans[nums.lastIndex] = 1
    for (i in nums.lastIndex - 1 downTo 0) ans[i] = ans[i + 1] * nums[i + 1]
    var mul = nums[0]
    for (i in 1..nums.lastIndex) {
        ans[i] = mul * ans[i]
        mul = mul * nums[i]
    }
    return ans
}

// one pass, if don't count initialization pass
fun productExceptSelf3(nums: IntArray): IntArray? {
    val result = IntArray(nums.size) { 1 }
    var left = 1
    var right = 1
    var i = 0
    var j: Int = nums.size - 1
    while (i < nums.size - 1) {
        left *= nums[i]
        right *= nums[j]
        result[i + 1] *= left
        result[j - 1] *= right
        i++
        j--
    }
    return result
}
