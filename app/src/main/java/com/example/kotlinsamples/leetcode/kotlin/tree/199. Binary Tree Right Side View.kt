package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*
import kotlin.collections.ArrayList

private fun rightSideView(root: TreeNode?): List<Int> {
    var list = mutableListOf<Pair<Int, Int>>()
    var set = mutableSetOf<Int>()
    fun dfs(root: TreeNode?, level: Int) {
        root?.let {
            dfs(root.right, level + 1)
            if (!set.contains(level)) {
                list.add(Pair(level, root.`val`))
                set.add(level)
            }
            dfs(root.left, level + 1)
        }
    }
    dfs(root, 0)
    list.sortBy { it.first }
    return list.map { it.second }
}

private fun rightSideView2(root: TreeNode?): List<Int> {
    var list = mutableListOf<Int>()
    fun dfs(root: TreeNode?, level: Int) {
        root?.let {
            if (list.size < level) list.add(root.`val`)
            dfs(root.right, level + 1)
            dfs(root.left, level + 1)
        }
    }
    dfs(root, 1)
    return list
}

fun rightSideView3(root: TreeNode?): List<Int?>? { // reverse level traversal
    val result: MutableList<Int?> = ArrayList()
    val queue: Queue<TreeNode> = LinkedList()
    if (root == null) return result
    queue.offer(root)
    while (!queue.isEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val cur: TreeNode = queue.poll()
            if (i == 0) result.add(cur.`val`)
            if (cur.right != null) queue.offer(cur.right)
            if (cur.left != null) queue.offer(cur.left)
        }
    }
    return result
}