package com.example.kotlinsamples.leetcode.kotlin

import android.annotation.SuppressLint

private fun intersect5(nums1: IntArray, nums2: IntArray): IntArray {
    nums1.sort()
    nums2.sort()
    var ans = ArrayList<Int>()
    var i = 0
    var j = 0
    while (i < nums1.size && j < nums2.size) {
        when {
            nums1[i] > nums2[j] -> j++
            nums1[i] < nums2[j] -> i++
            else -> {
                ans.add(nums1[i])
                i++
                j++
            }
        }
    }
    return ans.toIntArray()
}

@SuppressLint("NewApi")
private fun intersect4(nums1: IntArray, nums2: IntArray): IntArray {
    var map = HashMap<Int, Int>()
    var list = ArrayList<Int>()
    nums1.forEach { i -> map.put(i, map.getOrDefault(i, 0) + 1) }
    for (i in nums2) {
        if (map.containsKey(i) && map.get(i)!! > 0) {
            map.put(i, map.get(i)!! - 1)
            list.add(i)
        }
    }
    return list.toIntArray()
}

@SuppressLint("NewApi")
private fun intersect3(nums1: IntArray, nums2: IntArray): IntArray {
    var map = HashMap<Int, Int>()
    var list = ArrayList<Int>()
    nums1.forEach { i -> map.put(i, map.getOrDefault(i, 0) + 1) }
    nums2.forEach { i ->
        run {
            if (map.containsKey(i) && map.get(i)!! > 0) {
                map.put(i, map.get(i)!! - 1)
                list.add(i)
            }
        }
    }
    return list.toIntArray()
}

@SuppressLint("NewApi")
private fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
    var map1 = HashMap<Int, Int>()
    nums1.forEach { i -> map1.put(i, map1.getOrDefault(i, 0) + 1) }
    var map2 = HashMap<Int, Int>()
    nums2.forEach { i -> map2.put(i, map2.getOrDefault(i, 0) + 1) }
    var list = ArrayList<Int>()
    map1.keys.forEach {
        var min = Math.min(map1.getOrDefault(it, 0), map2.getOrDefault(it, 0))
        for (i in 0 until min) list.add(it)
    }
    return list.toIntArray()
}