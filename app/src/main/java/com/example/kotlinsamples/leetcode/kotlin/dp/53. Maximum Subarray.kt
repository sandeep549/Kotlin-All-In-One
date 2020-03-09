package com.example.kotlinsamples.leetcode.kotlin.dp

/**

1. Optimal structure
f(n) = MAX(f(n-1), f`(n-1) + arr[n], arr[n])
f`(i) = MAX(f`(i-1), 0) + arr[i]
Legends:
f(n) = max sum including and excluding index n
f`(n) = max sum including index n
arr[n] = element at index n in given array

2. sub-problems calls tree for f(4), depicting overlapping sub-problems
                  f4
                /   \
             f3      f`3
            /  \       \
         f2     f`2    f`2
        /  \      \      \
     f1     f`1   f`1     f`1
    /  \     \      \      \
  f0   f`0   f`0    f`0    f`0

 */

// top-down approach using memoization
// StackOverflowError for big size array, but works for smaller array size
private fun maxSubArray(arr: IntArray): Int {
    var dpi = IntArray(arr.size) { Int.MIN_VALUE }

    // function to return max sum ending at index i
    fun maxi(i: Int): Int {
        if (i == 0) return arr[0]
        if (dpi[i] > Int.MIN_VALUE) return dpi[i]
        var r = Math.max(maxi(i - 1), 0) + arr[i]
        dpi[i] = r
        return r
    }

    fun max(n: Int): Int {
        if (n == 0) return arr[0]
        var r = Math.max(max(n - 1), maxi(n - 1) + arr[n])
        r = Math.max(r, arr[n])
        return r
    }
    return max(arr.size - 1)
}

// bottom-up approach using tabulation
// f(n) = MAX(f(n-1), f`(n-1) + arr[n], arr[n])
// f(n) is max_so_far
// f`(n) is max_ending_here
private fun maxSubArray2(arr: IntArray): Int {
    var max_so_far = arr[0]
    var max_ending_here = arr[0]
    for (i in 1..arr.lastIndex) {
        max_ending_here = maxOf(max_ending_here + arr[i], arr[i])
        max_so_far = maxOf(max_so_far, max_ending_here)
    }
    return max_so_far
}