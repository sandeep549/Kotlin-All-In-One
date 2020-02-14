package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun permuteUnique(nums: IntArray): List<List<Int>> {
    var ans = mutableListOf<List<Int>>()
    fun backtrack(tmpList: MutableList<Int>, used: BooleanArray, level: Int) {
        println("level=$level, tmpList=$tmpList, used=${used.toList()}")
        if (tmpList.size == nums.size) {
            ans.add(tmpList.toList())
        } else {
            for (i in nums.indices) {
                // below both conditions work, see working carefully, commented one is more efficient
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue
                //if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue
                tmpList.add(nums[i])
                used[i] = true
                backtrack(tmpList, used, level + 1)
                used[i] = false
                tmpList.removeAt(tmpList.lastIndex)
            }
        }
    }
    nums.sort()
    backtrack(mutableListOf(), BooleanArray(nums.size), 0)
    return ans
}

fun main() {
    println(permuteUnique(intArrayOf(1, 1, 2)))
}