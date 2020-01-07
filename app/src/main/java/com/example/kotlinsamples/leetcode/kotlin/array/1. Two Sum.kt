package com.example.kotlinsamples.leetcode.kotlin.array

fun main() {
    println(twoSum(intArrayOf(2, 11, 7, 15), 9).toList())
    println(twoSum2(intArrayOf(2, 11, 7, 15), 9).toList())
    println(twoSum3(intArrayOf(2, 11, 7, 15), 9).toList())
    println(twoSum4(intArrayOf(2, 11, 7, 15), 9).toList())
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    nums.forEachIndexed { fi, first ->
        nums.forEachIndexed { si, second ->
            if (first + second == target) return intArrayOf(
                fi,
                si
            )
        }
    }
    return intArrayOf()
}

private fun twoSum2(nums: IntArray, target: Int): IntArray {
    for (i in 0 until nums.size - 1) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) return intArrayOf(i, j)
        }
    }
    return intArrayOf()
}

private fun twoSum3(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        if (map.containsKey(target - nums[i])) {
            return intArrayOf(i, map[target - nums[i]]!!)
        }
        map.put(nums[i], i)
    }
    return intArrayOf()
}

private fun twoSum4(nums: IntArray, target: Int): IntArray {
    var x = -1;
    var y = -1;
    for (i in nums.indices) {
        val j = nums.lastIndexOf(target - nums[i]);
        if (j > i) {
            x = i;
            y = j;
            break;
        }
    }
    return intArrayOf(x, y)
}