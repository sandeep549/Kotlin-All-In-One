package com.example.kotlinsamples.leetcode.kotlin.z_ImportantCodeSnippet

import com.example.kotlinsamples.leetcode.kotlin.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayList

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

private fun inorderTraversal2(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    var curr = root
    val stack = ArrayDeque<TreeNode>() //Stack is legacy and deprecated
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

private fun postorderTraversal2(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<TreeNode>()
    if (root == null) {
        return result
    }

    stack.push(root)
    var cur = root
    var pre: TreeNode? = null
    while (!stack.isEmpty()) {
        cur = stack.peek()
        if (cur!!.left == null && cur.right == null || pre != null && (pre == cur.left || pre == cur.right)) {
            result.add(cur.`val`) //deal with topological dependency
            stack.pop() //stack top value is processed, remove it now
            pre = cur //for backtracking
        } else {
            if (cur.right != null) {
                stack.push(cur.right)
            }
            if (cur.left != null) {
                stack.push(cur.left)
            }
        }
    }

    return result
}