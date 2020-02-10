package com.example.kotlinsamples.leetcode.kotlin.array.NamedAlgorithms

/*

https://en.wikipedia.org/wiki/Dutch_national_flag_problem

Pseudocode
The following pseudocode for three-way partitioning assumes zero-based array indexing. It uses three indices i, j and k, maintaining the invariant that i ≤ j ≤ k.

Entries from 0 up to (but not including) i are values less than mid,
entries from i up to (but not including) j are values equal to mid,
entries from j up to (but not including) k are values not yet sorted, and
entries from k to the end of the array are values greater than mid.
 */

private fun threeWayPartition(nums: IntArray): Unit {
    var i = 0
    var j = 0
    var k = nums.size
    while (j < k) {
        when {
            nums[j] == 0 -> {
                nums[i] = nums[j].also { nums[j] = nums[i] }
                i++
                j++
            }
            nums[j] == 2 -> {
                k--
                nums[k] = nums[j].also { nums[j] = nums[k] }
            }
            else -> {
                j++
            }
        }
    }
}