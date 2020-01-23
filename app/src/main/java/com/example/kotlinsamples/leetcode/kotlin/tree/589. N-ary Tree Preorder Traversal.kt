package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

// Recursive
private fun preorder(root: NTreeNode?): List<Int> {
    var ans = mutableListOf<Int>()
    fun process(node: NTreeNode?) = node?.let { ans.add(it.`val`) }
    fun dfs(root: NTreeNode?) {
        root?.let {
            process(it)
            it.children?.let {
                for (i in it) preorder(i)
            }
        }
    }
    dfs(root)
    return ans
}

// iterative
private fun preorder2(root: NTreeNode?): List<Int> {
    var ans = mutableListOf<Int>()
    var stack = ArrayDeque<NTreeNode>()
    var root = root
    fun process(node: NTreeNode?) = node?.let { ans.add(it.`val`) }

    stack.push(root)
    while (!stack.isEmpty()) {
        var node = stack.pop()
        process(node)
        node.children?.let {
            for (i in it.reversed()) stack.push(i)
        }
    }
    return ans
}