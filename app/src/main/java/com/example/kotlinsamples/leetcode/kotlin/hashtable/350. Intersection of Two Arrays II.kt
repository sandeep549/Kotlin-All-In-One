package com.example.kotlinsamples.leetcode.kotlin.hashtable

private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    var map1 = nums1.toList().groupingBy { it }.eachCount()
    var map2 = nums2.toList().groupingBy { it }.eachCount()
    var ans = ArrayList<Int>()
    for ((k, v) in map1) {
        if (map2.containsKey(k)) {
            for (i in 1..Math.min(v, map2.get(k)!!)) ans.add(k)
        }
    }
    return ans.toIntArray()
}

private fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
    nums1.sort()
    nums2.sort()
    var i = 0
    var j = 0
    var ans = ArrayList<Int>()
    while (i < nums1.size && j < nums2.size) {
        if (nums1[i] < nums2[j]) i++
        else if (nums1[i] > nums2[j]) j++
        else {
            ans.add(nums1[i])
            i++
            j++
        }
    }
    return ans.toIntArray()
}