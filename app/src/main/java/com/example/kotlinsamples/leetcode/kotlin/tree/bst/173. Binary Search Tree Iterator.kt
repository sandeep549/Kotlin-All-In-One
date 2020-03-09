package com.example.kotlinsamples.leetcode.kotlin.tree.bst

import com.example.kotlinsamples.leetcode.kotlin.tree.TreeNode
import java.util.*

private class BSTIterator(root: TreeNode?) {

    private var sortedList = mutableListOf<Int>()
    private var index = -1

    init {
        inroder(root)
    }

    private fun inroder(node: TreeNode?) {
        node?.let {
            inroder(it.left)
            sortedList.add(it.`val`)
            inroder(it.right)
        }
    }

    /** @return the next smallest number */
    fun next(): Int {
        return if (hasNext()) sortedList[++index] else -1
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return (index + 1) < sortedList.size
    }
}

private class BSTIterator2(root: TreeNode?) {
    private var stack = ArrayDeque<TreeNode>()

    init {
        traverseLeft(root)
    }

    private fun traverseLeft(root: TreeNode?) {
        var curr = root
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }
    }

    /** @return the next smallest number */
    fun next(): Int {
        if (!hasNext()) return -1
        var top = stack.pop()
        traverseLeft(top.right)
        return top.`val`
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return stack.size > 1
    }
}