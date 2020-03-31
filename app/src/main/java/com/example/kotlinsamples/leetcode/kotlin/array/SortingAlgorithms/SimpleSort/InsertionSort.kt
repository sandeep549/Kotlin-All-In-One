package com.example.kotlinsamples.leetcode.kotlin.array.SortingAlgorithms.SimpleSort
// https://en.wikipedia.org/wiki/Sorting_algorithm
/*
1. Insertion Sort

(a.) Loop from i till last index
(b.) Insert element at i index into sorted sequence between (0..i-1)

-------------------------
| Time       |  O(n^2)  |
| Aux-Space  |  O(1)    |
-------------------------
| In-place   |  yes     |
| Stable     |  yes     |
| Online     |  yes     |
-------------------------
Highlights:
1. Time complexity is O(n*k), when each element in input is no more than k places away from its sorted position
2. If array is already sorted, then inner llop won't execute and time is O(n)
3. Good when input is almost sorted
4. Good for small input size
5. Takes max time O(n^2) when input is in reverse order
 */

private fun insertionSort(arr: IntArray) {
    for (i in 1..arr.lastIndex) {
        var key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[++j] = key
    }
}

fun main() {
    var arr = intArrayOf(64, 25, 12, 22, 11)
    println(insertionSort(arr))
}