package com.example.kotlinsamples.leetcode.kotlin.bfs

private fun orangesRotting(grid: Array<IntArray>): Int {
    var rotten = mutableListOf<Pair<Int, Int>>()
    var fresh = mutableSetOf<Pair<Int, Int>>()
    for (r in grid.indices) {
        for (c in grid[0].indices) {
            if (grid[r][c] == 1) fresh.add(Pair(r, c))
            else if (grid[r][c] == 2) rotten.add(Pair(r, c))
        }
    }
    fun canRot(r: Int, c: Int) = (r >= 0 && r < grid.size && c >= 0 && c < grid[0].size && grid[r][c] == 1)
    var minute = 0
    while (fresh.size > 0) {
        var freshRotten = mutableListOf<Pair<Int, Int>>()
        //println("rotten=" + rotten + ", fresh=" + fresh.size)
        for ((r, c) in rotten) {
            if (canRot(r, c - 1)) {
                freshRotten.add(Pair(r, c - 1))
                fresh.remove(Pair(r, c - 1))
                grid[r][c - 1] = 2
            }
            if (canRot(r, c + 1)) {
                freshRotten.add(Pair(r, c + 1))
                fresh.remove(Pair(r, c + 1))
                grid[r][c + 1] = 2
            }
            if (canRot(r - 1, c)) {
                freshRotten.add(Pair(r - 1, c))
                fresh.remove(Pair(r - 1, c))
                grid[r - 1][c] = 2
            }
            if (canRot(r + 1, c)) {
                freshRotten.add(Pair(r + 1, c))
                fresh.remove(Pair(r + 1, c))
                grid[r + 1][c] = 2
            }
        }
        //println("freshRotten=" + freshRotten)
        if (freshRotten.size == 0) break
        minute++
        rotten = freshRotten
    }
    return if (fresh.size == 0) minute else -1
}

fun main() {
    println(
        orangesRotting(
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(0, 1, 1),
                intArrayOf(1, 0, 1)
            )
        )
    )
}

