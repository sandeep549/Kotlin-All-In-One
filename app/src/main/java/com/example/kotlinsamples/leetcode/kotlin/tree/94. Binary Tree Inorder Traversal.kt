package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*
import kotlin.collections.ArrayList

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    fun dfs(node: TreeNode?) {
        if (node == null) return
        dfs(node.left)
        list.add(node.`val`)
        dfs(node.right)
    }
    dfs(root)
    return list
}

private fun inorderTraversal2(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    var curr = root
    val stack = ArrayDeque<TreeNode>()
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()
        list.add(curr.`val`)
        curr = curr.right
    }
    return list
}