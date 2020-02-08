package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*


private fun verticalOrder(root: TreeNode?): List<List<Int>> {
    data class Node(val col: Int, val tnode: TreeNode)

    val colMap = mutableMapOf<Int, MutableList<Int>>()
    if (root == null) return colMap.values.toList()
    var min = 0
    var max = 0
    var queue = ArrayDeque<Node>()
    queue.add(Node(0, root))
    while (!queue.isEmpty()) {
        var size = queue.size
        while (size > 0) {
            var cnode = queue.poll()
            if (colMap[cnode.col] == null) colMap[cnode.col] = mutableListOf()
            colMap[cnode.col]?.add(cnode.tnode.`val`)
            cnode.tnode.left?.let {
                queue.add(Node(cnode.col - 1, it))
                min = minOf(min, cnode.col - 1)
            }
            cnode.tnode.right?.let {
                queue.add(Node(cnode.col + 1, it))
                max = maxOf(max, cnode.col + 1)
            }
            size--
        }
    }

    var res = mutableListOf<MutableList<Int>>()
    for (i in min..max) colMap[i]?.let { res.add(it) }
    return res
}