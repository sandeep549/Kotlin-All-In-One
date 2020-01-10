package com.example.kotlinsamples.leetcode.kotlin.hashtable

import android.annotation.SuppressLint

private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    return nums1.intersect(nums2.toHashSet()).toIntArray()
    //return nums1.toHashSet().intersect(nums2.toHashSet()).toIntArray()
}

@SuppressLint("NewApi")
private fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
    var map1 = HashMap<Int, Int>()
    for (n in nums1) {
        map1.put(n, map1.getOrDefault(n, 0) + 1)
    }
    var map2 = HashMap<Int, Int>()
    for (n in nums2) {
        map2.put(n, map2.getOrDefault(n, 0) + 1)
    }
    var ans = HashSet<Int>()
    for ((k, v) in map1) {
        var min = Math.min(v, map2.getOrDefault(k, 0))
        for (i in 1..min) ans.add(k)
    }
    return ans.toIntArray()
}

fun intersection3(nums1: IntArray, nums2: IntArray): IntArray {
    var set1 = nums1.toHashSet()
    var set2 = nums2.toHashSet()
    var ans = ArrayList<Int>()
    for (n in set1) if (set2.contains(n)) ans.add(n)
    return ans.toIntArray()
}