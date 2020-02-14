package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun maximumProduct(nums: IntArray): Int {
    var max = Int.MIN_VALUE
    for (i in 0..nums.lastIndex - 2) {
        for (j in i + 1 until nums.lastIndex) {
            for (k in j + 1..nums.lastIndex) {
                var p = nums[i] * nums[j] * nums[k]
                max = max.coerceAtLeast(p)
            }
        }
    }
    return max
}

private fun maximumProduct2(nums: IntArray): Int {
    nums.sort()
    return (nums[0] * nums[1] * nums[nums.lastIndex]).coerceAtLeast(
        nums[nums.lastIndex - 2] *
                nums[nums.lastIndex - 1] * nums[nums.lastIndex]
    )
}

private fun maximumProduct3(nums: IntArray): Int {
    var min1 = Int.MAX_VALUE
    var min2 = Int.MAX_VALUE
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    var max3 = Int.MIN_VALUE
    for (n in nums) {
        if (n <= min1) {
            min2 = min1
            min1 = n
        } else if (n <= min2) {
            min2 = n
        }
        if (n >= max1) {
            max3 = max2
            max2 = max1
            max1 = n
        } else if (n >= max2) {
            max3 = max2
            max2 = n
        } else if (n >= max3) {
            max3 = n
        }
    }
    return (min1 * min2 * max1).coerceAtLeast(max1 * max2 * max3)
}

//private fun maximumProduct4(nums: IntArray): Int {
//    var max3 = Int.MIN_VALUE
//    var maxp2 = Int.MIN_VALUE
//    var minn2 = Int.MAX_VALUE
//    var max1 = Int.MIN_VALUE
//    var min1 = Int.MAX_VALUE
//    for (n in nums) {
//        max3 = max3.coerceAtLeast(maxp2 * n).coerceAtLeast(minn2 * n)
//        maxp2 = maxp2.coerceAtLeast(max1 * n)
//        minn2 = minn2.coerceAtMost(min1 * n).coerceAtMost(max1 * n)
//        max1 = max1.coerceAtLeast(n)
//        min1 = min1.coerceAtMost(n)
//    }
//    return max3
//}