package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*
import kotlin.collections.ArrayList


//not tested, please re-test it
private fun averageOfLevels(root: TreeNode?): DoubleArray {
    var list = ArrayList<Pair<Int, Double>>()
    fun dfs(root: TreeNode, level: Int) {
        if (list.size <= level) list.add(Pair(level, root.`val`.toDouble()))
        else list[level] = Pair(level, list[level].second + root.`val`.toDouble())
        root.left?.let { dfs(it, level + 1) }
        root.right?.let { dfs(it, level + 1) }
    }
    root?.let { dfs(it, 0) }
    return list.map { it.second / it.first }.toDoubleArray()
}

private fun averageOfLevels2(root: TreeNode?): DoubleArray {
    val list: MutableList<Double> = ArrayList()
    val queue: Queue<TreeNode> = ArrayDeque()
    queue.offer(root)
    while (!queue.isEmpty()) {
        val count: Int = queue.size
        var sum = 0.0
        for (i in 0 until count) {
            val cur: TreeNode = queue.poll()
            sum += cur.`val`.toDouble()
            if (cur.left != null) queue.offer(cur.left)
            if (cur.right != null) queue.offer(cur.right)
        }
        list.add(sum / count)
    }
    return list.toDoubleArray()
}
