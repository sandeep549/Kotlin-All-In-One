package com.example.kotlinsamples.leetcode

private fun twoSum(numbers: IntArray, target: Int): IntArray {
    for (i in numbers.indices) {
        var j = numbers.binarySearch(target - numbers[i], i + 1)
        if (j > 0) return intArrayOf(i + 1, j + 1)
    }
    return intArrayOf()
}

private fun twoSum2(numbers: IntArray, target: Int): IntArray {
    var l = 0;
    var r = numbers.size - 1;
    while (l < r) {
        if (numbers[l] + numbers[r] == target) return intArrayOf(l + 1, r + 1)
        else if (numbers[l] + numbers[r] < target) l++
        else if (numbers[l] + numbers[r] > target) r--
    }
    return intArrayOf()
}