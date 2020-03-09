package com.example.kotlinsamples.leetcode.kotlin.dp

/**
1. Optimal structure
f(n) = Max(                 // max product till index n
            g`(n-1)*arr[n], // min product ending at index n-1 * arr[n]
            arr[n],         // element at index n, single element product
            f`(n-1)*arr[n], // max product ending at index n-1 * arr[n]
            f(n-1)          // max product found so far till index n-1
            )

f`(n) = Max(                // max product ending at index n
            f'(n-1) * arr[n],
            arr[n],
            g'(n-1) * arr[n]
            )
g`(n) = Min(                // min product ending at index n
            f'(n-1) * arr[n],
            arr[n],
            g'(n-1) * arr[n]
            )

2. sub-problems calls tree for f(4), depicting overlapping sub-problems
same as (53. Maximum Subarray.kt)
 */

fun main() {
    println(maxProduct(intArrayOf(2, -5, -2, -4, 3)))
}

// dp, top-down
// though StackOverFlow for big array size, works well for small
lateinit var dpmax: IntArray
lateinit var dpmin: IntArray
private fun maxProduct(nums: IntArray): Int {
    dpmax = IntArray(nums.size)
    dpmin = IntArray(nums.size)
    var dp = IntArray(nums.size)
    fun maxproduct(n: Int): Int {
        if (n == 0) return nums[0]
        if (dp[n] == 0) {
            dp[n] = (maxproduct(n - 1))
                .coerceAtLeast(minEndingAtIndex(n - 1, nums) * nums[n])
                .coerceAtLeast(maxEndingAtIndex(n - 1, nums) * nums[n])
                .coerceAtLeast(nums[n])
        }
        return dp[n]
    }
    return maxproduct(nums.size - 1)
}

private fun maxEndingAtIndex(i: Int, nums: IntArray): Int {
    if (i == 0) return nums[0]
    if (dpmax[i] == 0) {
        dpmax[i] = nums[i].coerceAtLeast(maxEndingAtIndex(i - 1, nums) * nums[i])
                            .coerceAtLeast(minEndingAtIndex(i - 1, nums) * nums[i])
    }
    return dpmax[i]
}

private fun minEndingAtIndex(i: Int, nums: IntArray): Int {
    if (i == 0) return nums[0]
    if (dpmin[i] == 0) {
        dpmin[i] = nums[i].coerceAtMost(maxEndingAtIndex(i - 1, nums) * nums[i])
            .coerceAtMost(minEndingAtIndex(i - 1, nums) * nums[i])
    }
    return dpmin[i]
}

// dp, bottom-up
// f[i] means maximum product that can be achieved ending with i
// g[i] means minimum product that can be achieved ending with i
private fun maxProduct2(A: IntArray): Int {
    if (A.isEmpty()) return 0
    val f = IntArray(A.size)
    val g = IntArray(A.size)
    f[0] = A[0]
    g[0] = A[0]
    var res: Int = A[0]
    for (i in 1 until A.size) {
        f[i] = (f[i - 1] * A[i]).coerceAtLeast(g[i - 1] * A[i]).coerceAtLeast(A[i])
        g[i] = (f[i - 1] * A[i]).coerceAtMost(g[i - 1] * A[i]).coerceAtMost(A[i])
        res = res.coerceAtLeast(f[i])
    }
    return res
}
