package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

// Recursive
private fun postorder(root: NTreeNode?): List<Int> {
    var ans = mutableListOf<Int>()
    fun process(node: NTreeNode?) = node?.let { ans.add(it.`val`) }

    fun dfs(root: NTreeNode?) {
        root?.let {
            it.children?.let {
                for (node in it) dfs(node)
            }
            process(it)
        }
    }
    dfs(root)

    return ans
}

// iterative, not verified on leetcode, no env. available to run for this question
private fun postorder2(root: NTreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<NTreeNode>()
    if (root == null) {
        return result
    }

    stack.push(root)
    var cur = root
    var pre: NTreeNode? = null
    while (!stack.isEmpty()) {
        cur = stack.peek()
        if ((cur.children == null || cur.children!!.size == 0) || (pre != null && cur.children!!.contains(
                pre
            ))
        ) {
            result.add(cur.`val`)
            stack.pop() // remove stack top as its processed
            pre = cur // for backtracking
        } else {
            cur.children?.let {
                for (node in it.reversed()) stack.push(node)
            }
        }
    }

    return result
}