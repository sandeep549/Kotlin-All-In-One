package com.example.kotlinsamples.leetcode.kotlin.array.SortingAlgorithms.EfficientSort

// https://en.wikipedia.org/wiki/Sorting_algorithm#Quicksort
/*
=> Quick Sort (Partition Exchange Sort)

1. Pick an element, called a pivot, from the array.
2. Partitioning: reorder the array so that all elements with values less than the pivot
    come before the pivot, while all elements with values greater than the pivot come after
    it (equal values can go either way). After this partitioning, the pivot is in its final
    position. This is called the partition operation.
3. Recursively apply the above steps to the sub-array of elements with smaller values and
    separately to the sub-array of elements with greater values.

-------------------------
| Time       |  O(nlogn)| worst case O(n^2), though this is rare
| Aux-Space  |  O(logn) | O(n) in worst case
-------------------------
| In-place   |  yes     | we need auxiliary for stack calls
| Stable     |  no      | Default implementation is not stable
| Online     |  no      |
-------------------------
Highlights:
1. Its based on divide and conquer paradigm.
2. Algorithms efficiency greatly depends on partition scheme used. There are many partition schemes.
Todo :Must Visit https://www.geeksforgeeks.org/quick-sort/
 */

private fun sort(arr: IntArray) {
    fun partition(arr: IntArray, lo: Int, hi: Int): Int {
        var pivot = arr[hi]
        var i = lo
        var j = lo
        while (j <= hi) {
            if (arr[j] < pivot) {
                arr[i] = arr[j].also { arr[j] = arr[i] }
                i++
            }
            j++
        }
        arr[i] = arr[hi].also { arr[hi] = arr[i] }
        return i
    }

    fun quickSort(arr: IntArray, lo: Int, hi: Int) {
        if (lo < hi) {
            var pi = partition(arr, lo, hi)
            quickSort(arr, lo, pi - 1)
            quickSort(arr, pi + 1, hi)
        }
    }
    quickSort(arr, 0, arr.lastIndex)
    println(arr.toList())
}

fun main() {
    var arr = intArrayOf(64, 25, 12, 22, 11)
    println(sort(arr))
}