package com.example.kotlinsamples.leetcode.kotlin.array.SortingAlgorithms.SimpleSort
// https://en.wikipedia.org/wiki/Sorting_algorithm
/*
1. Selection Sort

Algorithm finds min value and swap it with first position and repeat these steps for remainder of the list.
-------------------------
| Time       |  O(n^2)  |
| Aux-Space  |  O(1)    |
-------------------------
| In-place   |  yes     |
| Stable     |  no      |
| Online     |  no      |
-------------------------
Highlights:
1. Good when less writes are required in comparision with Insertion Sort(O(n) verses O(n^2) swaps)
2. Good for smaller size list
 */

private fun selectionSort(arr: IntArray) {
    for (i in arr.indices) {
        var minIdx = i
        for (j in i + 1..arr.lastIndex) { // find min index
            if (arr[j] < arr[minIdx]) minIdx = j
        }

        // swap with first element under consideration
        arr[i] = arr[minIdx].also { arr[minIdx] = arr[i] }
    }
}

fun main() {
    var arr = intArrayOf(64, 25, 12, 22, 11)
    println(selectionSort(arr))
}