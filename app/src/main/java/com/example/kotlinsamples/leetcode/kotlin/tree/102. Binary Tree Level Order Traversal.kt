package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*
import kotlin.collections.ArrayList

private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    if (root == null) return res
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    while (!q.isEmpty()) {
        var size = q.size
        val list = ArrayList<Int>()
        while (size > 0) {
            val node = q.poll()
            list.add(node.`val`)
            node.left?.let { q.add(it) }
            node.right?.let { q.add(it) }
            size--
        }
        res.add(list)
    }
    return res
}

//todo: do it with recursion