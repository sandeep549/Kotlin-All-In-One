package com.example.kotlinsamples.leetcode.kotlin.dp

/**
 * R(n) = Min(G(n-1), B(n-1)) + arr[n][0]
 * B(n) = Min(R(n-1), G(n-1)) + arr[n][1]
 * G(n) = Min(R(n-1), B(n-1)) + arr[n][2]
 */

// #######################
// top-down, recursive
// #######################
private lateinit var cost: Array<IntArray>
private lateinit var mincost: Array<IntArray>
private fun minCost(costs: Array<IntArray>): Int {
    if (costs.isEmpty()) return 0
    cost = costs
    mincost = Array(costs.size) { IntArray(3) }
    return red(cost.size - 1).coerceAtMost(blue(cost.size - 1)).coerceAtMost(green(cost.size - 1))
}

// final cost when nth house is painted in red
private fun red(n: Int): Int {
    if (n == 0) return cost[0][0]
    if (mincost[n][0] == 0) mincost[n][0] = green(n - 1).coerceAtMost(blue(n - 1)) + cost[n][0]
    return mincost[n][0]
}

// final cost when nth house is painted in blue
private fun blue(n: Int): Int {
    if (n == 0) return cost[0][1]
    if (mincost[n][1] == 0) mincost[n][1] = red(n - 1).coerceAtMost(green(n - 1)) + cost[n][1]
    return mincost[n][1]
}

// final cost when nth house is painted in green
private fun green(n: Int): Int {
    if (n == 0) return cost[0][2]
    if (mincost[n][2] == 0) mincost[n][2] = red(n - 1).coerceAtMost(blue(n - 1)) + cost[n][2]
    return mincost[n][2]
}

// #######################
// bottom-up, iterative
// #######################

private fun minCost2(costs: Array<IntArray>): Int {
    if (costs.isEmpty()) return 0
    var lastR = costs[0][0]
    var lastG = costs[0][1]
    var lastB = costs[0][2]
    // At every step consider min cost when current house is painted with RED,GREEN or BLUE color
    for (i in 1 until costs.size) {
        val curR =
            lastG.coerceAtMost(lastB) + costs[i][0] // min cost when current house is painted RED
        val curG =
            lastR.coerceAtMost(lastB) + costs[i][1] // min cost when current house is painted GREEN
        val curB =
            lastR.coerceAtMost(lastG) + costs[i][2] // min cost when current house is painted BLUE
        lastR = curR
        lastG = curG
        lastB = curB
    }
    return lastR.coerceAtMost(lastG).coerceAtMost(lastB)
}
