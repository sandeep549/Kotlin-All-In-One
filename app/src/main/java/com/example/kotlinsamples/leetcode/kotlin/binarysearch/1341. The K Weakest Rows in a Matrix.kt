package com.example.kotlinsamples.leetcode.kotlin.binarysearch

import java.util.*

private fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    fun findSoldiers(arr: IntArray): Int {
        var l = 0
        var r = arr.size - 1
        while (l < r) {
            var m = l + (r - l + 1) / 2
            if (arr[m] >= 1) {
                l = m
            } else {
                r = m - 1
            }
        }
        return if (arr[l] == 1) l + 1 else 0
    }

    var soldiersPairs: MutableList<Pair<Int, Int>> = mutableListOf<Pair<Int, Int>>()
    var i = 0
    for (row in mat) {
        var s = findSoldiers(row)
        soldiersPairs.add(Pair(s, i++))
    }
    soldiersPairs.sortBy { it.first }

    var weakRow = 0
    var ans = mutableListOf<Int>()
    for (pair in soldiersPairs) {
        if (weakRow == k) break
        ans.add(pair.second)
        weakRow++
    }
    return ans.toIntArray()
}

private fun kWeakestRows2(mat: Array<IntArray>, k: Int): IntArray {
    fun findSoldiers(arr: IntArray): Int {
        var l = 0
        var r = arr.size - 1
        while (l < r) {
            var m = l + (r - l + 1) / 2
            if (arr[m] >= 1) {
                l = m
            } else {
                r = m - 1
            }
        }
        return if (arr[l] == 1) l + 1 else 0
    }

    var pq = PriorityQueue<Pair<Int, Int>>(k) { p1, p2 -> if (p1.first == p2.first) p2.second - p1.second else p2.first - p1.first }
    var i = 0
    for (row in mat) {
        var s = findSoldiers(row)
        pq.offer(Pair(s, i++))
        if (pq.size > k) pq.poll()
    }

    var ans = IntArray(k)
    i = k - 1
    while (i >= 0) ans[i--] = pq.poll().second
    return ans
}

private fun kWeakestRows3(mat: Array<IntArray>, k: Int): IntArray {
    var pq = PriorityQueue<Pair<Int, Int>>(k) { p1, p2 -> if (p1.first == p2.first) p2.second - p1.second else p2.first - p1.first }
    var r = 0
    var c = 0
    var s = 0
    while (r < mat.size && c < mat[0].size) {
        while (mat[r][c] == 1 && c + 1 < mat[0].size && mat[r][c + 1] == 1) c++
        while (mat[r][c] == 0 && c - 1 >= 0) c--
        s = if (mat[r][c] == 1) c + 1 else 0
        pq.offer(Pair(s, r))
        if (pq.size > k) pq.poll()
        r++
    }
    var ans = IntArray(k)
    var i = k - 1
    while (i >= 0) ans[i--] = pq.poll().second
    return ans
}