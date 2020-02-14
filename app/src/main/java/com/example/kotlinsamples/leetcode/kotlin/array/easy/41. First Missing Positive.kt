package com.example.kotlinsamples.leetcode.kotlin.array.easy


private fun firstMissingPositive(nums: IntArray): Int {
    val n: Int = nums.size

    // Base case.
    var contains = 0
    for (i in 0 until n) if (nums[i] == 1) {
        contains++
        break
    }

    if (contains == 0) return 1

    // nums = [1] case
    if (n == 1) return 2

    // Replace negative numbers, zeros,
    // and numbers larger than n by 1s.
    // After this convertion nums will contain
    // only positive numbers.
    for (i in 0 until n) if (nums[i] <= 0 || nums[i] > n) nums[i] = 1

    // Use index as a hash key and number sign as a presence detector.
    // For example, if nums[1] is negative that means that number `1`
    // is present in the array.
    // If nums[2] is positive - number 2 is missing.
    for (i in 0 until n) {
        val a = Math.abs(nums[i])
        // If you meet number a in the array - change the sign of a-th element.
        // Be careful with duplicates : do it only once.
        if (a == n) nums[0] = -Math.abs(nums[0]) else nums[a] = -Math.abs(nums[a])
    }

    // Now the index of the first positive number
    // is equal to first missing positive.
    for (i in 1 until n) {
        if (nums[i] > 0) return i
    }

    return if (nums[0] > 0) n else n + 1
}

private fun firstMissingPositive2(nums: IntArray): Int {
    val n: Int = nums.size
    for (i in 0 until n) {
        if (nums[i] <= 0 || nums[i] > n) {
            nums[i] = n + 1
        }
    }
    for (i in 0 until n) {
        var num = Math.abs(nums[i])
        if (num > n) {
            continue
        }
        num-- // -1 for zero index based array (so the number 1 will be at pos 0)
        if (nums[num] > 0) { // prevents double negative operations
            nums[num] = -1 * nums[num]
        }
    }

    // 3. find the first cell which isn't negative (doesn't appear in the array)
    for (i in 0 until n) {
        if (nums[i] >= 0) {
            return i + 1
        }
    }

    // 4. no positive numbers were found, which means the array contains all numbers 1..n
    return n + 1
}

//Put each number in its right place.
private fun firstMissingPositive3(nums: IntArray): Int {
    var A = nums
    var n = A.size
    for (i in 0 until n)
        while (A[i] in 1..n && A[A[i] - 1] != A[i])
            A[i] = A[A[i] - 1].also { A[A[i] - 1] = A[i] }

    for (i in 0 until n)
        if (A.get(i) != i + 1) return i + 1

    return n + 1
}

