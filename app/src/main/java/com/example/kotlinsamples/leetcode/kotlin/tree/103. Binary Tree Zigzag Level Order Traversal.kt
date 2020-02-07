package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    var res = mutableListOf<MutableList<Int>>()
    if (root == null) return res
    var leftToRight = true
    var stack = ArrayDeque<TreeNode>()
    stack.push(root)
    while (!stack.isEmpty()) {
        var size = stack.size
        var level = mutableListOf<Int>()
        var tmp = ArrayDeque<TreeNode>()
        while (size > 0) {
            var node = stack.pop()
            level.add(node.`val`)
            if (leftToRight) {
                node.left?.let { tmp.push(it) }
                node.right?.let { tmp.push(it) }
            } else {
                node.right?.let { tmp.push(it) }
                node.left?.let { tmp.push(it) }
            }
            size--
        }
        res.add(level)
        leftToRight = !leftToRight
        stack = tmp
    }
    return res
}