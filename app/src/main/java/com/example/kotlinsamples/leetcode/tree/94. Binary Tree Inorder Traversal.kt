package com.example.kotlinsamples.leetcode.tree

import java.util.*
import kotlin.collections.ArrayList

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    fun traverse(node: TreeNode?) {
        if (node != null) {
            traverse(node.left)
            list.add(node.`val`)
            traverse(node.right)
        }
    }
    traverse(root)
    return list
}

private fun inorderTraversal2(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    var curr = root
    val stack = Stack<TreeNode>()
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