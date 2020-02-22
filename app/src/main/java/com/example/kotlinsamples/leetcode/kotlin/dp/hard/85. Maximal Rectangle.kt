package com.example.kotlinsamples.leetcode.kotlin.dp.hard

private fun maximalRectangle(matrix: Array<CharArray>): Int {
    /**
     * Consider all rectangle which has top left corner at r,c index.
     * For every row, find max area with minimum column size which has all 1 in it.
     * Traverse every row top to down and keep track of minimum column length found so far which has all 1.
     * At every row calculate max area  with current row distance and minimum column size distance and keep track of max so far.
     */
    fun maxAreaAt(i: Int, j: Int): Int {
        var max = 0
        if (matrix[i][j] == '0') return max
        var minC = Int.MAX_VALUE
        for (r in i..matrix.lastIndex) {
            var c = j
            while (c < matrix[0].size && matrix[r][c] == '1') c++
            minC = minOf(minC, c - 1)
            var currArea = (r - i + 1) * (minC - j + 1)
            max = maxOf(max, currArea)
        }
        return max
    }

    var ans = 0
    for (r in matrix.indices) {
        for (c in matrix[0].indices) {
            ans = maxOf(ans, maxAreaAt(r, c))
        }
    }
    return ans
}

private fun maximalRectangle2(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty()) return 0
    var r = matrix.size
    var c = matrix[0].size
    var left = IntArray(c) { 0 } //init left with leftmost boundary
    var right = IntArray(c) { c } //init right with rightmost boundary
    var height = IntArray(c)
    var max = 0
    for (i in 0 until r) {
        var cur_left = 0 //rightmost occurrence of zero encountered
        var cur_right = c
        //update height
        for (j in 0 until c) {
            if (matrix[i][j] == '1') height[j]++
            else height[j] = 0
        }

        //update left
        for (j in 0 until c) {
            if (matrix[i][j] == '1') left[j] = maxOf(left[j], cur_left)
            else {
                left[j] = 0
                cur_left = j + 1
            }
        }

        //update right
        for (j in c - 1 downTo 0) {
            if (matrix[i][j] == '1') right[j] = minOf(right[j], cur_right)
            else {
                right[j] = c
                cur_right = j
            }
        }

        //update area
        for (j in 0 until c) {
            max = maxOf(max, ((right[j] - left[j]) * height[j]))
        }
    }
    return max
}