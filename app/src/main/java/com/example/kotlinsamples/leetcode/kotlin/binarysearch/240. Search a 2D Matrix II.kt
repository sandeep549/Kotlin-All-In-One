package com.example.kotlinsamples.leetcode.kotlin.binarysearch

// brute force, check every element
// O(n^2)
private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    for (i in 0..matrix.lastIndex) {
        for (j in 0..matrix[0].lastIndex) {
            if (matrix[i][j] == target) return true
        }
    }
    return false
}

// apply binary search on every row
// O(r*logc)
private fun searchMatrix1(matrix: Array<IntArray>, target: Int): Boolean {
    for (i in 0..matrix.lastIndex) {
        if (matrix[i].binarySearch(target) >= 0) return true
    }
    return false
}

// O(m+n)
private fun searchMatrix2(matrix: Array<IntArray>, target: Int): Boolean {
    var r = matrix.size - 1
    var c = 0
    while (r >= 0 && c < matrix[0].size) {
        if (target == matrix[r][c]) return true
        else if (target > matrix[r][c]) c++
        else r--
    }
    return false
}




