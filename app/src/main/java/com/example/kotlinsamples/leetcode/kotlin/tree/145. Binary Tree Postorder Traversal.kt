package com.example.kotlinsamples.leetcode.kotlin.tree

import java.util.*

/**
 * Traverse the element in order Root, RightSubTree, LeftSubTree, storing them in queue.
 * Return the reversed queue at last.
 * Or, while storing add element always at first position of queue, return as it is at last.
 * This solution is only correct to just correct answer, can create problem in topological dependencies. refer 2.
 */
private fun postorderTraversal(root: TreeNode?): List<Int> {
    val ansStack = ArrayDeque<Int>()
    val stack = ArrayDeque<TreeNode>()
    if (root == null) return ansStack.toList()

    stack.push(root)
    while (!stack.isEmpty()) {
        val cur: TreeNode = stack.pop()
        // This is array based and expensive in adding element at first.
        // LinkedList could have been best here if available in kotlin.
        ansStack.addFirst(cur.`val`)
        if (cur.left != null) {
            stack.push(cur.left)
        }
        if (cur.right != null) {
            stack.push(cur.right)
        }
    }
    return ansStack.toList()
}

// solution-2, iterative
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
            result.add(cur.`val`) // deal with topological dependency
            stack.pop() // stack top value is processed, remove it now
            pre = cur // for backtracking
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

// solution-3, same as 3, kotlin constrcut change
private fun postorderTraversal3(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<TreeNode>()

    root?.let {
        stack.push(root)
        var cur = root
        var pre: TreeNode? = null
        while (!stack.isEmpty()) {
            cur = stack.peek()
            if (cur!!.left == null && cur.right == null || pre != null && (pre == cur.left || pre == cur.right)) {
                result.add(cur.`val`) // deal with topological dependency
                stack.pop() // stack top value is processed, remove it now
                pre = cur // for backtracking
            } else {
                cur.right?.let { stack.push(cur.right) }
                cur.left?.let { stack.push(cur.left) }
            }
        }
    }

    return result
}