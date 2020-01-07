package com.example.kotlinsamples.leetcode.binarysearch

fun main() {
    println(findPeakElement(intArrayOf(1, 2, 3, 1)))
    println(findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
    println(findPeakElement(intArrayOf(1, 2)))
}

private fun findPeakElement(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    var mid = 0
    while (l < r) {
        mid = l + (r - l) / 2
        if (nums[mid] > nums[mid + 1]) { //check mid with mid+1, as it will work for size 2 array
            r = mid //always keep mid in search space, it could be peak
        } else {
            l =
                mid + 1 //always increment left pointer as it will avoid infinite loop at start and end of array
        }
    }
    return l
}
