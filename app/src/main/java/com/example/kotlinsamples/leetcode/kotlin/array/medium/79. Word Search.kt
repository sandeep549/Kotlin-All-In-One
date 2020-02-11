package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun exist(board: Array<CharArray>, word: String): Boolean {
    fun find(idx: Int, r: Int, c: Int, seen: MutableSet<Pair<Int, Int>>): Boolean {
        if (idx >= word.length) return true
        if (r < 0 || r >= board.size || c < 0 || c >= board[0].size || board[r][c] != word[idx]) return false

        seen.add(Pair(r, c))
        var ret = false
        var col = intArrayOf(0, 1, 0, -1)
        var row = intArrayOf(1, 0, -1, 0)
        for (i in 0..3) {
            var next = Pair(r + row[i], c + col[i])
            ret = (!seen.contains(next)) && find(idx + 1, next.first, next.second, seen.toMutableSet().also { it.add(Pair(r, c)) })
            if (ret) return true
        }
        return false
    }
    for (r in board.indices) {
        for (c in board[0].indices) {
            if (find(0, r, c, mutableSetOf())) return true
        }
    }
    return false
}

private fun exist2(board: Array<CharArray>, word: String): Boolean {
    fun find(idx: Int, r: Int, c: Int): Boolean {
        if (idx >= word.length) return true
        if (r < 0 || r >= board.size || c < 0 || c >= board[0].size || board[r][c] != word[idx]) return false

        board[r][c] = '*' //mark current as visited
        var ret = false
        var col = intArrayOf(0, 1, 0, -1)
        var row = intArrayOf(1, 0, -1, 0)
        for (i in 0..3) {
            var next = Pair(r + row[i], c + col[i])
            ret = find(idx + 1, next.first, next.second)
            if (ret) break
        }
        board[r][c] = word[idx] //unmark current cell, re-write original char back in board
        return ret
    }
    for (r in board.indices) {
        for (c in board[0].indices) {
            if (find(0, r, c)) return true
        }
    }
    return false
}