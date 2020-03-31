package com.example.kotlinsamples.leetcode.kotlin.array.SortingAlgorithms.EfficientSort

// https://en.wikipedia.org/wiki/Sorting_algorithm
/*
1. Merge Sort

(a.) Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted)
(b.) Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list.

-------------------------
| Time       |  O(nlogn)| worst case
| Aux-Space  |  O(n)    |
-------------------------
| In-place   |  no      | we need auxiliary space
| Stable     |  yes     | Most implementation are stable
| Online     |  no      |
-------------------------
Highlights:
1. Can be applied to lists as it require sequential access. Best chois for sorting linked list.
2. Its based on divide and conquer paradigm.
Todo :Must Visit https://en.wikipedia.org/wiki/Merge_sort#Comparison_with_other_sort_algorithms
 */

private fun sort(arr: IntArray) {
    fun merge(arr: IntArray, l: Int, m: Int, r: Int) {
        var aux = IntArray(r - l + 1)
        var i = l
        var j = m + 1
        var k = 0
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) aux[k++] = arr[i++]
            else aux[k++] = arr[j++]
        }
        while (i <= m) aux[k++] = arr[i++]
        while (j <= r) aux[k++] = arr[j++]
        i = l
        for (a in aux) arr[i++] = a
    }

    fun mergeSort(arr: IntArray, l: Int, r: Int) {
        if (l < r) {
            var m = l + (r - l) / 2
            mergeSort(arr, 0, m)
            mergeSort(arr, m + 1, r)
            merge(arr, l, m, r)
        }
    }
    mergeSort(arr, 0, arr.lastIndex)
}

fun main() {
    var arr = intArrayOf(64, 25, 12, 22, 11)
    println(sort(arr))
}