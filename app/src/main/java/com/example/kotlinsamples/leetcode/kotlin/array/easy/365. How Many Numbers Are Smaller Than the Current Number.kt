package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun countSmaller(nums: IntArray): List<Int> {
    var smaller = IntArray(nums.size)
    var arr = Array(nums.size) { i -> Pair(i, nums[i]) }

    fun mergeSort(arr: Array<Pair<Int, Int>>): Array<Pair<Int, Int>> {
        if (arr.size <= 1) return arr
        var mid = arr.size / 2
        var left = mergeSort(arr.copyOfRange(0, mid))
        var right = mergeSort(arr.copyOfRange(mid, arr.size))
        var i = 0
        var j = 0

        while (i < left.size || j < right.size) {
            if (j == right.size || i < left.size && left[i].second <= right[j].second) {
                arr[i + j] = left[i]
                smaller[left[i].first] += j
                i++
            } else {
                arr[i + j] = right[j]
                j++
            }
        }
        return arr
    }
    mergeSort(arr)
    return smaller.toList()
}

private fun countSmaller2(nums: IntArray): List<Int> {
    return nums.mapIndexed { i, num -> nums.drop(i + 1).filter { it < num }.size }
}

private fun countSmaller3(nums: IntArray): List<Int> {
    return nums
        .mapIndexed { i, it ->
            nums
                .slice(i until nums.size)
                .filter { i -> it>i }
                .count()
        }
}
