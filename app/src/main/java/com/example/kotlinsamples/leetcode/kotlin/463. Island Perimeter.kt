package com.example.kotlinsamples.leetcode.kotlin

fun main() {
    println(
        islandPerimeter(
            arrayOf(
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 1, 0),
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 0, 0)
            )
        )
    )
}

private fun islandPerimeter(grid: Array<IntArray>): Int {
    //array to keep track of seen cells
    var dp = Array<IntArray>(grid.size) { IntArray(grid[0].size) { 0 } }
    fun lcon(i: Int, j: Int) = if (j == 0 || grid[i][j - 1] == 0) 1 else 0
    fun rcon(i: Int, j: Int) = if (j == grid[0].size - 1 || grid[i][j + 1] == 0) 1 else 0
    fun ucon(i: Int, j: Int) = if (i == 0 || grid[i - 1][j] == 0) 1 else 0
    fun bcon(i: Int, j: Int) = if (i == grid.size - 1 || grid[i + 1][j] == 0) 1 else 0

    //return current cell(i,j)  contribution in perimeter
    fun dfs(i: Int, j: Int): Int {
        if (i < 0 || j < 0 || //out of bound, no contribution
            i >= grid.size || //out of bound, no contribution
            j >= grid[0].size || //out of bound, no contribution
            grid[i][j] == 0 || //not part of island, no contribution
            dp[i][j] == 1 //already processed, contribution already counted
        ) return 0

        dp[i][j] = 1 //mark as seen/contributed
        return lcon(i, j) + //contribution from left side
                rcon(i, j) + //contribution from right side
                ucon(i, j) + //contribution from up side
                bcon(i, j) + //contribution from bottom side
                dfs(i, j - 1) + dfs(i, j + 1) + //recur for all neighbouring cells
                dfs(i - 1, j) + dfs(i + 1, j)
    }
    //find first cells with 1 value, and apply dfs
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) return dfs(i, j)
        }
    }
    return 0
}

private fun islandPerimeter2(grid: Array<IntArray>): Int {
    var ans = 0
    for (i in grid.indices) {
        for (j in grid.first().indices) {
            if (grid[i][j] == 1) {
                if (i == 0 || grid[i - 1][j] == 0) ans++     // top
                if (i == grid.size - 1 || grid[i + 1][j] == 0) ans++ // bottom
                if (j == 0 || grid[i][j - 1] == 0) ans++ // left
                if (j == grid.first().size - 1 || grid[i][j + 1] == 0) ans++ // right
            }
        }
    }
    return ans
}