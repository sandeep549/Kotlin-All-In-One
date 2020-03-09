package com.example.kotlinsamples.leetcode.kotlin.array.easy

import java.util.*
import kotlin.random.Random

// O(nlogn),O(n)
private fun kClosest1(points: Array<IntArray>, K: Int): Array<IntArray>? {
    fun distance(point: IntArray) = point[0] * point[0] + point[1] * point[1]
    val N = points.size
    val dists = IntArray(N)
    for (i in 0 until N) dists[i] = distance(points[i])
    Arrays.sort(dists)
    val distK = dists[K - 1]
    val ans = Array(K) { IntArray(2) }
    var t = 0
    for (i in 0 until N) if (distance(points[i]) <= distK) ans[t++] = points[i]
    return ans
}

// O(nlogn),O(n)
private fun kClosest2(points: Array<IntArray>, K: Int): Array<IntArray> {
    return points.sortedWith(kotlin.Comparator { t1, t2 -> (t1[0] * t1[0] + t1[1] * t1[1]) - (t2[0] * t2[0] + t2[1] * t2[1]) })
        .take(K)
        .toTypedArray()
}

private fun kClosest3(points: Array<IntArray>, K: Int): Array<IntArray> {
    return points.sortedWith(compareBy<IntArray> { it[0] * it[0] + it[1] * it[1] }).take(K)
        .toTypedArray()
}

// todo: need to verify this solution
private fun kClosest4(points: Array<IntArray?>, K: Int): Array<IntArray?>? {
    if (points.isEmpty()) return null

    // gives distance of ith point from origin
    fun distance(i: Int) = points[i]?.let { it[0] * it[0] + it[1] * it[1] } ?: Int.MAX_VALUE

    // swap two points (i.e. two rows on Array)
    fun swap(i: Int, j: Int) {
        points[i] = points[j].also { points[j] = points[i] }
    }

    /**
     * Partition process of quick-sort. O(n)
     * Function return pivot element position j, who is correct position in sorted array.
     * All element greater than pivot will be on right side of j index and small on left side of it.
     */
    fun partition(i: Int, j: Int): Int {
        var i = i
        var j = j
        val oi = i // save pivot original position
        // we need to sort based on distance
        // get distance of ith point from origin; each row is a point
        val pivot = distance(i)
        i++
        while (true) {
            while (i < j && distance(i) < pivot) i++
            while (i <= j && distance(j) > pivot) j--
            if (i >= j) break
            swap(i, j)
        }
        swap(oi, j) // place pivot in its right position
        return j // return pivot position
    }

    fun sort(i: Int, j: Int, K: Int) {
        if (i >= j) return
        val k = Random.nextInt(i, j)
        swap(i, k)
        val mid = partition(i, j)
        val leftLength = mid - i + 1
        if (K < leftLength)
            sort(i, mid - 1, K)
        else if (K > leftLength)
            sort(mid + 1, j, K - leftLength)
    }

    sort(0, points.size - 1, K)
    return points.copyOfRange(0, K)
}
