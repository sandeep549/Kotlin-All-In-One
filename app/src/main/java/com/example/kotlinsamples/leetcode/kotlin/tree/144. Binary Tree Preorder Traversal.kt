package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*
import kotlin.collections.ArrayList


private fun preorderTraversal(root: TreeNode?): List<Int> {
    val output: MutableList<Int> = ArrayList()
    fun dfs(root: TreeNode?) {
        root?.let {
            output.add(it.`val`)
            dfs(it.left)
            dfs(it.right)
        }
    }
    dfs(root)
    return output
}

//iterative-1
private fun preorderTraversal2(root: TreeNode?): List<Int> {
    val stack: ArrayDeque<TreeNode> = ArrayDeque()
    val output: MutableList<Int> = ArrayList()
    if (root == null) {
        return output
    }

    stack.add(root)
    while (!stack.isEmpty()) {
        val node: TreeNode = stack.pollLast()
        output.add(node.`val`)
        if (node.right != null) {
            stack.add(node.right)
        }
        if (node.left != null) {
            stack.add(node.left)
        }
    }
    return output
}

//iterative-2
// only store right children to the stack
private fun preorderTraversal3(root: TreeNode?): List<Int> {
    val list: MutableList<Int> = LinkedList()
    val rights = Stack<TreeNode>()
    var node = root
    while (node != null) {
        list.add(node.`val`)
        if (node.right != null) {
            rights.push(node.right)
        }
        node = node.left
        if (node == null && !rights.isEmpty()) {
            node = rights.pop()
        }
    }
    return list
}