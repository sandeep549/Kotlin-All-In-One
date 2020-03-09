package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1
    while (i >= 0 && j >= 0) nums1[k--] = if (nums1[i] >= nums2[j]) nums1[i--] else nums2[j--]
    while (j >= 0) nums1[k--] = nums2[j--]
}