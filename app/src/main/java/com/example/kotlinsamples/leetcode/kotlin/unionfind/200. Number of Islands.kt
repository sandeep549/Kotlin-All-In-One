package com.example.kotlinsamples.leetcode.kotlin.unionfind

private fun numIslands(grid: Array<CharArray>): Int {
    var seen = mutableSetOf<Pair<Int, Int>>()
    fun dfs(r: Int, c: Int): Boolean {
        if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size) return false
        if (grid[r][c] == '0' || seen.contains(Pair(r, c))) return false
        seen.add(Pair(r, c))
        dfs(r, c + 1)
        dfs(r, c - 1)
        dfs(r - 1, c)
        dfs(r + 1, c)
        return true
    }

    var count = 0
    for (r in grid.indices) {
        for (c in grid[0].indices) {
            if (dfs(r, c)) count++
        }
    }
    return count
}

private fun numIslands2(grid: Array<CharArray>): Int {
    fun dfs(r: Int, c: Int) {
        if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size) return
        if (grid[r][c] == '0') return
        grid[r][c] = '0'
        dfs(r, c + 1)
        dfs(r, c - 1)
        dfs(r - 1, c)
        dfs(r + 1, c)
    }

    var count = 0
    for (r in grid.indices) {
        for (c in grid[0].indices) {
            if (grid[r][c] == '1') {
                count++
                dfs(r, c)
            }
        }
    }
    return count
}
//todo: do it with bfs and union find